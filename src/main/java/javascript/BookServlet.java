package javascript;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class BookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("in doGet");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        // returns a json object
        JsonObject book1 = new JsonObject();
        book1.addProperty("title", "Harry Potter");
        book1.addProperty("author", "Rowling");

        JsonObject book2 = new JsonObject();
        book2.addProperty("title", "Effective Java");
        book2.addProperty("author", "Joshua Bloch");

        JsonObject book3 = new JsonObject();
        book3.addProperty("title", "Elephants can remember");
        book3.addProperty("author", "Agatha Christie");

        JsonArray jarray = new JsonArray();
        jarray.add(book1);
        jarray.add(book2);
        jarray.add(book3);

        JsonObject obj = new JsonObject();
        obj.add("books",  jarray);
        out.println(obj);
        System.out.println(obj);
    }

}
