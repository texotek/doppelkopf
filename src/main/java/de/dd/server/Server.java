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

        IO.print("This Server is so what from starting");

        waitForPlayers();
    }

    private void waitForPlayers() {
        for (int i = 0; i < 4; i++) {
            Socket connection;
            PrintWriter out;
            BufferedReader in;
            try {
                connection = server.accept();
                out = new PrintWriter(connection.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
                IO.println(e);
                return;
            }
            registerNewPlayer(in, out, connection);
        }
    }

    private void registerNewPlayer(BufferedReader in, PrintWriter out, Socket connection) {
        String cmd;
        try {
            cmd = in.readLine();
        } catch (IOException e) {
            IO.println(e);
            out.print("ERR connection");
            return;
        }
        if (!cmd.startsWith("JOIN")) {
            out.print("ERR invalid cmd");
        }
        if (cmd.length() < 7) {
            out.print("ERR invalid name");
        }
        String name = cmd.substring(6);
        Client client = new Client(name, in, out, connection);
        this.clients.add(client);
    }

}
