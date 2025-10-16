package de.dd.model;

public class DoppelkopfGame {

    /*
     * long stack;
     * byte cards[] = new byte[12];
     * for (int i = 0; i < 12; i++) {
     * cards[i] = (byte)(stack & 0b11111);
     * stack >>= 5;
     * }
     * for (byte card in cards) {
     * int color = card & 3;
     * int type = (card & 56) >> 2;
     * }
     */
    // i = ((i >> 1) & 1) << 1 | (i & 1) | (i ^ i); // Modulo 1 << (1 << 1)

}
