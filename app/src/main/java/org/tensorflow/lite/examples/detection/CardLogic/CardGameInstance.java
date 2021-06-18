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
        tableauPile = new TableauPile[7];
        foundationPile = new FoundationPile[4];
        solver = new CardSolver();
    }

    public String startGame(HashSet<String> cameraCards){

        for (int i = 0; i < foundationPile.length ; i++) {
            foundationPile[i] = new FoundationPile();
        }


        CardSolver Solver = new CardSolver();

        // TODO: 6/16/2021 Delete this later(find better solution)
        ArrayList<String> cameraCards_ = new ArrayList<>(cameraCards);
        
        ArrayList<String> stringCards = new ArrayList<String>();


        for (int i = 0; i < cameraCards_.size() ; i++) {

            String suit =  String.valueOf(cameraCards_.get(i).charAt(0));
            String rank = (cameraCards_.get(i).length() == 2) ? String.valueOf(cameraCards_.get(i).charAt(1)) :
                    String.valueOf(cameraCards_.get(i).charAt(1)) + cameraCards_.get(i).charAt(2);



            Card cardIndex = new Card(Suit.valueOf(suit),Rank.setRank(rank));

            tableauPile[i] = new TableauPile();
            tableauPile[i].addCard(cardIndex);
        }

       return Solver.solveGame(tableauPile,foundationPile);
    }




    private int findValueOfCard(String card){
        return Integer.parseInt(card);
    }

}
