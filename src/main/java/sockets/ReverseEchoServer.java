package sockets;

/*
* Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions
* are met:
*
*   - Redistributions of source code must retain the above copyright
*     notice, this list of conditions and the following disclaimer.
*
*   - Redistributions in binary form must reproduce the above copyright
*     notice, this list of conditions and the following disclaimer in the
*     documentation and/or other materials provided with the distribution.
*
*   - Neither the name of Oracle or the names of its
*     contributors may be used to endorse or promote products derived
*     from this software without specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
* IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
* THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
* PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
* EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
* PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
* PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
* LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

import java.net.*;
import java.io.*;

/** The server that reads strings from the input stream of the socket,
 *  reverses them and prints to the console */
public class ReverseEchoServer {
	public final static int PORT = 5534;
	
	public static void main(String[] args) throws IOException {
		ServerSocket welcomingSocket = null;
		Socket connectionSocket = null;
		try {
			welcomingSocket = new ServerSocket(ReverseEchoServer.PORT);
			System.out.println("Server started: waiting for connections on port " + ReverseEchoServer.PORT);
			connectionSocket = welcomingSocket.accept();
			System.out.println("EchoServer: EchoClient connected.");
			PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null && (!inputLine.equals("EXIT"))) { // stop when the client types EXIT
				String reversed = new StringBuffer(inputLine).reverse().toString();
				out.println(reversed);
				System.out.println("server: " + reversed);
			}
		} catch (IOException e) {
			System.out.println(
					"Exception caught when trying to listen on port " + ReverseEchoServer.PORT + " or listening for a connection");
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Bye!");
			if (welcomingSocket != null)
				welcomingSocket.close();
			if (connectionSocket != null)
				connectionSocket.close();
		}
	}
}
