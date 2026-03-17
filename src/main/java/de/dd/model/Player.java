package de.dd.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public Hand hand;
    private int score;
    private List<Card> woncCards;

    public Player() {
        hand = new Hand(new ArrayList<Card>());
    }

    @Override
    public String toString() {
        return "Player: " + "\n" + "Score: " + score + "\n" + hand;
    }

    public List<Card> getWoncCards() {
        return woncCards;
    }

    public int getScore() {
        return score;
    }

    public void addWonCards(List<Card> cards) {
        woncCards.addAll(cards);
    }
}
