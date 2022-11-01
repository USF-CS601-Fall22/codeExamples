package servlets;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * An example demonstrating how to create a simple message board using
 * jetty/servlets.
 * Courtesy of Prof. Engle.
 */
@SuppressWarnings("serial")
public class MessageServlet extends HttpServlet {
	private static final String TITLE = "Messages";

	private ConcurrentLinkedQueue<String> messages; // thread-safe, from the
													// concurrent package

	public MessageServlet() {
		super();
		messages = new ConcurrentLinkedQueue<>();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//response.setStatus(HttpServletResponse.SC_OK);

		PrintWriter out = response.getWriter();
		out.printf("<html>%n%n");
		out.printf("<head><title>%s</title></head>%n", TITLE);
		out.printf("<body>%n");

		out.printf("<h1>Message Board</h1>%n%n");

		// Keep in mind: multiple threads may access messages at once.
		// We do not provide synchronization here because we used a thread-safe
		// queue to store messages
		for (String message : messages) {
			out.printf("<p>%s</p>%n%n", message);
		}

		printForm(request, response);

		out.printf("<p>This request was handled by thread %s.</p>%n", Thread.currentThread().getName());

		out.printf("%n</body>%n");
		out.printf("</html>%n");

		response.setStatus(HttpServletResponse.SC_OK);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//response.setStatus(HttpServletResponse.SC_OK);

		String username = request.getParameter("username");
		String message = request.getParameter("message");

		username = (username == null || username.equals(""))  ? "anonymous" : username;
		message = message == null ? "" : message;

		// Avoid XSS attacks using Apache Commons StringUtils
		// Comment out if you don't have this library installed
		username = StringEscapeUtils.escapeHtml4(username);
		message = StringEscapeUtils.escapeHtml4(message);

		String formatted = String.format("%s<br><font size=\"-2\">[ posted by %s at %s ]</font>", message, username,
				getDate());

		// Keep in mind multiple threads may access at once
		messages.add(formatted);

		// Only keep the latest 5 messages
		if (messages.size() > 5) {
			String first = messages.poll();
		}

		response.setStatus(HttpServletResponse.SC_OK);
		response.sendRedirect(request.getServletPath());
	}

	private static void printForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();

		out.println("<form action=\"" + request.getServletPath() + "\" method = \"post\">");
		out.println("Name: <br>");
		out.println("<input type=\"text\" name=\"username\"><br>");

		out.println("Message: <br>");
		out.println("<input type=\"text\" name=\"message\">");
		out.println("<br><br>");
		out.println("<input type=\"submit\">");
		out.println("</form>");
	}

	private static String getDate() {
		String format = "hh:mm a 'on' EEEE, MMMM dd yyyy";
		DateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}
}