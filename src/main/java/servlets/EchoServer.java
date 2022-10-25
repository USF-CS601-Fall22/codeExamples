package servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * A webserver that displays HTML form that allows a user to enter a message and submit it.
 * The server prints the message back to the user.
 *
 * Example courtesy of Prof. Rollins 
 */
public class EchoServer {

	public static final int PORT = 8082;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		
		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(EchoServlet.class, "/echo");
		 
		server.setHandler(handler);

		server.start();
		server.join();
	}
}