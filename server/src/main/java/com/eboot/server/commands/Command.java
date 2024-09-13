package com.eboot.server.commands;

import com.eboot.server.commands.commandHandlers.*;

public enum Command {
    INVALID("", new InvalidHandler()),
    MESSAGE("", new MessageHandler()),
    HELP("help", new HelpHandler()),
    NEW_USER("", new NewUserHandler()),
    LIST("list", new ListHandler()),
    NAME("name", new NameHandler()),
    QUIT("quit", new QuitHandler());

private final String commandMessage;
private final CommandHandler handler;


Command (String commandMessage, CommandHandler handler) {
    this.commandMessage = commandMessage;
    this.handler = handler;
}

public static String commandList(){
    StringBuilder builder = new StringBuilder("\nCommands List:\n");

    for (Command command : values()) {
        if (!command.commandMessage.isEmpty()) {
            builder.append("/")
                    .append(command.commandMessage)
                    .append("\n");
        }
    }

    return builder.toString();
}

    public static Command getFromString(String message) {

        if (message == null) {
            return QUIT;
        }

        if (!message.startsWith("/")) {
            return MESSAGE;
        }

        String userCommand = message.split(" ")[0];

        for (Command command : values()) {
            if (userCommand.equals("/" + command.commandMessage)) {
                return command;
            }
        }

        return INVALID;
    }

    public CommandHandler getHandler() {
        return handler;
    }
}
