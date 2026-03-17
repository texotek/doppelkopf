package de.dd.server;

public class App {
    public static void main() {
        Server server = new Server();
        while (true) {
            server.waitForPlayers();
            server.startGame();
        }
    }
}
