package com.eboot.server.commands.commandHandlers;

import com.eboot.server.ClientConnection;
import com.eboot.server.Server;

public interface CommandHandler {

    public void handle(Server server, ClientConnection sender, String message);
}
