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
    private boolean firstCall = true;
    private static CardGameInstance cardGameInstance;

    private CardGameInstance() {
        tableauPile = new TableauPile[7];
        foundationPile = new FoundationPile[4];
        solver = new CardSolver();
    }

    public static CardGameInstance getInstance() {
        if (cardGameInstance == null)
            cardGameInstance = new CardGameInstance();

        return cardGameInstance;
    }

    public ArrayList<String> startGame(HashSet<String> cameraCards){

        ArrayList<String> cameraCards_ = new ArrayList<>(cameraCards);

        if (firstCall) {

            for (int i = 0; i < foundationPile.length ; i++) {
                foundationPile[i] = new FoundationPile();
            }

            for (int i = 0; i < cameraCards_.size() ; i++) {

                String suit =  String.valueOf(cameraCards_.get(i).charAt(0));
                String rank = (cameraCards_.get(i).length() == 2) ? String.valueOf(cameraCards_.get(i).charAt(1)) :
                        String.valueOf(cameraCards_.get(i).charAt(1)) + cameraCards_.get(i).charAt(2);



                Card cardIndex = new Card(Suit.valueOf(suit),Rank.setRank(rank));

                tableauPile[i] = new TableauPile();
                tableauPile[i].addCard(cardIndex);
            }
            firstCall = false;

            return solver.solveGame(tableauPile,foundationPile);
        }
        else {
            boolean isAllColumnsAreFull = true;
            Card card = null;

            for (int i = 0; i < cameraCards_.size(); i++) {

                String suit =  String.valueOf(cameraCards_.get(i).charAt(0));
                String rank = (cameraCards_.get(i).length() == 2) ? String.valueOf(cameraCards_.get(i).charAt(1)) :
                        String.valueOf(cameraCards_.get(i).charAt(1)) + cameraCards_.get(i).charAt(2);

                card = new Card(Suit.valueOf(suit),Rank.setRank(rank));

                for (Pile pile : tableauPile) {
                    if (pile.getCards().size() == 0) {
                        pile.getCards().add(card);
                        isAllColumnsAreFull = false;
                        break;
                    }
                }
            }

            if (isAllColumnsAreFull) {
                return solver.solveCardFromDeck(tableauPile, foundationPile, card);
            }

            return solver.solveGame(tableauPile,foundationPile);
        }
    }
}
