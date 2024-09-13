package com.eboot.server.commands.commandHandlers;

import com.eboot.server.ClientConnection;
import com.eboot.server.Server;
import com.eboot.server.commands.Command;

public class HelpHandler implements CommandHandler {
    @Override
    public void handle(Server server, ClientConnection sender, String message) {
        sender.send(Command.commandList());
    }
}
