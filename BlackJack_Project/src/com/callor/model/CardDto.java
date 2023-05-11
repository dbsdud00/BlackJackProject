package com.callor.model;

import java.util.ArrayList;
import java.util.List;

public class CardDto {
	private List<String> Card;
	public CardDto() {
		// TODO Auto-generated constructor stub
		Card = new ArrayList<>();
	}
	public List<String> newCard(String cardType) {
		Card.add(String.format("%s A", cardType));
		for (int i = 2; i< 11; i++ ) {
			Card.add(String.format("%s %d", cardType,i));	
		}
		Card.add(String.format("%s K", cardType));
		Card.add(String.format("%s Q", cardType));
		Card.add(String.format("%s J", cardType));
		return Card;
	}
}
