package de.dd.client;

import de.dd.client.ui.MainView;
import de.dd.model.DoppelkopfGame;

/**
 * Hello world!
 *
 */
public class App {
    private MainView view;
    private DoppelkopfGame game;

    public App() {
        view = new MainView();
        game = new DoppelkopfGame(null);
    }

    public static void main(String[] args) {
        MainView view = new MainView();
        DoppelkopfGame dp = new DoppelkopfGame(null);
        dp.startGame();
    }
}
