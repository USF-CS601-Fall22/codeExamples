package servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/** An example demonstrating how to create a simple message board using jetty/servlets.
 *  Run MessageServer, then go to localhost:8080/messageBoard
 *  Courtesy of Prof. Engle.
 */
public class MessageServer {

	public static final int PORT = 8091;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(MessageServlet.class, "/messageBoard");
		server.setHandler(handler);
		server.start();
		server.join();
	}
}