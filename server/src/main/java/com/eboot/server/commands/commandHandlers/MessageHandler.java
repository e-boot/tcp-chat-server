package com.eboot.server.commands.commandHandlers;

import com.eboot.server.ClientConnection;
import com.eboot.server.Server;

public class MessageHandler implements CommandHandler {
    @Override
    public void handle(Server server, ClientConnection sender, String message) {

        if (!isValid(message)){
            return;
        }

        server.broadcast(sender.getName() + ": " + message);
    }


    private boolean isValid(String message) {
        return  !message.trim().isEmpty();
    }
}
