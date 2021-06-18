package org.tensorflow.lite.examples.detection.CardLogic;

public enum  Suit {

    H("Hearts"), S("Spades"), D("Diamonds"), C("Clubs");

    private String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    String printSuit() {
        return suit;
    }
}
