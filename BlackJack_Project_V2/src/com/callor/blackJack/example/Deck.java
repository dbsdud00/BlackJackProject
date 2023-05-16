package com.callor.blackJack.example;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    protected ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) { // 카드 덱에 카드 추가
        cards.add(card);
    }

    public ArrayList<Card> getCards() {	// 카드 덱 리턴
        return cards;
    }
    
    public void print() {				// 카드 덱 안의 모든 카드 출력
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public void shuffle() { // 덱 안의 카드 섞기
        Random random = new Random();

        for (int i = 0; i < cards.size(); i++) {
            int randIndex = random.nextInt(cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(randIndex));
            cards.set(randIndex, temp);
        }
    }

    public void deal(Deck hand, int count) { // count수 만큼 카드 뽑아서 hand덱에 저장
        for (int i = 0; i < count; i++) {
            if (cards.size() < 1) // 뽑을 카드가 없으면 끝내기
                break;

            hand.cards.add(cards.remove(0));
        }
    }
}