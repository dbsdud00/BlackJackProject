package com.callor.blackJack.service;

import java.util.Scanner;

import com.callor.blackJack.model.PlayerDto;
import com.callor.blackJack.set.GameSetV1;

public class InGameV1 implements InGame {

	private String winner = "";

	private Scanner scan = new Scanner(System.in);

	protected PlayerDto dealer;
	protected PlayerDto gamer;

	protected GameSetV1 gameSet;

	public InGameV1() {
		dealer = new PlayerDto("딜러");
		gamer = new PlayerDto("게이머");
		gameSet = new GameSetV1();
		gameSet.cardSet();
	}

	public void gameStart() {
		while (true) {

			System.out.println("=".repeat(80) + "\n");
			System.out.println("먼저 딜러와 게이머는 카드를 두장 씩 뽑습니다.");
			System.out.println("\n" + "-".repeat(50));

			firstSet(dealer, "딜러");
			System.out.println("\n" + "-".repeat(50));
			firstSet(gamer, "게이머");
			System.out.println("\n" + "=".repeat(50));
			System.out.println("게임을 시작합니다.");
			System.out.println("=".repeat(50) + "\n");

			System.out.println();
			System.out.println("*".repeat(12));
			System.out.println("게이머 turn");
			System.out.println("*".repeat(12));
			System.out.println();

			while (winner.isEmpty()) {

				if (!choice()) {
					break;
				}

				playerTurn(gamer);
				if (isGamerBurst())
					break;
			}

			if (isGamerBurst())
				break;

			if (winner.isEmpty() && dealer.getScore() < 17) {
				System.out.println("*".repeat(12));
				System.out.println("딜러 turn");
				System.out.println("*".repeat(12));

				System.out.println();
				
				while (dealer.getScore() < 17) {
					playerTurn(dealer);
					if (isDealerBurst()) break;
				}
				if (isDealerBurst()) break;
			}

			if (winner.isEmpty()) {

				if (dealer.getScore() < gamer.getScore()) {
					winner = "게이머";
				} else if (dealer.getScore() > gamer.getScore()) {
					winner = "딜러";
				} else if (dealer.getScore() == gamer.getScore()) {
					winner = "없습니다. 무승부";
				}

			}
			break;
		}
		System.out.println();
		System.out.println("=".repeat(80));
		System.out.println("게임이 종료되었습니다");
		System.out.printf("**승자는 %s!**\n", winner);
		System.out.println("=".repeat(80));
	}

	protected boolean isGamerBurst() {
		if (gamer.getScore() > 21) {
			winner = dealer.getPlayerName();
			return true;
		}
		return false;
	}
	protected boolean isDealerBurst() {
		if (dealer.getScore() > 21) {
			winner = gamer.getPlayerName();
			return true;
		}
		return false;
	}

	protected void firstSet(PlayerDto player, String name) {
		System.out.println();
		System.out.printf("%s (%d점)\n", gameSet.drawCard(player), gameSet.scoreCheck());
		player.setScore(player.getScore() + gameSet.scoreCheck());
		System.out.printf("%s (%d점)\n", gameSet.drawCard(player), gameSet.scoreCheck());
		player.setScore(player.getScore() + gameSet.scoreCheck());
		player.showList();
		System.out.println();
		System.out.printf("\n** %s의 점수는 %d 점 **\n", name, player.getScore());

	}

	protected boolean choice() {
		String yesNo = "";
		while (true) {
			System.out.print("카드를 뽑으시겠습니까?(Y/N) >> ");
			yesNo = scan.nextLine();
			System.out.println();

			if (yesNo.equals("Y")) {
				return true;
			} else if (yesNo.equals("N")) {
				return false;
			} else {
				System.out.println("\"Y\"나 \"N\"을 눌러주세요");
				continue;
			}
		}
	}

	protected void playerTurn(PlayerDto player) {

		String card = gameSet.drawCard(player);
		System.out.printf("%s가 뽑은 카드는 %s입니다.\n", player.getPlayerName(), card);
		player.showList();
		System.out.println();
		player.setScore(player.getScore() + gameSet.scoreCheck());
		System.out.println();
		System.out.printf("** %s의 점수는 %d 점 **\n\n", player.getPlayerName(), player.getScore());
		System.out.println("-".repeat(80));

	}
}


