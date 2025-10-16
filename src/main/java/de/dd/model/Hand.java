package de.dd.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    final private List<Card> cards;
    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public int getPlains() {
        int cPlain = 0;
        for (Card card : cards) {
            if (!card.isTrump()) cPlain++;
        }
        return cPlain;
    }

    public int getPlains(CardColor color) {
        int cPlain = 0;

        for (Card card : cards) {
            if (card.getColor() == color && !card.isTrump()) cPlain++;
        }

        return cPlain;
    }

    public int getTrumps() {
        return this.cards.size() - this.getPlains();
    }

    public void playCard(Card card) {
        boolean removed = cards.remove(card);
        if (!removed) throw new IllegalArgumentException("Card you want to remove did not exist in Hand");
    }

    public void playCard(int index) {
        try {
            cards.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Card you want to remove did not exist in Hand");
        }
    }
}
