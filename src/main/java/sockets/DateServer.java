package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * From http://cs.lmu.edu/~ray/notes/javanetexamples/
 * A TCP server that runs on port 9090. When a client connects, it sends the
 * client the current date and time, then closes the connection with that
 * client. Arguably just about the simplest server you can write.
 */
public class DateServer {

	/**
	 * Runs the server.
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(9091);
		try {
			while (true) {
				System.out.println("Waiting for clients to connect..");

				Socket socket = listener.accept();
				System.out.println("Client connection accepted");
				try {
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println(new Date().toString());
				} finally {
					socket.close();
				}
			}
		} finally {
			listener.close();
		}
	}
}