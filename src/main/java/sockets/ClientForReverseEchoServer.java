package sockets;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/** Client for ReverseEchoServer
 *  Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 */
public class ClientForReverseEchoServer extends Thread {
	public ClientForReverseEchoServer() {
		this.start();
	}

	public void run() {
		System.out.println("Client: Started...");
		System.out.println("port: " + ReverseEchoServer.PORT);
		Scanner sc = null;
		BufferedReader readerSocket = null;
		PrintWriter writer = null;

		// Assume the server runs on the local machine for now:
		try(Socket socket = new Socket("localhost", ReverseEchoServer.PORT)) {
			// For reading user input from the console (has nothing to do with
			// sockets!)
			sc = new Scanner(System.in);

			// For reading from the socket:
			readerSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// For writing to the socket (so that the server could get messages)
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

			String input;

			while (!socket.isClosed()) {
				input = sc.nextLine(); // read what the user typed in the console using Scanner

				writer.println(input); // send the message to the server via the socket

				String res = readerSocket.readLine(); // read the message from the server send via the socket
				System.out.println("Client received: " + res);

				if (input.equals(SimpleServer.EOT)) {
					System.out.println("Client: Ending client.");
					socket.close();
				} else if (input.equals(SimpleServer.SHUTDOWN)) {
					System.out.println("Client: Shutting down server.");
					socket.close();
				}
			}
		}
		catch (IOException ex) {
			System.out.println(ex);
		}
		finally {
			try {
				if (sc != null)
					sc.close();

				if (readerSocket != null)
					readerSocket.close();

				if (writer != null)
					writer.close();
			}
			catch (IOException e) {
				System.out.println("Could not close streams: " + e);
			}
		}
	}

	public static void main(String[] args) {
		new ClientForReverseEchoServer();
	}
}