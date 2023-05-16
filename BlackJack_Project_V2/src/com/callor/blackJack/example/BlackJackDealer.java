package com.callor.blackJack.example;

import java.util.ArrayList;

public class BlackJackDealer extends Deck { // 덱의 자식클래스
	public static final int NUMBER_OF_DECKS = 4; // 하트 다이아 클로버 스페이드
	public static final double RESHUFFLE_RATE = 0.2;
	public static final int DEALER_STANDS_ON = 17;

	public static final int RESULT_DEALER_BUSTED = 1;
	public static final int RESULT_DEALER_WINS = 2;
	public static final int RESULT_GAMER_WINS = 3;
	public static final int RESULT_DRAW = 4;

	private ArrayList<Card> returned = new ArrayList<>();
	private BlackJackHand hand = new BlackJackHand(); // 딜러 덱

	@Override
	public void shuffle() { 
		cards.addAll(returned); // 게임이 끝나면 카드를 돌려받음
		returned.clear();	// 사용된 카드 초기화

		super.shuffle();	// 섞기
	}

	public void initialize() {	// cards 초기화
		for (int deck = 0; deck < NUMBER_OF_DECKS; deck++) {
			for (int suit = 1; suit <= 4; suit++) { // 1~4
				for (int rank = 1; rank <= 13; rank++) { // 1~13
					BlackJackCard newCard = new BlackJackCard(suit, rank);
					addCard(newCard); // cards 에 카드 초기화
				}
			}
		}

		super.shuffle(); // 카드 섞기
	}

	public void dealSelf() { // 2장 뽑아서 hand에 저장
		deal(hand, 2);
	}

	public BlackJackCard getDealersOpenCard() {
		if (!hand.cards.isEmpty()) { // 손이 안비었을 경우
			return (BlackJackCard) hand.cards.get(0); // 0번 카드를 숨길카드로 지정
		}

		return null;
	}

	public void printDealersHand() { // 딜러가 소유한 덱 모두 출력
		hand.print();
	}

	public int getDealersHandValue() {
		return hand.getValue();
	}

	public int showdown(BlackJackHand gamers) {
		while (hand.getValue() < DEALER_STANDS_ON) {
			hit(hand);
		}

		if (hand.isBusted()) {
			return RESULT_DEALER_BUSTED;
		} else if (gamers.getValue() == hand.getValue()) {
			return RESULT_DRAW;
		} else if (gamers.getValue() > hand.getValue()) {
			return RESULT_GAMER_WINS;
		} else {
			return RESULT_DEALER_WINS;
		}
	}

	public void hit(BlackJackHand hand) {
		hand.addCard(cards.remove(0));
	}

	public void returnHand(BlackJackHand gamers) {
		returned.addAll(gamers.cards);
		gamers.cards.clear();
	}

	public void returnDealersHand() {
		returnHand(hand);
	}

	public boolean needsShuffle() {
		return getRemainRate() < RESHUFFLE_RATE;
	}

	public void printLog() {
		System.out.println("[LOG] # of cards in returned: " + returned.size());
		System.out.println("[LOG] # of cards in shoe: " + cards.size());
		System.out.println("[LOG] Remain rate: " + getRemainRate());
	}

	private double getRemainRate() {
		return (double) cards.size() / (NUMBER_OF_DECKS * Card.NUMBER_OF_CARDS_IN_A_DECK);
	}
}