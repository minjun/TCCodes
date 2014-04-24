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
package server.connector.wsserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * Generates the demo HTML page which is served at http://localhost:8080/
 */
public final class WebSocketServerIndexPage {
    private static ByteBuf bf = null;

    public static ByteBuf getContent(String webSocketLocation) throws IOException {
	if (bf == null) {
	    StringBuffer sb = new StringBuffer();
	    BufferedReader in = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("index.html")));
	    while (true) {
		String line = in.readLine();
		if (line == null)
		    break;
		sb.append(line);
	    }
	    bf = Unpooled.copiedBuffer(sb.toString(), CharsetUtil.US_ASCII);
	}
	return bf;
    }

    private WebSocketServerIndexPage() {
	// Unused
    }
}
