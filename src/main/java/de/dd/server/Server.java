package de.dd.server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import de.dd.model.DoppelkopfGame;
import de.dd.model.Player;

public class Server {
    private final int PORT = 14465;

    private ServerSocket server;
    private List<Client> clients;
    private DoppelkopfGame game;

    public Server() {
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            IO.println(e);
        }

        clients = new ArrayList<>();

        IO.println("This Server is so what from starting");

        waitForPlayers();

        IO.println("Ending Server");
    }

    private void waitForPlayers() {
        for (int i = 0; i < 4; i++) {
            Socket connection;
            PrintWriter out;
            BufferedReader in;
            try {
                connection = server.accept();
                IO.println("Connection received");
                IO.println(connection);
                out = new PrintWriter(connection.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
                IO.println(e);
                return;
            }
            if (!registerNewPlayer(in, out, connection))
                i--;
        }
    }

    private boolean registerNewPlayer(BufferedReader in, PrintWriter out, Socket connection) {
        String cmd;
        IO.println("Registering new Player");
        try {
            cmd = in.readLine();
            IO.println(cmd);
        } catch (IOException e) {
            IO.println(e);
            out.print("ERR connection");
            return false;
        }
        if (!cmd.startsWith("JOIN")) {
            IO.println(cmd);
            out.print("ERR invalid cmd");
            return false;
        }
        if (cmd.length() < 7) {
            IO.println(cmd);
            out.print("ERR invalid name");
        }
        String name = cmd.substring(5);
        Client client = new Client(name, in, out, connection);
        this.clients.add(client);
        IO.println("New player registered");
        IO.println(client);
        return true;
    }

}
