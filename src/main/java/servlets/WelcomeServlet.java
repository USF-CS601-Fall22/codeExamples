package servlets;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** An example that demonstrates how to process HTML forms with servlets. 
 *  Part of the example that also includes HtmlFormServer and HtmlFormServlet.
 */

@SuppressWarnings("serial")
public class WelcomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println();
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();
		out.printf("<html>%n%n");
		out.printf("<head><title>%s</title></head>%n", "Form");
		String name = request.getParameter("name");
		name = StringEscapeUtils.escapeHtml4(name);
		out.printf("<body>%n");
		
		// Displays Hello and the name of the person
		//out.printf("<h1>Hello, %s!</h1>%n%n", name);
		out.println("<h1>Hello, " + name + "</h1>" );

		out.printf("%n</body>%n");
		out.printf("</html>%n");

		response.setStatus(HttpServletResponse.SC_OK);
	}


}
