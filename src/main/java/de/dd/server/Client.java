package de.dd.server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import de.dd.model.Player;

public class Client {
    String name;
    BufferedReader in;
    PrintWriter out;
    Socket connection;
    Player player;

    public Client(String name, BufferedReader in, PrintWriter out, Socket connection) {
        this.name = name;
        this.in = in;
        this.out = out;
        this.connection = connection;
    }

    public Client(String name, BufferedReader in, PrintWriter out, Socket connection, Player player) {
        this.name = name;
        this.in = in;
        this.out = out;
        this.connection = connection;
        this.player = player;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + connection + "\n" + player;
    }
}
