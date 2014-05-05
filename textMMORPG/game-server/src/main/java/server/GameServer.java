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

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Simplistic telnet server.
 */
@Component("gameServer")
public final class GameServer {
	private final static Logger logger = LoggerFactory.getLogger(GameServer.class);
	
	private final int port = 8080;
	@Autowired
	GameServerInitializer gameServerInitializer; 

	/*
	public GameServer(int port) {
		this.port = port;
	}
	*/

	public void run() throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(gameServerInitializer);
			b.bind(port).sync().channel().closeFuture().sync();
		} catch (Exception e) {
			logger.error("Exception:", e);
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GameServer gameServer = (GameServer) context.getBean("gameServer");
		gameServer.run();
		context.close();
	}
}
