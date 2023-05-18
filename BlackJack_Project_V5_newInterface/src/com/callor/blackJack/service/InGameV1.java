package com.callor.blackJack.service;

import java.util.Scanner;

import com.callor.blackJack.model.PlayerDto;
import com.callor.blackJack.set.GameSetV1;
import com.callor.blackJack.utils.AnsiConsol;
import com.callor.blackJack.utils.Line;

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
			
			System.out.println(Line.line("*", 50));
			System.out.println(AnsiConsol.message("yellow","먼저 딜러와 게이머는 카드를 두장 씩 뽑습니다."));
			System.out.println(Line.bLine(3));

//			System.out.println(Line.sLine(50));
			firstSet(dealer, "딜러");
			System.out.println(Line.sLine(50));
			firstSet(gamer, "게이머");
			System.out.println(Line.sLine(50));
			

			System.out.println();
			System.out.println(AnsiConsol.message("yellow", "게이머 turn"));

			while (winner.isEmpty()) {

				if (!choice()) {
					break;
				}
				
				System.out.println(Line.bLine(5));
				System.out.println(Line.sLine(50) + "\n");
				showDeck(dealer);
				System.out.println(Line.sLine(50)+"\n");
				playerTurn(gamer);
				System.out.println("\n" + Line.sLine(50));
				if (isGamerBust())
					break;
			}
			if (isGamerBust()) {
				System.out.println(Line.bLine(5));
				System.out.printf("\n%s Busted!!\n\n", gamer.getPlayerName());
				break;
			}
			
			
			if (winner.isEmpty() && dealer.getScore() < 17) {
				System.out.println(Line.bLine(5));
				System.out.println(Line.sLine(50)+"\n");
				System.out.println(AnsiConsol.message("yellow", "딜러 turn\n"));

				while (dealer.getScore() < 17) {
					
					System.out.println(Line.sLine(50) + "\n");
					playerTurn(dealer);
					
					if (isDealerBust()) break;
				}
				System.out.println("\n" + Line.sLine(50));
				if (isDealerBust()) {
					System.out.println(Line.bLine(5));
					System.out.printf("\n\n%s Busted!!\n\n",dealer.getPlayerName());
					break;
				}
				
			}
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			break;
		}
		
		System.out.println(Line.sLine(50) + "\n");
		showDeck(dealer);
		System.out.println(Line.sLine(50) + "\n");
		showDeck(gamer);
		System.out.println(Line.sLine(50) + "\n");

		if (winner.isEmpty()) {

			if (dealer.getScore() < gamer.getScore()) {
				winner = "게이머";
			} else if (dealer.getScore() > gamer.getScore()) {
				winner = "딜러";
			} else if (dealer.getScore() == gamer.getScore()) {
				winner = "없습니다. 무승부";
			}

		}
		
		System.out.println();
		System.out.println("=".repeat(80));
		System.out.println("게임이 종료되었습니다");
		System.out.printf("**승자는 %s!**\n", winner);
		System.out.println("=".repeat(80));

	}

	
	
	
	
	
	protected boolean isGamerBust() {
		if (gamer.getScore() > 21) {
			winner = dealer.getPlayerName();
			return true;
		}
		return false;
	}
	protected boolean isDealerBust() {
		if (dealer.getScore() > 21) {
			winner = gamer.getPlayerName();
			return true;
		}
		return false;
	}

	protected void firstSet(PlayerDto player, String name) {
		System.out.println();
		System.out.printf(" %s (%d점)\n", gameSet.drawCard(player), gameSet.scoreCheck());
		player.setScore(player.getScore() + gameSet.scoreCheck());
		System.out.printf(" %s (%d점)\n", gameSet.drawCard(player), gameSet.scoreCheck());
		player.setScore(player.getScore() + gameSet.scoreCheck());
		player.showList();
		System.out.println();
		System.out.printf("\n ** %s의 점수는 %d 점 **\n\n", name, player.getScore());
	}

	protected boolean choice() {
		String yesNo = "";
		while (true) {
			System.out.print(AnsiConsol.message("yellow", "카드를 뽑으시겠습니까?(Y/N) >> "));
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

		System.out.printf(" %s (%d점)\n", gameSet.drawCard(player), gameSet.scoreCheck());
		player.showList();
		System.out.println();
		player.setScore(player.getScore() + gameSet.scoreCheck());
		System.out.println();
		System.out.printf(" %s %s의 점수는 %d 점 %s\n",AnsiConsol.RED("**"), player.getPlayerName(), player.getScore(),AnsiConsol.RED("**"));

	}
	
	protected void showDeck(PlayerDto player) {
		player.showList();
		System.out.println("\n");
		System.out.printf(" %s %s의 점수는 %d 점 %s\n\n",AnsiConsol.RED("**"), player.getPlayerName(), player.getScore(),AnsiConsol.RED("**"));
	}

	@Override
	public String printWinner() {

		if (winner.equals(gamer.getPlayerName())) return "win";
		else if(winner.equals(dealer.getPlayerName())) return "lose";
		else return "drew";
	}


}


