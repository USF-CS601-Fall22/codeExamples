package sockets;

import java.util.concurrent.*;
import java.net.*;
import java.io.*;

// From https://stackoverflow.com/questions/15541804/creating-the-serversocket-in-a-separate-thread
public class MultithreadedServer {

        public static final String EOT = "EOT";
        public static final String EXIT = "SHUTDOWN";
        public static final int PORT = 8000;
        private volatile boolean isShutdown = false;

        public static void main(String[] args) {

            new MultithreadedServer().startServer();
        }

        public void startServer() {
            final ExecutorService threads = Executors.newFixedThreadPool(4);

            Runnable serverTask = new Runnable() {

                @Override
                public void run() {
                    try {
                        ServerSocket welcomingSocket = new ServerSocket(PORT);
                        System.out.println("Waiting for clients to connect...");
                        while (!isShutdown) {
                            Socket clientSocket = welcomingSocket.accept();
                            threads.submit(new ClientTask(clientSocket));
                        }
                        if (isShutdown) {
                            welcomingSocket.close();
                        }
                    } catch (IOException e) {
                        System.err.println("Unable to process client request");
                        e.printStackTrace();
                    }
                }
            };
            Thread serverThread = new Thread(serverTask);
            serverThread.start();

        }

        private class ClientTask implements Runnable {
            private final Socket connectionSocket;

            private ClientTask(Socket connectionSocket) {
                this.connectionSocket = connectionSocket;
            }

            @Override
            public void run() {
                System.out.println("A client connected.");
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()))) {
                    String input;
                    while (!connectionSocket.isClosed()) {
                        input = reader.readLine();
                        // create HttpRequest that parses input
                        // create a handler
                        // handler.setAttribute(threadSafeHdata);
                        // handler.processRequest(httpRequest, printWriter)
                        System.out.println("Server received: " + input); // echo the same string to the console

                        if (input.equals(EOT)) {
                            System.out.println("Server: Closing socket.");
                            connectionSocket.close();
                        } else if (input.equals(EXIT)) {
                            isShutdown = true;
                            System.out.println("Server: Shutting down.");
                            connectionSocket.close();
                        }
                    }
                }
                catch (IOException e) {
                    System.out.println(e);
                }
                finally {
                    try {
                        if (connectionSocket != null)
                            connectionSocket.close();
                    }
                    catch (IOException e) {
                        System.out.println("Can't close the socket : " + e);
                    }


                }


            }
        }
}
