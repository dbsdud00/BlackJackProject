package com.callor.Rule;

import java.util.Scanner;

public class InGame {
	public void gameStart() {
		Player dealer = new Player();
		Player gamer = new Player();
		GameSet gameSet = new GameSet();
		gameSet.gameSet();
		Scanner scan = new Scanner(System.in);
		boolean stop = false;
		String winner = "";
		int tmpScore;
		dealer.setScore(0);
		gamer.setScore(0);
		while (true) {

			if (dealer.getScore() < 18) {
				System.out.println(gameSet.drawCard());
				dealer.setScore(dealer.getScore() + gameSet.scoreCheck());
				System.out.printf("딜러의 점수는 %d 점", dealer.getScore());
				System.out.println();
				System.out.println();
				if (dealer.getScore()>21) {
					stop = true;
					winner = "게이머";
				}
			} 
			
			
			if (stop) {
				System.out.println("게임이 종료되었습니다.");
				System.out.printf("승자는 %s!",winner);
				break;
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
			
			System.out.println(gameSet.drawCard());
			gamer.setScore(gamer.getScore() + gameSet.scoreCheck());
			System.out.printf("게이머의 점수는 %d 점", gamer.getScore());
			System.out.println();
			System.out.println();
			if (gamer.getScore()>21) {
				stop = true;
				winner = "딜러";
			}
		}

	}
}
