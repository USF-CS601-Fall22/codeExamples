package servlets.cookies;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Demonstrates how to create, use, and clear cookies. Vulnerable to attack
 * since cookie values are not sanitized prior to use!
 *
 * @see CookieBaseServlet
 * @see CookieVisitsServlet
 * @see CookieConfigServlet
 */
@SuppressWarnings("serial")
public class CookieVisitsServlet extends CookieBaseServlet {

	public static final String VISIT_DATE = "Visited";
	public static final String VISIT_COUNT = "Count";

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//log.info("GET " + request.getRequestURL().toString());

		if (request.getRequestURI().endsWith("favicon.ico")) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		prepareResponse("CookieServer", response);

		Map<String, String> cookies = getCookieMap(request);

		String visitDate = cookies.get(VISIT_DATE);
		String visitCount = cookies.get(VISIT_COUNT);

		PrintWriter out = response.getWriter();
		out.printf("<p>");

		// Update visit count as necessary and output information.
		if ((visitDate == null) || (visitCount == null)) {
			visitCount = "0";

			out.println("You have never been to this webpage before! ");
			out.println("Thank you for visiting.");
		}
		else {
			visitCount = Integer.toString(Integer.parseInt(visitCount) + 1);

			out.println("You have visited this website " + visitCount + " times.");
			out.printf("Your last visit was on " + visitDate);
		}

		out.println("</p>");

		// Checks if the browser indicates visits should not be tracked.
		// Try this in Safari private browsing mode.
		if (request.getIntHeader("DNT") != 1) {
			System.out.println("cookie: " + getDate());
			response.addCookie(new Cookie("Visited", getDate()));
			response.addCookie(new Cookie("Count", visitCount));
		}
		else {
			clearCookies(request, response);
			out.printf("<p>Your visits will not be tracked.</p>");
		}

		finishResponse(request, response);
	}
}