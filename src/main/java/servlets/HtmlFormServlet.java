package servlets;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/** An example that demonstrates how to process HTML forms with servlets.
 */
@SuppressWarnings("serial")
public class HtmlFormServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println();
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();
		out.printf("<html>%n%n");
		out.printf("<head><title>%s</title></head>%n", "Form");

		out.printf("<body>%n");
		// display HTML Form
		printForm(request, response);

		out.printf("%n</body>%n");
		out.printf("</html>%n");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// will be called when the user submits the html form
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		String nameParam = request.getParameter("name");
		if (nameParam == null)
			nameParam = "anonymous";
		nameParam = StringEscapeUtils.escapeHtml4(nameParam);

		PrintWriter out = response.getWriter();

		// Redirect to another url, send name in the get request
		// Going to this url will invoke a welcome servlet
		response.sendRedirect("/welcome?name=" + nameParam);
	}

	private static void printForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();

		out.printf("<form method=\"post\" action=\"%s\">%n", request.getServletPath());
		out.printf("Enter name:<br><input type=\"text\" name=\"name\"><br>");
		out.printf("<p><input type=\"submit\" value=\"Enter\"></p>\n%n");
		out.printf("</form>\n%n");
	}

}