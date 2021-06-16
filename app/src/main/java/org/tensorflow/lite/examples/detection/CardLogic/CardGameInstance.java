package org.tensorflow.lite.examples.detection.CardLogic;
import android.util.Log;

import org.tensorflow.lite.examples.detection.DetectorActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class CardGameInstance {

    public String startGame(HashSet<String> cameraCards){

        CardSolver Solver = new CardSolver();

        // TODO: 6/16/2021 Delete this later(find better solution)
        ArrayList<String> cameraCards_ = new ArrayList<>(cameraCards);
        
        ArrayList<String> stringCards = new ArrayList<String>();




        Pile[] piles = new TableauPile[7];
        piles[6] = new TableauPile();





        for (int i = 0; i < 6 ; i++) {

            String[] words = cameraCards_.get(i).split(" ");
            String suit = words[0].toUpperCase();


            Card cardIndex = new Card(Suit.valueOf(suit),Rank.setRank(words[1]));

            piles[i]=new TableauPile();
            piles[i].addCard(cardIndex);


        }

       return Solver.solveGame(piles);
    }




    private int findValueOfCard(String card){
        return Integer.parseInt(card);
    }

}
