package velocity;

import org.apache.velocity.app.VelocityEngine;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.nio.file.Paths;

/**
  A webserver that shows a list of hotels. Demonstrates how to use Velocity template engine.
  To test in the browser, run and go to localhost:8080/hotels
 */
public class HotelServer {

	public static final int PORT = 8080;

	public static void main(String[] args)  {

		Server server = new Server(8080);
		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		handler.addServlet(ShowHotelsServlet.class, "/hotels");

        // initialize Velocity
        VelocityEngine velocity = new VelocityEngine();
		velocity.init();

		// Set velocity as an attribute of the context so that we can access it
		// from servlets
        handler.setAttribute("templateEngine", velocity);
		server.setHandler(handler);

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}