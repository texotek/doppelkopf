package de.dd.model;

import java.util.List;

public class DoppelkopfGame {
    private List<Player> players;
    private int round;
    private int startingPlayer;
    private int activePlayer;

    public DoppelkopfGame(List<Player> players) {
        this.players = players;
        startingPlayer = 0;
    }

    public void startGame() {
        List<Card> cards = Card.mixCards(Card.getCards());
        for (Card c : Card.getCards())
            IO.println(c);
        for (Card c : cards)
            IO.println(c);

        // Initialising the starting parameters for the Game
        round = 0;
        activePlayer = startingPlayer;
        startingPlayer++;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getRound() {
        return round;
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public int getStartingPlayer() {
        return startingPlayer;
    }
}
