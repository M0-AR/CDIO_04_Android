package org.tensorflow.lite.examples.detection.CardLogic;
import java.util.ArrayList;
import java.util.List;

public abstract class Pile {

    private final List<Card> cards;

    public Pile() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void removeCard(int index) {
        cards.remove(index);
    }

    public Card getCard(int position) {
        return cards.get(position);
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }
}

