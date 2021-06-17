package org.tensorflow.lite.examples.detection.CardLogic;
import android.util.Log;

import org.tensorflow.lite.examples.detection.DetectorActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class CardGameInstance {

    private final Pile[] tableauPile;
    private final Pile[] foundationPile;
    private CardSolver solver;

    public CardGameInstance() {
        tableauPile = new TableauPile[1];
        foundationPile = new FoundationPile[4];
        solver = new CardSolver();

        for (int i = 0; i < tableauPile.length; i++) {
            tableauPile[i] = new TableauPile();
        }

        for (int i = 0; i < foundationPile.length; i++) {
            foundationPile[i] = new FoundationPile();
        }

    }

    public String startGame(HashSet<String> cameraCards) {

        CardSolver Solver = new CardSolver();

        // TODO: 6/16/2021 Delete this later(find better solution)
        ArrayList<String> cameraCards_ = new ArrayList<>(cameraCards);

        ArrayList<String> stringCards = new ArrayList<String>();


        for (int i = 0; i < 1; i++) {

            String[] words = cameraCards_.get(i).split(" ");
            String suit = words[0].toUpperCase();


            Card cardIndex = new Card(Suit.valueOf(suit), Rank.setRank(words[1]));

            tableauPile[i].addCard(cardIndex);


        }

        return Solver.solveGame(tableauPile, foundationPile);
    }
}



