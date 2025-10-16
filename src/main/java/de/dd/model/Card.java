package de.dd.model;

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
        if (
            this.color == CardColor.DIAMOND ||
            this.type == CardType.QUEEN ||
            this.type == CardType.JACK
            ) return true;
        return false;
    }

    public CardColor getColor() {
        return this.color;
    }
    public CardType getType() {
        return this.type;
    }
}
