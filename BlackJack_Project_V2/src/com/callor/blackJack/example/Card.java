package com.callor.blackJack.example;

public class Card {
    public static final int NUMBER_OF_CARDS_IN_A_DECK = 52; // 카드 수 
    public final int suitNumber; // 1:클로버, 2: 다이아몬드 , 3: 하트, 4:스페이드
    public final int rankNumber; // 카드 숫자 A,2,3,4,5,6,7,8,9,K,Q,J

    public Card(int suitNumber, int rankNumber) {
        this.suitNumber = suitNumber;
        this.rankNumber = rankNumber;
    }

    public String getSuit() {
        switch (suitNumber) {
            case 1:
                return "Clubs";
            case 2:
                return "Diamonds";
            case 3:
                return "Hearts";
            case 4:
                return "Spades";
            default:
                return "";
        }
    }

    public String getRank() {
        switch (rankNumber) {
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return String.valueOf(rankNumber);
        }
    }

    public String toString() {
        return getRank() + " of " + getSuit();
    }
}