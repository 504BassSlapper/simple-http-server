package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.utils.Constants.HTTP_PORT;

public class SimpleHttpServer {


    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(HTTP_PORT);
        System.out.println("Listening for connection on  port : " + HTTP_PORT);
        // infinite loop
        while (true) {
            final Socket clientSocket = server.accept();
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(isr);
            String line = bufferedReader.readLine();
            while (!line.isEmpty()) {
                System.out.println(line);
                line = bufferedReader.readLine();
                if(line == null){
                    clientSocket.close();
                    break;
                }
            }

        }
    }
}
