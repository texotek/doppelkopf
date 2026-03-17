package de.dd.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    final private CardColor color;
    final private CardType type;

    public Card(CardColor color, CardType type) {
        this.color = color;
        this.type = type;
    }

    public int getValue() {
        return this.type.getCardValue();
    }

    public boolean isTrump() {
        if (this.color == CardColor.DIAMOND ||
                this.type == CardType.QUEEN ||
                this.type == CardType.JACK)
            return true;
        if (this.color == CardColor.HEART && this.type == CardType.TEN)
            return true;
        return false;
    }

    public CardColor getColor() {
        return this.color;
    }

    public CardType getType() {
        return this.type;
    }

    public static List<Card> getCards() {
        List<Card> result = new ArrayList<>();
        for (CardColor cc : CardColor.values()) {
            for (CardType ct : CardType.values()) {
                result.add(new Card(cc, ct));
                result.add(new Card(cc, ct));
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String res = "";
        // switch (color) {
        // case DIAMOND:
        // res += "♦";
        // break;
        // case HEART:
        // res += "♥";
        // break;
        // case SPADE:
        // res += "♠";
        // break;
        // case CLUB:
        // res += "♣";
        // break;
        // }
        switch (type) {
            case NINE:
                res += "9";
                break;
            case TEN:
                res += "10";
                break;
            case JACK:
                res += "Jack";
                break;
            case QUEEN:
                res += "Queen";
                break;
            case KING:
                res += "King";
                break;
            case ACE:
                res += "Ace";
                break;
        }
        res += "\t";
        switch (color) {
            case DIAMOND:
                res += "of Diamonds";
                break;
            case HEART:
                res += "of Hearts";
                break;
            case SPADE:
                res += "of Spades";
                break;
            case CLUB:
                res += "of Clubs";
                break;
        }
        return res;
    }
}
