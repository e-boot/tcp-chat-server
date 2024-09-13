package com.eboot.server.commands.commandHandlers;

import com.eboot.server.ClientConnection;
import com.eboot.server.Server;

public class ListHandler implements CommandHandler {
    @Override
    public void handle(Server server, ClientConnection sender, String message) {

        sender.send(server.listClients());
    }
}
