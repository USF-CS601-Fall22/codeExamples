package javascript;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

/** AJAX example. ajaxEx.html file has javascript code that makes AJAX calls to the CounterServlet */
public class JSServerAjaxDemo {

	public static void main(String[] args) {

		// Example modified from Prof. Rollins' example 

		Server server = new Server(8080);

		ServletContextHandler servhandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

		// for ajaxEx example
		servhandler.addServlet(CounterServlet.class, "/counter");
		
		// for the ajaxDBDemo example
		servhandler.addServlet(AccessDatabaseServlet.class, "/students");


		ResourceHandler resource_handler = new ResourceHandler(); // a handler for serving static pages
		resource_handler.setDirectoriesListed(true);

		resource_handler.setResourceBase("static");

		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { resource_handler, servhandler });
		server.setHandler(handlers);

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			System.out.println("Exception occured while running the server: " + e);
		}

	}

}
