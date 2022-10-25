package servlets;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Demonstrates the important of cleaning parameters to avoid XSS attacks.
 * Courtesy of Prof. Engle */
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {

	/**
	 * A method that gets executed when the get request is sent to the
	 * HelloServlet
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		if (name == null || name.isEmpty())
			name = "anonymous";

		//System.out.println(name);
		//name = StringEscapeUtils.escapeHtml4(name); // need to "clean up" whatever
													// the user entered
		//System.out.println(name);
		// writing to the response
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello, " + name + "!</h1>");
		out.println("</body>");
		out.println("</html>");


		// Referencing Prof. Engle
		// If we did not call escapeHtml4,
		// if we just used the name (we read from the user) in our response,
		// our site would be prone to cross-site scripting attacks (XSS attacks)

		// You can comment out this line: name = StringEscapeUtils.escapeHtml4(name);
		// and uncomment the line below to disable security feature in the browser
		 response.setIntHeader("X-XSS-Protection", 0);
		// Then in the browser, try specifying the text below instead of the name:
		// ?name=<script>window.open("http://www.usfca.edu/");</script>
		// Did you see what happened? This script opened another page with usfca.edu website!

	}
}