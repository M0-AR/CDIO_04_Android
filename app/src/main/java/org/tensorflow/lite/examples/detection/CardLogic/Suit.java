package org.tensorflow.lite.examples.detection.CardLogic;

public enum  Suit {

    HEARTS("Hearts"), SPADES("Spades"), DIAMONDS("Diamonds"), CLUBS("Clubs");

    private String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    String printSuit() {
        return suit;
    }
}
