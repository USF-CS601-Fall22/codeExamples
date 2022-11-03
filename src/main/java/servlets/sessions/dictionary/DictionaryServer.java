package servlets.sessions.dictionary;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import servlets.sessions.SessionServlet;

public class DictionaryServer {
    public final static int PORT = 8080;

    public static void main(String[] args)  {

        Dictionary englishToSpanishDictionary = new Dictionary();
        englishToSpanishDictionary.addWord("hello", "hola");
        englishToSpanishDictionary.addWord("bye", "adios");
        englishToSpanishDictionary.addWord("one", "uno");

        Server server = new Server(PORT);

        ServletContextHandler servhandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servhandler.addServlet(DictionaryServlet.class, "/translate");
        server.setHandler(servhandler);
        servhandler.setAttribute("dictionary", englishToSpanishDictionary);

        try {
            server.start();
            server.join();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

