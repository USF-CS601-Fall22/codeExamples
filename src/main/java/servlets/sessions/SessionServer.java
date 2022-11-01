package servlets.sessions;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Demonstrates how to use the HttpSession class to keep track of the number of visits for each client 
 * (and the date of the last visit).
 * Modified from the example of Prof. Rollins.
 *
 */
public class SessionServer {
	public final static int PORT = 8081;
	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		
        ServletContextHandler servhandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servhandler.addServlet(SessionServlet.class, "/session");
        server.setHandler(servhandler);
        //servhandler.setAttribute("data", "data");

		server.start();
		server.join();
	}
}