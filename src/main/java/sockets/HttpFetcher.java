package sockets;

import java.io.*;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Original author: Prof. Rollins. Modified by O. Karpenko.
 * HttpFetcher - shows how to sent an HTTP get request to a given webserver via the java program,
 * and how to get the response
 *
 */
public class HttpFetcher {

    public static int PORT = 80;

    /** Sends an HTTP request to fetch a given resource from the given host.
     *  Returns the response as a string.
     * @param host
     * @param pathAndResource
     * @return A string that contains HTML code.
     */
    public static String fetch(String host, String pathAndResource) {

        StringBuffer buf = new StringBuffer();

        try (Socket socket = new Socket(host, PORT)) { // create a connection to the
            // web server
            OutputStream out = socket.getOutputStream(); // get the output stream of the socket
            InputStream instream = socket.getInputStream(); // get the input stream of the socket

            // wrap the input stream to make it easier to read from
            BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

            // create and send request
            String request = getRequest(host, pathAndResource);
            System.out.println("Request = " + request);

            out.write(request.getBytes()); // send HTTP request to the server
            out.flush();

            // receive response
            // note: we are not removing the header (as we should have!)
            String line = reader.readLine();
            while (line != null) {
                buf.append(line + System.lineSeparator());
                line = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("HTTPFetcher::IOException occured during download: " + e.getMessage());
        }
        return buf.toString(); // header + all HTML code is in this string

    }

    /**
     * A method that creates a GET request for the given host and resource
     * @param host
     * @param pathResourceQuery
     * @return HTTP GET request returned as a string
     */
    private static String getRequest(String host, String pathResourceQuery) {
        String request = "GET " + pathResourceQuery + " HTTP/1.1" + System.lineSeparator() // GET
                // request
                + "Host: " + host + System.lineSeparator() // Host header required for HTTP/1.1
                + "Connection: close" + System.lineSeparator() // make sure the server closes the
                // connection after we fetch one page
                + System.lineSeparator();
        return request;
    }

    public static void main(String[] args) {

        String res = HttpFetcher.fetch("example.com", "/");
        // String res = HttpFetcher.fetch("www.baidu.com", "/s?wd=USFCA");
        // String res = HttpFetcher.fetch("www.nyu.edu", "/academics.html");

        System.out.println(res);

    }
}