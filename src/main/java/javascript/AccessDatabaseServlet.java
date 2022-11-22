package javascript;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessDatabaseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setStatus(HttpServletResponse.SC_OK);
		System.out.println("In AccessDatabaseServlet");
		// parse the request
		String query = request.getParameter("q");
		System.out.println(query);
		SimpleDatabaseHandler test = new SimpleDatabaseHandler(); // should move it to the server
		String res = test.getStudentInfo(query);
		System.out.println(res);

		// connect to the database and get student info
		// send student info to the client
		PrintWriter out = response.getWriter();
		
		out.println(res);
	}
	
	

}