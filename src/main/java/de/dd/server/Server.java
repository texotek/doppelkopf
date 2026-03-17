package de.dd.server;

import java.net.Socket;
import java.util.List;

import de.dd.model.DoppelkopfGame;
import de.dd.model.Player;

public class Server {

    private List<Player> players;
    private List<Socket> connections;
    private DoppelkopfGame game;

    public Server() {
        IO.print("This Server is so what from starting");
    }
}
