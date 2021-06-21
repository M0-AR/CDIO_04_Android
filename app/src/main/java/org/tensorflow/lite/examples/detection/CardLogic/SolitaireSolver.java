package org.tensorflow.lite.examples.detection.CardLogic;

import java.util.ArrayList;

public class SolitaireSolver {

    private ArrayList<String> suggestedMoves;


    public ArrayList<String> solveGame(Pile[] tableauPile, Pile[] foundationPile) {

        suggestedMoves = new ArrayList<>();

        checkForPlacementInFoundationPile(tableauPile, foundationPile);

        checkForRegularCardMovement(tableauPile);

        return suggestedMoves;
    }


    private void checkForPlacementInFoundationPile(Pile[] tableauPile, Pile[] foundationPile) {

        for (int i = 0; i < tableauPile.length; i++) {

            for (int j = 0; j < foundationPile.length; j++) {

                if (tableauPile[i] != null)
                    if (tableauPile[i].size() != 0) {

                        if (foundationPile[j].size() != 0) {

                            checkForRegularCardPlacementOnFoundation(tableauPile[i], foundationPile[j], j);

                        } else {

                            checkForAcePlacementOnFoundation(tableauPile[i], foundationPile[j], j);

                        }
                }
            }
        }
    }

    private void checkForRegularCardPlacementOnFoundation(Pile tableauPile, Pile foundationPile, int pileNumber){

        int valueOfCardOnFoundation = foundationPile.getCard(foundationPile.size() - 1).getRank().getValue();
        int valueOfCurrentCard = tableauPile.getCard(tableauPile.size() - 1).getRank().getValue();
        boolean sameSuit = foundationPile.getCard(foundationPile.size() - 1).getSuit() == tableauPile.getCard(tableauPile.size() - 1).getSuit();

        if (valueOfCardOnFoundation == valueOfCurrentCard - 1 && sameSuit) {

            moveCardToFoundation(tableauPile,foundationPile,pileNumber);
        }
    }

    private void checkForAcePlacementOnFoundation(Pile tableauPile, Pile foundationPile, int pileNumber) {

        int valueOfCurrentCard = tableauPile.getCard(tableauPile.size() - 1).getRank().getValue();
        if (valueOfCurrentCard == 1) {

            moveCardToFoundation(tableauPile,foundationPile,pileNumber);
        }
    }

    private void moveCardToFoundation(Pile tableauPile, Pile foundationPile, int pileNumber){

        int aceCard = tableauPile.size() -1 ;

        suggestedMoves.add("Move " + tableauPile.getCard(tableauPile.size() - 1) + " to pile number " + (pileNumber + 1));
        foundationPile.addCard(tableauPile.getCard(aceCard));
        tableauPile.removeCard(aceCard);

    }


    private void checkForRegularCardMovement(Pile[] tableauPile) {

        for (int i = 0; i < tableauPile.length; i++) {
            for (int j = 0; j < tableauPile.length; j++) {

                Pile movingCardRow = tableauPile[i];
                Pile stationaryCardRow = tableauPile[j];

                if (movingCardRow.size() != 0 && stationaryCardRow.size() != 0) {

                    int topCardPos = 0;
                    int buttomCardPos = stationaryCardRow.size() - 1;

                    int movingCardFrom = movingCardRow.getCard(topCardPos).getRank().getValue();
                    int movingCardTo = stationaryCardRow.getCard(buttomCardPos).getRank().getValue() - 1;

                    boolean cardsHaveDifferentColor = movingCardRow.getCard(topCardPos).isRed() != stationaryCardRow.getCard(buttomCardPos).isRed();
                    boolean notOnTheSameRow = movingCardRow != stationaryCardRow;


                    if (movingCardFrom == movingCardTo && cardsHaveDifferentColor && notOnTheSameRow) {

                        moveCardToOtherPile(tableauPile[i],tableauPile[j],topCardPos,buttomCardPos);

                    }

                }
            }
        }
    }


    private void moveCardToOtherPile(Pile movingCardRow, Pile stationaryCardRow, int topCardPos, int buttomCardPos) {

        suggestedMoves.add("Move " + movingCardRow.getCard(topCardPos) + " to " + stationaryCardRow.getCard(buttomCardPos));
        for (int l = 0; l < movingCardRow.size(); ) {
            stationaryCardRow.addCard(movingCardRow.getCard(l));
            movingCardRow.removeCard(l);
        }

    }



    public ArrayList<String> solveCardFromDeck(Pile[] tableauPile, Pile[] foundationPile, Card card) {
        suggestedMoves = new ArrayList<>();

        checkForPlacementInFoundationPile(card, foundationPile);

        checkForRegularCardMovement(tableauPile, card);

        return suggestedMoves;
    }

    private void checkForPlacementInFoundationPile(Card card, Pile[] foundationPile) {
        for (int i = 0; i < foundationPile.length; i++) {
            if (foundationPile[i].size() != 0)
                checkForRegularCardPlacementOnFoundation(card, foundationPile[i], i);
            else
                checkForAcePlacementOnFoundation(card, foundationPile[i], i);
        }
    }

    private void checkForAcePlacementOnFoundation(Card card, Pile foundationPile, int pileNumber) {
        int valueOfCurrentCard = card.getRank().getValue();
        if (valueOfCurrentCard == 1) {
            moveCardToFoundation(card,foundationPile,pileNumber);
        }
    }

    private void checkForRegularCardPlacementOnFoundation(Card card, Pile foundationPile, int pileNumber){
        int valueOfCurrentCard = card.getRank().getValue();
        int valueOfCardOnFoundation = foundationPile.getCard(foundationPile.size() - 1).getRank().getValue();
        boolean sameSuit = foundationPile.getCard(foundationPile.size() - 1).getSuit() == card.getSuit();

        if (valueOfCardOnFoundation == valueOfCurrentCard - 1 && sameSuit) {
            moveCardToFoundation(card,foundationPile,pileNumber);
        }
    }

    private void moveCardToFoundation(Card card, Pile foundationPile, int pileNumber){
        suggestedMoves.add("Move " + card + " to pile number " + (pileNumber + 1));
        foundationPile.addCard(card);
    }


    private void checkForRegularCardMovement(Pile[] tableauPile, Card card) {
        for (int i = 0; i < tableauPile.length; i++) {

            Pile movingCardRow = tableauPile[i];

            if (movingCardRow.size() != 0) {

                int topCardPos = 0;

                int movingCardFrom = card.getRank().getValue();
                int movingCardTo = movingCardRow.getCard(topCardPos).getRank().getValue() - 1;

                boolean cardsHaveDifferentColor = movingCardRow.getCard(topCardPos).isRed() != card.isRed();

                if (movingCardFrom == movingCardTo && cardsHaveDifferentColor) {

                    moveCardToOtherPile(card, tableauPile[i],topCardPos);

                }
            }
        }
    }


    private void moveCardToOtherPile(Card card, Pile movingCardRow, int topCardPos) {
        suggestedMoves.add("Move " + card + " to " + movingCardRow.getCard(topCardPos));
        movingCardRow.addCard(card);
    }
}





