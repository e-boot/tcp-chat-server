package com.eboot.client;

import java.io.IOException;

public class ClientLauncher {
    /**
     * main method of the client application.
     * @param args the command line arguments; expects host and port
     */
    public static void main(String[] args) {

        if(args.length < 2) {
            System.out.println("Usage: <host> <port>");
            return;
        }

        try{
            Client client = new Client(args[0],Integer.valueOf(args[1]));
            client.start();

        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());

        }catch (NumberFormatException e) {
            System.err.println("Error port must be a valid number: " + args[1]);
        }
    }
}
