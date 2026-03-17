package de.dd.client;

import java.io.*;
import java.net.*;

import de.dd.client.ui.MainView;
import de.dd.model.DoppelkopfGame;

/**
 * Hello world!
 *
 */
public class App {
    private final int PORT = 14465;

    private MainView view;
    private DoppelkopfGame game;
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public App() {
        view = new MainView();
        try {
            client = new Socket("localhost", PORT);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        } catch (UnknownHostException e) {
            IO.println(e);
        } catch (IOException e) {
            IO.println(e);
        }
        connectToServer();
    }

    private void connectToServer() {
        out.println("JOIN test1");
        IO.println("joined");
        String cmd;
        try {
            cmd = in.readLine();
        } catch (IOException e) {
            IO.println(e);
            return;
        }
        IO.print(cmd);
    }

    public static void main(String[] args) {
        // MainView view = new MainView();
        // DoppelkopfGame dp = new DoppelkopfGame(null);
        new App();
        // dp.startGame();
    }
}
