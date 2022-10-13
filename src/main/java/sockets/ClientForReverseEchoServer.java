package sockets;

import java.io.*;
import java.net.*;

/** Client for ReverseEchoServer
 *  Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 */
public class ClientForReverseEchoServer extends Thread {
	public ClientForReverseEchoServer() {
		this.start();
	}

	public void run() {
		try {
			System.out.println("Client: Started...");
			System.out.println("port: " + ReverseEchoServer.PORT);
			
			// Assume the server runs on the local machine:
			Socket socket = new Socket("localhost", ReverseEchoServer.PORT);

			// For reading user input from the console (has nothing to do with
			// sockets!)
			BufferedReader readerKeyboard = new BufferedReader(new InputStreamReader(System.in));

			// For reading from the socket:
			BufferedReader readerSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// For writing to the socket (so that the server could get messages)
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

			String input = new String();

			while (!socket.isClosed()) {
				input = readerKeyboard.readLine(); // read what the user typed in the
											// console

				writer.println(input); // send the message to the server
				writer.flush();

				String res = readerSocket.readLine();
				System.out.println("Client received: " + res);

				if (input.equals(SimpleServer.EOT)) {
					System.out.println("Client: Ending client.");
					socket.close();
				} else if (input.equals(SimpleServer.EXIT)) {
					System.out.println("Client: Shutting down server.");
					socket.close();
				}
			}
			try {
				if (readerKeyboard != null)
					readerKeyboard.close();

				if (readerSocket != null)
					readerSocket.close();
				if (socket != null)
					socket.close();

			}
			catch (IOException e) {
				System.out.println("Could not close streams: " + e);
			}
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientForReverseEchoServer();
	}
}