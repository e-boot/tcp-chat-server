package com.eboot.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private final Socket socket;
    private final ExecutorService service;

    public Client (String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.service = Executors.newSingleThreadExecutor();
    }


    /**
      Starts the client and listens for messages from the server.
     */
    public void start(){
      try{
          BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

          while (!socket.isClosed()){
              waitMessage(reader);
          }
      } catch (Exception e) {
         System.err.println("Error establishing socket connection:" + e.getMessage());
      }
    }

    /**
     * waits for a message from server
     * @param reader the bufferedReader to read messages from
     * @throws IOException if an I/O error occurs when reading from the socket
     */
    private void waitMessage(BufferedReader reader) throws  IOException {
        String message = reader.readLine();

        if(message ==null) {
            System.out.println("Server has ended connection.");
            System.exit(0);
        }

        System.out.println(message);
    }
}
