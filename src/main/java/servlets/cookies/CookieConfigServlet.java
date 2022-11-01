package servlets.cookies;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Demonstrates how to create, use, and clear cookies. Vulnerable to attack
 * since cookie values are not sanitized prior to use!
 * Modified from the example of Prof. Engle
 * @see CookieBaseServlet
 * @see CookieConfigServlet
 */
@SuppressWarnings("serial")
public class CookieConfigServlet extends CookieBaseServlet {

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		prepareResponse("Configure", response);

		PrintWriter out = response.getWriter();
		out.println("<p>To clear saved cookies, please press \"Clear\".</p>");
		out.println();

		out.println("<form method=\"post\" action=\"" + request.getRequestURI() + " \">");
		out.println("\t<input type=\"submit\" value=\"Clear\">");
		out.println("</form>");

		finishResponse(request, response);
	}

	@Override
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {


		clearCookies(request, response);

		prepareResponse("Configure", response);

		PrintWriter out = response.getWriter();
		out.printf("<p>Your cookies for this site have been cleared.</p>%n%n");

		finishResponse(request, response);
	}
}