package com.callor.blackJack.service;

import java.util.Scanner;

import com.callor.blackJack.model.PlayerDto;
import com.callor.blackJack.set.GameSetV1;

public class InGameV3 implements InGame {

	private boolean gamerStop = true;
	private boolean dealerStop = true;
	private boolean stop = true;
	private String winner = "";

	private Scanner scan = new Scanner(System.in);

	protected PlayerDto dealer;
	protected PlayerDto gamer;

	protected GameSetV1 gameSet;

	public InGameV3() {
		dealer = new PlayerDto("딜러");
		gamer = new PlayerDto("게이머");
		gameSet = new GameSetV1();
		gameSet.gameSet();
	}

	public void gameStart() {

		System.out.println("=".repeat(80));
		System.out.println("먼저 딜러와 게이머는 카드를 두장 씩 뽑습니다.");
		System.out.println("=".repeat(80));

		firstSet(dealer, "딜러");
		System.out.println("-".repeat(80));
		firstSet(gamer, "게이머");
		System.out.println();
		System.out.println("=".repeat(80));
		System.out.println("게임을 시작합니다.");
		System.out.println("=".repeat(80));
		System.out.println();

		while (stop) {

			if (dealer.getScore() > 17) {
				dealerStop = false;
			}
			while (dealerStop) {
				System.out.println("*".repeat(12));
				System.out.println("딜러 turn");
				System.out.println("*".repeat(12));
				System.out.println();
				playerTurn(dealer);
				break;
			}

			if (winnerCheck()) {
				continue;
			}

			while (gamerStop) {
				
				System.out.println("*".repeat(12));
				System.out.println("게이머 turn");
				System.out.println("*".repeat(12));
				System.out.println();
				
				if (choice()) {
					break;
				}

				playerTurn(gamer);

				if (winnerCheck()) {
					continue;
				}

				break;
			}

			if (!(dealerStop || gamerStop)) {

				if (dealer.getScore() < gamer.getScore()) {
					stop = false;
					winner = "게이머";
				} else if (dealer.getScore() > gamer.getScore()) {
					stop = false;
					winner = "딜러";
				} else if (dealer.getScore() == gamer.getScore()) {
					stop = false;
					winner = "없습니다. 무승부";
				}

			}
		}
		System.out.println();
		System.out.println("=".repeat(80));
		System.out.println("게임이 종료되었습니다");
		System.out.printf("**승자는 %s!**\n", winner);
		System.out.println("=".repeat(80));
	}

	
	
	private void firstSet(PlayerDto player, String name) {
		System.out.printf("%s (%d점)\n", gameSet.drawCard(player), gameSet.scoreCheck());
		player.setScore(player.getScore() + gameSet.scoreCheck());
		System.out.printf("%s (%d점)\n", gameSet.drawCard(player), gameSet.scoreCheck());
		player.setScore(player.getScore() + gameSet.scoreCheck());
		player.showList();
		System.out.printf("\n**%s의 점수는 %d 점\n", name, player.getScore());

	}
	
	private boolean winnerCheck() {
		if (dealer.getScore() > 21) {
			dealerStop = false;
			winner = "게이머";
			stop = false;
			return true;
		} else if (dealer.getScore() > 17) {
			dealerStop = false;
		}
		if (gamer.getScore() > 21) {
			gamerStop = false;
			winner = "딜러";
			stop = false;
			return true;
		} else if (dealerStop == false && dealer.getScore() < gamer.getScore()) {
			gamerStop = false;
			winner = "게이머";
			stop = false;
			return true;
		}
			return false;
	}

	
	
	private boolean choice() {
		String yesNo = "";
		while (true) {
			System.out.print("카드를 뽑으시겠습니까?(Y/N) >> ");
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
			return true;
		}
		return false;
	}

	private void playerTurn(PlayerDto player) {

		String card = gameSet.drawCard(player);
		System.out.printf("%s가 뽑은 카드는 %s입니다.\n",player.getPlayerName(), card);
		player.showList();
		System.out.println();
		player.setScore(player.getScore() + gameSet.scoreCheck());
		System.out.printf("**%s의 점수는 %d 점", player.getPlayerName(), player.getScore());
		System.out.println("\n");
		System.out.println("-".repeat(80));


	}
}

//private void dealerTurn() {
//
//	String card = gameSet.drawCard(dealer);
//	System.out.printf("딜러가 뽑은 카드는 %s입니다.\n",card);
//	dealer.showList("딜러");
//	System.out.println();
//	dealer.setScore(dealer.getScore() + gameSet.scoreCheck());
//	System.out.printf("**딜러의 점수는 %d 점", dealer.getScore());
//	System.out.println("\n");
//	System.out.println("-".repeat(50));
//	
//}
//
//private void gamerTurn() {
//	System.out.println(gameSet.drawCard(gamer));
//	gamer.setScore(gamer.getScore() + gameSet.scoreCheck());
//	System.out.printf("게이머의 점수는 %d 점", gamer.getScore());
//	System.out.println();
//	System.out.println("=".repeat(50));
//}