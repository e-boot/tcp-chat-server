package com.eboot.server;

import com.eboot.server.commands.Command;
import com.eboot.server.commands.commandHandlers.CommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnection implements Runnable{

    private final Socket socket;
    private final Server server;
    private String name;
    private PrintWriter out;


    public ClientConnection(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }


    @Override
    public void run() {

        try {

            BufferedReader in = openStreams();

            enterUserName(in);
            send("Hello, " + name + " to list available commands: /help");

            if(!server.addClient(this)){
                send("Server is full try again later");
                close();
            }

            while (!socket.isClosed()) {
                listen(in);
            }
        }catch (IOException e) {
            System.err.println("Error connecting to client: " + e.getMessage());
            server.remove(this);
        }
    }

    private void listen(BufferedReader in) throws IOException {
        String message = in.readLine();
        CommandHandler clientInputHandler = Command.getFromString(message).getHandler();
        clientInputHandler.handle(server, this, message);
    }

    private void enterUserName(BufferedReader in) throws IOException {
        while (this.name == null) {
            send("Enter your username:");
            String name = in.readLine();
            CommandHandler newUserHandler = Command.NEW_USER.getHandler();
            newUserHandler.handle(server,this,name);
        }
    }

    private BufferedReader openStreams() throws IOException {
        out = new PrintWriter(socket.getOutputStream(),true);
        return new BufferedReader((new InputStreamReader(socket.getInputStream())));
    }


    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Error closing client socket: " + e.getMessage());
        }
    }

    public void send(String message) {
        out.println(message);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
