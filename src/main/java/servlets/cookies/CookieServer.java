package servlets.cookies;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Demonstrates how to create, use, and clear cookies. Vulnerable to attack
 * since cookie values are not sanitized prior to use!
 * Modified from the example of Prof. Engle.
 *
 * @see CookieBaseServlet
 * @see CookieVisitsServlet
 * @see CookieConfigServlet
 */
public class CookieServer {
	public final static int PORT = 8090;
	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(CookieVisitsServlet.class, "/");
		handler.addServletWithMapping(CookieConfigServlet.class, "/config");
		//handler.addServletWithMapping(SessionServlet.class, "/session");

		server.setHandler(handler);
		server.start();
		server.join();
	}
}