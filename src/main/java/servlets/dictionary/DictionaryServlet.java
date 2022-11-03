package servlets.dictionary;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DictionaryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();

        // Get the word from the get request
        String word = request.getParameter("word");
        word = StringEscapeUtils.escapeHtml4(word);

        Dictionary englishToSpanishDictionary = (Dictionary)getServletContext().getAttribute("dictionary");
        String spanishWord = englishToSpanishDictionary.translateToSpanish(word);
        if (spanishWord != null)
            out.println("The word " + word + " in spanish is " + spanishWord);

    }
}

