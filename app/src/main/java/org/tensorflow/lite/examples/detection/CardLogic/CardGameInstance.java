package org.tensorflow.lite.examples.detection.CardLogic;
import java.util.ArrayList;


public class CardGameInstance {

    public void startGame(){

        CardSolver Solver = new CardSolver();

        ArrayList<Card> visibleCard = new ArrayList<Card>();
        ArrayList<String> stringCards = new ArrayList<String>();



        Pile[] piles = new TableauPile[7];





        stringCards.add("Hearts 6");
        stringCards.add("Spades 10");
        stringCards.add("Hearts 4");
        stringCards.add("Diamonds 3");
        stringCards.add("Spades 4");
        stringCards.add("Diamonds 5");
        stringCards.add("Hearts 9");




        for (int i = 0; i < stringCards.size() ; i++) {

            String[] words = stringCards.get(i).split(" ");
            String suit = words[0].toUpperCase();


            Card cardIndex = new Card(Suit.valueOf(suit),Rank.setRank(words[1]));

            piles[i]=new TableauPile();
            piles[i].addCard(cardIndex);


        }

        Solver.solveGame(piles);


    }




    private int findValueOfCard(String card){
        return Integer.parseInt(card);
    }

}
