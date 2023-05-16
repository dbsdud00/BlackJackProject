package com.callor.blackJack.example;

public class BlackJackCard extends Card { // 카드의 자식 클래스 블랙잭 카드
    public BlackJackCard(int suitNumber, int rankNumber) {
        super(suitNumber, rankNumber);
    }

    public int getValue() {  // 스코어 얻기
        switch (rankNumber) {
            case 1:
                return 11;
            case 11:
            case 12:
            case 13:
                return 10;
            default:
                return rankNumber;
        }
    }

    public boolean isAce() {	// rankNumber 가 A 일 경우 1점
        return rankNumber == 1;
    }
}