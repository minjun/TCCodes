/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simplistic telnet client.
 */
public class GameClient implements Runnable {

    private final String host;
    private final int port;
    private final static Logger logger = LoggerFactory.getLogger(GameClient.class);
    private final LinkedList<String> messages = new LinkedList<String>();
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public GameClient(String host, int port) {
	this.host = host;
	this.port = port;
    }

    @Override
    public void run() {
	EventLoopGroup group = new NioEventLoopGroup();
	try {
	    Bootstrap b = new Bootstrap();
	    b.group(group).channel(NioSocketChannel.class).handler(new GameClientInitializer());

	    // Start the connection attempt.
	    Channel ch = b.connect(host, port).sync().channel();

	    // Read from message queue and write to server
	    lock.lock();
	    while (true) {
		condition.await();
		if (messages.size() >0) {
		    
		}
	    }
	    ChannelFuture lastWriteFuture = null;
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    for (;;) {
		String line = in.readLine();
		if (line == null) {
		    break;
		}

		// Sends the received line to the server.
		lastWriteFuture = ch.writeAndFlush(line + "\r\n");

		// If user typed the 'bye' command, wait until the server closes
		// the connection.
		if ("bye".equals(line.toLowerCase())) {
		    ch.closeFuture().sync();
		    break;
		}
	    }

	    // Wait until all messages are flushed before closing the channel.
	    if (lastWriteFuture != null) {
		lastWriteFuture.sync();
	    }
	} catch (Exception e) {
	    logger.error("Exception:", e.getMessage(), e);
	} finally {
	    group.shutdownGracefully();
	}
    }

    public static void main(String[] args) throws Exception {
	// Print usage if no argument is specified.
	if (args.length != 2) {
	    System.err.println("Usage: " + GameClient.class.getSimpleName() + " <host> <port>");
	    return;
	}

	// Parse options.
	String host = args[0];
	int port = Integer.parseInt(args[1]);

	new GameClient(host, port).run();
    }
}
