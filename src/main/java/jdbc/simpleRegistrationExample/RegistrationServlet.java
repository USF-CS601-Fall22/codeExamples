package jdbc.simpleRegistrationExample;

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
public class RegistrationServlet extends HttpServlet {

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
		printForm(request, response);

		out.printf("%n</body>%n");
		out.printf("</html>%n");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		String usernameParam = request.getParameter("name");
		usernameParam = StringEscapeUtils.escapeHtml4(usernameParam);
		String password = request.getParameter("pass");
		password = StringEscapeUtils.escapeHtml4(password);

		DatabaseHandler dbHandler = DatabaseHandler.getInstance();
		dbHandler.registerUser(usernameParam, password);

		response.getWriter().println("Successfully registered the user " + usernameParam);
	}

	private static void printForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();

		out.printf("<form method=\"post\" action=\"%s\">%n", request.getServletPath());
		out.printf("Enter your username:<br><input type=\"text\" name=\"name\"><br>");
		out.printf("Enter your password:<br><input type=\"password\" name=\"pass\"><br>");
		out.printf("<p><input type=\"submit\" value=\"Enter\"></p>\n%n");
		out.printf("</form>\n%n");
	}

}