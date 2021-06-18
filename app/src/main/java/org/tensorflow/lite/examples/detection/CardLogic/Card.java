package org.tensorflow.lite.examples.detection.CardLogic;

public class Card {

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean isRed() {
        return suit == Suit.H || suit == Suit.D;
    }

    @Override
    public String toString() {
        return getRank().printRank() +" of "+ getSuit().printSuit();
    }
}