# TCP Chat Server

## Overview

A multi-client TCP chat server built with Java using Maven. This server supports concurrent client connections and echoes back messages sent by clients.

## Features
- **Multi-client support**: Handles multiple clients simultaneously using threads.
- **Echo server**: Echoes back received messages to all connected clients.
- **Thread management**: Uses an `ExecutorService` to manage client connections.
- **Handle commands**: like /help, /quit, /list (...)



### Project Structure
- `src/main/java/com/eboot/server/serverLauncher`: Entry point of server application.

- `src/main/java/com/eboot/server/Server.java`: Main server class that handles client connections and communication.

- `src/main/java/com/eboot/server/ClientConnection.java`: Handles individual client connections and message processing.
- `pom.xml: Maven configuration file.`


### Acknowledgements

- Understanding multithreading in Java and how it interacts with Java processes.
- Techniques for synchronizing threads to ensure safe concurrent execution.
- Managing thread execution and system resources effectively.
- Differentiating between implicit and explicit methods of creating threads.
- Addressing issues related to visibility, atomicity, and ordering in concurrent programming.
