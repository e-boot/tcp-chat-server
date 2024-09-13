package com.eboot.server.commands.commandHandlers;

import com.eboot.server.ClientConnection;
import com.eboot.server.Server;

public class QuitHandler implements CommandHandler {

    @Override
    public void handle(Server server, ClientConnection sender, String message) {

        server.remove(sender);
        server.broadcast(sender.getName() +" exit the chatroom.");
        sender.close();
    }
}
