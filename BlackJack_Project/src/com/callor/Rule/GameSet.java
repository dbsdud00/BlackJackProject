package com.callor.Rule;

import java.util.ArrayList;
import java.util.List;

import com.callor.model.CardDto;

public class GameSet {
	
	private List<List<String>> wholeCard = new ArrayList<>();
		
	private CardDto heartCard = new CardDto();
	private CardDto diaCard = new CardDto();
	private CardDto cloverCard = new CardDto();
	private CardDto spadeCard = new CardDto();
	
	private String selectCard = "";
	private int rndType;
	private int rndNum;

	public void gameSet() {
		wholeCard.add(heartCard.newCard("Heart"));
		wholeCard.add(diaCard.newCard("DiaCard"));
		wholeCard.add(cloverCard.newCard("Clover"));
		wholeCard.add(spadeCard.newCard("Spade"));
	}
	
	public String drawCard() {
		
		while(true) {
			try {
				rndType = (int)(Math.random()*4);
				rndNum = (int)(Math.random() * wholeCard.get(rndType).size());
				selectCard = wholeCard.get(rndType).get(rndNum);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
		wholeCard.get(rndType).remove(rndNum);
		
		return selectCard;
		
	}
	
	public int scoreCheck() {
		
		String strScore = selectCard.split(" ")[1];
		int intScore = 0;
		try {
			intScore = Integer.valueOf(strScore);
		} catch (Exception e) {
			if (strScore.equals("A")) {
				return 1;
			}else if(strScore.equals("K")||strScore.equals("Q")||strScore.equals("J")) {
				return 10;
			}
			else {
				return 0;
			}
		}
		
		return intScore;
	}
	
	
	
	
}
