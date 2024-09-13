package com.eboot.server.commands.commandHandlers;

import com.eboot.server.ClientConnection;
import com.eboot.server.Server;
import com.eboot.server.commands.Command;

public class NameHandler implements CommandHandler {
    @Override
    public void handle(Server server, ClientConnection sender, String message) {

        if(!isValid(message)){
            Command.INVALID.getHandler().handle(server,sender,"name is already token");
            return;
        }

        String newName = message.split(" ")[1];

        if(server.getClientByName(newName) != null){
            Command.INVALID.getHandler().handle(server,sender,"nam is already token");
            return;
        }

        server.broadcast(sender.getName()+ " changed username to" + newName);
        sender.setName(newName);
    }


    private boolean isValid(String message) {
        return message.split(" ").length == 2;
    }

}

