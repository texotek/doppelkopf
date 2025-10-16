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
}
