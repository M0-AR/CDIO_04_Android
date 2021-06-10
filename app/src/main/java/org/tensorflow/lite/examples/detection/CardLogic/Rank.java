package org.tensorflow.lite.examples.detection.CardLogic;




public enum Rank {

    ACE(1, "Ace"), TWO(2, "Two"), THREE(3, "Three"), FOUR(4, "Four"), FIVE(5, "Five"), SIX(6, "Six"), SEVEN(7, "Seven"),
    EIGHT(8, "Eight"), NINE(9, "Nine"), TEN(10, "Ten"), JACK(11, "Jack"), QUEEN(12, "Queen"), KING(13, "King");

    private final int value;
    private final String rank;

    Rank(int value, String rank) {
        this.value = value;
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public String printRank() {
        return rank;
    }

    public static Rank setRank(String value) {
        Rank rank;

        switch (value) {
            case "1": rank = Rank.ACE;
                break;
            case "2": rank = Rank.TWO;
                break;
            case "3": rank = Rank.THREE;
                break;
            case "4": rank = Rank.FOUR;
                break;
            case "5": rank = Rank.FIVE;
                break;
            case "6": rank = Rank.SIX;
                break;
            case "7": rank = Rank.SEVEN;
                break;
            case "8": rank = Rank.EIGHT;
                break;
            case "9": rank = Rank.NINE;
                break;
            case "10": rank = Rank.TEN;
                break;
            case "11": rank = Rank.JACK;
                break;
            case "12": rank = Rank.QUEEN;
                break;
            case "13": rank = Rank.KING;
                break;
            default: rank = null;
        }
        return rank;
    }

}
