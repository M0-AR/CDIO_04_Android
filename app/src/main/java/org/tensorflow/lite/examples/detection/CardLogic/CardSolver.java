package org.tensorflow.lite.examples.detection.CardLogic;

import java.util.ArrayList;

public class CardSolver {

    String suggestedMoves = "";



    public String solveGame(Pile[] tableauPile, Pile[] foundationPile)
    {

        checkForPlacementInFoundationPile(tableauPile,foundationPile);
        checkForRegularCardMovement(tableauPile);


        return suggestedMoves;
    }

    private void checkForPlacementInFoundationPile(Pile[] tableauPile, Pile[] foundationPile) {

        for (int i = 0; i < tableauPile.length; i++) {

            for (int j = 0; j < foundationPile.length; j++) {

                if (tableauPile[i].size() != 0) {

                    if (foundationPile[j].size() != 0) {

                        int valueOfCardOnFoundation = foundationPile[j].getCard(foundationPile[j].size() - 1).getRank().getValue();
                        int valueOfCurrentCard = tableauPile[i].getCard(tableauPile[i].size() - 1).getRank().getValue();
                        boolean sameSuit = foundationPile[j].getCard(foundationPile[j].size() - 1).getSuit() == tableauPile[i].getCard(tableauPile[i].size() - 1).getSuit();

                        if (valueOfCardOnFoundation == valueOfCurrentCard - 1 && sameSuit) {

                            suggestedMoves = suggestedMoves + "Move " + tableauPile[i].getCard(tableauPile[i].size() - 1) + " to pile number " + (j + 1) + "\n";

                            foundationPile[j].addCard(tableauPile[i].getCard(tableauPile[i].size() - 1));
                            tableauPile[i].removeCard(tableauPile[i].size() - 1);
                        }

                    } else {

                        int valueOfCurrentCard = tableauPile[i].getCard(tableauPile[i].size() - 1).getRank().getValue();

                        if (valueOfCurrentCard == 1) {
                            suggestedMoves = suggestedMoves + "Move " + tableauPile[i].getCard(tableauPile[i].size() - 1) + " to pile number " + (j + 1) + "\n";

                            foundationPile[j].addCard(tableauPile[i].getCard(tableauPile[i].size() - 1));
                            tableauPile[i].removeCard(tableauPile[i].size() - 1);
                        }
                    }
                }
            }
        }
    }


    private void checkForRegularCardMovement(Pile[] tableauPile){

        for (int i = 0; i < tableauPile.length; i++) {
            for (int j = 0; j < tableauPile.length; j++) {


                if (tableauPile[i].size() != 0 && tableauPile[j].size() != 0) {

                    int movingCardFrom = tableauPile[i].getCard(0).getRank().getValue();
                    int movingCardTo = tableauPile[j].getCard(tableauPile[j].size() - 1).getRank().getValue() - 1;
                    boolean cardsHaveDifferentColor = tableauPile[i].getCard(0).isRed() != tableauPile[j].getCard(tableauPile[j].size() - 1).isRed();
                    boolean notOnTheSameRow = tableauPile[i] != tableauPile[j];


                    if (movingCardFrom == movingCardTo && cardsHaveDifferentColor && notOnTheSameRow) {
                        suggestedMoves = suggestedMoves + "Move " + tableauPile[i].getCard(0) + " to " + tableauPile[j].getCard(tableauPile[j].size() - 1) + "\n";
                        for (int l = 0; l < tableauPile[i].size(); ) {
                            tableauPile[j].addCard(tableauPile[i].getCard(l));
                            tableauPile[i].removeCard(l);
                        }

                    }
                }
            }
        }
    }

    private void requestNewCard(Pile pile) {
        showNewCard(pile);
    }

    private void showNewCard(Pile pile) {

        Card newCard = null;
        pile.addCard(newCard);
    }

}



