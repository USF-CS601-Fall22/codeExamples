package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** SimpleHelloServlet for the SimpleHelloServer example */
@SuppressWarnings("serial")
public class SimpleHelloServlet extends HttpServlet {

	/** A method that gets executed when the get request is sent to the SimpleHelloServlet */
	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		PrintWriter out = response.getWriter();
		// writing to the response 
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello, friends!</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}