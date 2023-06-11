package org.example;

import org.example.utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(Constants.HTTP_PORT);
        System.out.println("Listening for connection on port : " + Constants.HTTP_PORT);
        // infinite loop
        while (true) {
            try(final Socket socket = server.accept()){
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK \r\n\r\n"+today;
                // send response to client
                socket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
            }
        }
    }
}
