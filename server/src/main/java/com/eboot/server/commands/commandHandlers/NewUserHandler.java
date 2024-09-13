package com.eboot.server.commands.commandHandlers;

import com.eboot.server.ClientConnection;
import com.eboot.server.Server;
import com.eboot.server.commands.Command;

public class NewUserHandler implements CommandHandler {


    @Override
    public void handle(Server server, ClientConnection sender, String name) {

        if(!isValid(name)){
            Command.INVALID.getHandler().handle(server,sender,"Invalid user name. Should have between 4-16 Characters");
            return;
        }
        if(server.getClientByName(name) != null){
            Command.INVALID.getHandler().handle(server,sender,"this username is already token");
            return;
        }

        sender.setName(name);
        server.broadcast(sender.getName() + " has entered the chatroom");

    }

    private boolean isValid(String name) {
        return !(name.split(" ").length > 4) || !(name.length() > 16);
    }
}
