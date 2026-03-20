package de.dd.server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import de.dd.model.*;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

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
        IO.println("Ending Server");
    }

    public void waitForPlayers() {
        for (Client c : clients) {
            Socket socket = c.connection;
            if (!socket.isConnected())
                clients.remove(c);
        }

        for (; clients.size() < 4;) {
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
            try {
                registerNewPlayer(in, out, connection);
            } catch (SocketException e) {
                IO.println("Got one");
            }
        }
    }

    private boolean registerNewPlayer(BufferedReader in, PrintWriter out, Socket connection) throws SocketException {
        String cmd;
        IO.println("Registering new Player");
        String name;
        while (true) {
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
                continue;
            }
            name = cmd.substring(5);
            boolean taken = false;
            for (Client c : clients) {
                if (c.name == name) {
                    out.println("ERR username taken");
                    taken = true;
                    break;
                }
            }
            if (!taken) {
                break;
            }
        }
        Client client = new Client(name, in, out, connection, new Player());
        int id = this.clients.size();
        this.clients.add(client);
        out.println("SUCCESS " + id);
        IO.println("New player registered");
        IO.println(client);
        return true;
    }

    public void startGame() {
        IO.println("New Game starting");
        for (Client c : clients) {
            IO.println(c.name + ": " + (c.connection));
            try {
                c.out.println("Test");
            } catch (Exception e) {
                IO.println(e);
            }
        }
        Jsonb jsonb = JsonbBuilder.create();
        List<Player> players = new ArrayList<>();
        for (Client c : clients) {
            players.add(c.player);
        }
        List<Hand> hands = Card.getMixedHands();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
        for (int i = 0; i < 4; i++) {
            players.get(i).hand = hands.get(i);
        }
        game = new DoppelkopfGame(players);
        IO.println(jsonb.toJson(game));
    }

}
