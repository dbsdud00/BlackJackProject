package com.callor.blackJack.service;

import java.util.Scanner;

import com.callor.blackJack.model.PlayerDto;
import com.callor.blackJack.set.GameSetV1;

public class InGameV2 implements InGame{
	
	protected PlayerDto dealer;
	protected PlayerDto gamer;
	
	protected GameSetV1 gameSet;
	
	public InGameV2() {
		dealer = new PlayerDto();
		gamer = new PlayerDto();
		gameSet = new GameSetV1();
		gameSet.gameSet();
	}
	
	
	public void gameStart() {
		
		Scanner scan = new Scanner(System.in);


		
		boolean gamerStop = true;
		boolean dealerStop = true;
		boolean stop = true;
		
		String winner = "";
		
		while (stop) {
			while(dealerStop) {
				dealerTurn();
				break;
			}
			
			
			if (dealer.getScore() > 21 ) {
				winner = "게이머";
				break;
			} else if (dealer.getScore() > 17) {
				dealerStop = false;
			} 
			
			
			while(gamerStop) {
				
				String yesNo = "";

				while (true) {
					System.out.println("카드를 뽑으시겠습니까?(Y/N)");
					yesNo = scan.nextLine();

					if (yesNo.equals("Y")) {
						break;
					} else if (yesNo.equals("N")) {
						gamerStop = false;
						break;
					} else {
						System.out.println("\"Y\"나 \"N\"을 눌러주세요");
						continue;
					}
					
				}
				if (yesNo.equals("N")) {
					break;
				}

				System.out.println(gameSet.drawCard(gamer));
				gamer.setScore(gamer.getScore() + gameSet.scoreCheck());
				System.out.printf("게이머의 점수는 %d 점", gamer.getScore());
				System.out.println();
				System.out.println();
				if (gamer.getScore() > 21) {
					winner = "딜러";
					stop = false;
				}
				
				break;
			}

			if (!(dealerStop || gamerStop)) {
				
				if (dealer.getScore() < gamer.getScore()) {
					stop = false;
					winner = "게이머";
				}else if (dealer.getScore() > gamer.getScore()) {
					stop = false;
					winner = "딜러";
				} else if (dealer.getScore() == gamer.getScore()) {
					stop = false;
					winner = "없습니다";
				}
				
			}
		}
		System.out.println("게임이 종료되었습니다");
		System.out.printf("승자는 %s!",winner);

	}
	
	private void dealerTurn() {
		
		System.out.println(gameSet.drawCard(dealer));
		dealer.setScore(dealer.getScore() + gameSet.scoreCheck());
		System.out.printf("딜러의 점수는 %d 점", dealer.getScore());
		System.out.println();
		System.out.println("=".repeat(50));
	}
	
	

	
	
}
