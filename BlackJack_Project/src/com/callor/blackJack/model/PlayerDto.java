package com.callor.blackJack.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerDto {
	private int score;
	private List<String> cardList;
	private String playerName;
	
	public PlayerDto() {
		setScore(0);
		cardList = new ArrayList<>();
	}
	public PlayerDto(String name) {
		setScore(0);
		cardList = new ArrayList<>();
		setPlayerName(name);
	}
	
	public List<String> getCardList() {
		return cardList;
	}

	public void setCardList(List<String> cardList) {
		this.cardList = cardList;
	}
	
	public void addCardList(String card) {
		this.cardList.add(card);
	}


	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public void showList() {
		System.out.printf("현재 %s가 가진 카드 : ", getPlayerName());
		int i = 0;
		for (String card : cardList) {
			System.out.print(card);
			if ( ++i < cardList.size()) {
				System.out.printf(", ");
			}
		}
	}
	
}
