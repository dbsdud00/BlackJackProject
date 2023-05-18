package com.callor.blackJack.set;

import java.util.ArrayList;
import java.util.List;

import com.callor.blackJack.model.CardCreate;
import com.callor.blackJack.model.PlayerDto;
import com.callor.blackJack.utils.AnsiConsol;

public class GameSetV1 implements GameSet {
	
	private List<List<String>> wholeCard;
	private String selectCard = "";
	private int rndType;
	private int rndNum;
	
	public GameSetV1() {
		// TODO Auto-generated constructor stub
		wholeCard = new ArrayList<>();
	}

	public void cardSet() {
		
		CardCreate heartCard = new CardCreate();
		CardCreate diaCard = new CardCreate();
		CardCreate cloverCard = new CardCreate();
		CardCreate spadeCard = new CardCreate();
		
		wholeCard.add(heartCard.newCard(AnsiConsol.message("red", "♥")));
		wholeCard.add(diaCard.newCard(AnsiConsol.message("red", "◆")));
		wholeCard.add(cloverCard.newCard(AnsiConsol.message("black", "♣")));
		wholeCard.add(spadeCard.newCard(AnsiConsol.message("black", "♠")));
		
	}
	
	public String drawCard(PlayerDto player) {
		
		while(true) {
			try {
				rndType = (int)(Math.random()*4);
				Thread.sleep(200);
				rndNum = (int)(Math.random() * wholeCard.get(rndType).size());
				selectCard = wholeCard.get(rndType).get(rndNum);
				Thread.sleep(200);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
		wholeCard.get(rndType).remove(rndNum);
		player.addCardList(selectCard);
		
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
