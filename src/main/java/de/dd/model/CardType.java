package de.dd.model;

public enum CardType {
    NINE(0),
    TEN(10),
    ACE(11),
    JACK(2),
    QUEEN(3),
    KING(4);
    private final int cardValue;
    private CardType(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getCardValue() {
        return this.cardValue;
    }
}
