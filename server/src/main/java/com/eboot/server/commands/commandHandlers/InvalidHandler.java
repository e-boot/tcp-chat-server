package com.eboot.server.commands.commandHandlers;

import com.eboot.server.ClientConnection;
import com.eboot.server.Server;

public class InvalidHandler implements  CommandHandler{

    @Override
    public void handle(Server server, ClientConnection sender, String message) {
        sender.send("Error :" + (message.startsWith("/") ?"Invalid command" : message));
    }
}
