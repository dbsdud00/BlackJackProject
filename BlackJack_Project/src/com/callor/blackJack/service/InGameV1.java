package com.callor.blackJack.service;

import java.util.Scanner;

import com.callor.blackJack.model.PlayerDto;
import com.callor.blackJack.set.GameSetV1;

public class InGameV1 implements InGame{
	private PlayerDto dealer;
	private PlayerDto gamer;
	public InGameV1() {
		dealer = new PlayerDto();
		gamer = new PlayerDto();
	}
	public void gameStart() {
		
		Scanner scan = new Scanner(System.in);

		GameSetV1 gameSet = new GameSetV1();
		gameSet.gameSet();
		
		
		boolean gamerStop = false;
		boolean stop = false;
		
		String winner = "";
		
		int tmpScore;
		
		dealer.setScore(0);
		gamer.setScore(0);
		while (true) {

			if (dealer.getScore() < 18) {
				System.out.println(gameSet.drawCard(dealer));
				dealer.setScore(dealer.getScore() + gameSet.scoreCheck());
				System.out.printf("딜러의 점수는 %d 점", dealer.getScore());
				System.out.println();
				System.out.println();
			} else if (gamer.getScore() > 21 || dealer.getScore() > gamer.getScore()) {
				winner = "딜러";
				stop = true;
			} else if (dealer.getScore() < gamer.getScore()) {
				winner = "게이머";
				stop = true;
			}

			if (dealer.getScore() > 21) {
				winner = "게이머";
				stop = true;
			}

			if (stop) {
				System.out.println("게임이 종료되었습니다.");
				System.out.printf("승자는 %s!", winner);
				break;
			}

			if (gamerStop) {
				continue;
			}
			System.out.println("카드를 뽑으시겠습니까?(Y/N)");
			String yesNo = "";

			while (true) {
				yesNo = scan.nextLine();

				if (yesNo.equals("Y")) {
					break;
				} else if (yesNo.equals("N")) {
					stop = true;
					break;
				} else {
					System.out.println("\"Y\"나 \"N\"을 눌러주세요");
				}
			}

			if (yesNo.equals("N")) {
				continue;
			}

			System.out.println(gameSet.drawCard(gamer));
			gamer.setScore(gamer.getScore() + gameSet.scoreCheck());
			System.out.printf("게이머의 점수는 %d 점", gamer.getScore());
			System.out.println();
			System.out.println();
		}
		
		
		
		
		
		
	}
	
}
