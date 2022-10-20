package sockets;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * SimpleClient: Reads input from the keyboard and sends it to the server via
 * the socket. File is modified from the code of Prof. Engle
 *
 */
public class SimpleClient extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("Client: Started...");
			// Sends a connection request to the server that is running on
			// a given host, "listening" on the given port
			//Socket socket = new Socket("g1212.cs.usfca.edu", SimpleServer.PORT); // use on campus

			Socket socket = new Socket("localhost", SimpleServer.PORT); // running on the local machine

			// For reading user keyboard input from the console
			// (has nothing to do with sockets!)
			//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc  = new Scanner(System.in);

			// For writing to the socket (so that the server could get client messages)
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

			String input = new String();
			while (!socket.isClosed()) {
				//input = reader.readLine(); // read what the user typed in the
											// console
				input = sc.nextLine();

				writer.println(input); // send the message to the server via the
										// socket
				writer.flush();

				if (input.equals(SimpleServer.EOT)) {
					System.out.println("Client: Ending client.");
					socket.close();
				} else if (input.equals(SimpleServer.SHUTDOWN)) {
					System.out.println("Client: Shutting down server.");
					socket.close();
				}
			}

			//reader.close();
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SimpleClient client = new SimpleClient();
		client.start();
		try {
			client.join();
		} catch (InterruptedException e) {
			System.out.println("The thread got interrupted " + e);
		}
	}
}