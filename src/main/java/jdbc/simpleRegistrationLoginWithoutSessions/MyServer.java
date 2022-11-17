package jdbc.simpleRegistrationLoginWithoutSessions;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class MyServer {

	public static final int PORT = 8083;

	public static void main(String[] args) throws Exception {
		DatabaseHandler dhandler = DatabaseHandler.getInstance();
		//dhandler.createTable();

		Server server = new Server(PORT);
		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(RegistrationServlet.class, "/register");
		handler.addServletWithMapping(LoginServlet.class, "/login");

		server.setHandler(handler);
		server.start();
		server.join();
	}
}