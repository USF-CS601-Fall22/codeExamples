package servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * A simple web server that sends the same response for each GET request (an
 * html page that says Hello, friends!)
 * Courtesy of Prof. Engle
 */
public class HelloServer {

	public static final int PORT = 8081;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		
		// We could also setup the connector component explicitly
		//ServerConnector connector = new ServerConnector(server);
		//connector.setHost("localhost");
		//connector.setPort(PORT);
		//server.addConnector(connector);
		
		ServletHandler handler = new ServletHandler();

		// when the user goes to http://localhost:8080/hello, the get request is
		// going to go to a HelloServlet
		handler.addServletWithMapping(HelloServlet.class, "/hello");
		 
		server.setHandler(handler);

		server.start();
		server.join();
	}
}