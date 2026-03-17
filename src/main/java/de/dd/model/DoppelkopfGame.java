package de.dd.model;

import java.util.List;
import java.util.Random;

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
        List<Card> cards = mixCards(Card.getCards());
        for (Card c : Card.getCards())
            IO.println(c);
        for (Card c : cards)
            IO.println(c);

        // Initialising the starting parameters for the Game
        round = 0;
        activePlayer = startingPlayer;
        startingPlayer++;
    }

    private List<Card> mixCards(List<Card> cards) {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            swap(cards, i, random.nextInt(cards.size()));
        }
        return cards;
    }

    private void swap(List<Card> cards, int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

}
