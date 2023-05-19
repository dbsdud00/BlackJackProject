package com.callor.blackJack.service;

import java.util.Scanner;

import com.callor.blackJack.set.MoneyV1;
import com.callor.blackJack.utils.AnsiConsol;

public class interfaceServiceV1 implements interfaceService {
	protected InGame inGame;
	protected Scanner scan;
	protected MoneyV1 money;
	private int originMoney;

	public interfaceServiceV1() {
		scan = new Scanner(System.in);
		money = new MoneyV1();
	}

	@Override
	public void gameStart() {
		
		System.out.println(AnsiConsol.message("yellow","*".repeat(81)));
		System.out.println(AnsiConsol.message("yellow","*".repeat(81)));
		System.out.println(AnsiConsol.message("yellow","*\t@@@@   @       @@@    @@@@  @   @     @@@@@   @@@    @@@@  @   @\t*"));
		System.out.println(AnsiConsol.message("yellow","*\t@   @  @      @   @  @      @  @        @    @   @  @      @  @ \t*"));
		System.out.println(AnsiConsol.message("yellow","*\t@   @  @      @   @  @      @ @         @    @   @  @      @ @  \t*"));
		System.out.println(AnsiConsol.message("yellow","*\t@@@@   @      @@@@@  @      @@          @    @@@@@  @      @@   \t*"));
		System.out.println(AnsiConsol.message("yellow","*\t@   @  @      @   @  @      @ @         @    @   @  @      @ @  \t*"));
		System.out.println(AnsiConsol.message("yellow","*\t@   @  @      @   @  @      @  @        @    @   @  @      @  @ \t*")); 
		System.out.println(AnsiConsol.message("yellow","*\t@@@@   @@@@@  @   @   @@@@  @   @     @@@    @   @   @@@@  @   @\t*"));
		System.out.println(AnsiConsol.message("yellow","*".repeat(81)));
		System.out.println(AnsiConsol.message("yellow","*".repeat(81)));
		
		System.out.println("\n블랙잭 게임을 시작합니다.\n");

		setTheMoney();
		originMoney = money.getMoney();
		while (true) {
			inGame = new InGameV1();
			System.out.println("\n게임을 시작합니다.\n");

			setTheStake();
			System.out.println("\n".repeat(3));

			inGame.gameStart();
			isWin();
			if (noMoney()) {
				System.out.println("\n돈이 없으시면 나가주세요.");
				break;
			}
			if (goNogo()) break;
		}
		
	}
	
	@Override
	public void gameEnd() {
		if (originMoney>money.getMoney()) {
			System.out.printf(AnsiConsol.YELLOW("%s$를 잃었습니다.\n"),originMoney-money.getMoney());
		} else if (originMoney<money.getMoney()) {
			System.out.printf(AnsiConsol.YELLOW("%s$를 땃습니다.\n"),money.getMoney()-originMoney);
		} else if(originMoney==money.getMoney()) {
			System.out.println(AnsiConsol.YELLOW("돈을 잃지 않았습니다."));
		}
		System.out.printf(AnsiConsol.YELLOW("소지금 : %d$"), money.getMoney());
		System.out.println("\n블랙잭 게임을 종료합니다.");
	}
	
	
	

	private void setTheMoney() {
		while (true) {
			System.out.print(AnsiConsol.message("yellow", "$ 소지한 금액을 적어주세요 >> "));
			try {
				money.setMoney(Integer.valueOf(scan.nextLine()));
			} catch (Exception e) {
				System.out.println(AnsiConsol.message("red", "돈은 정수형으로 적어주세요."));
				continue;
			}
			break;
		}
	}

	private void setTheStake() {
		while (true) {
			System.out.print(AnsiConsol.message("yellow", "$ 판돈을 설정해 주세요 >> "));
			try {
				money.setStake(Integer.valueOf(scan.nextLine()));
			} catch (Exception e) {
				System.out.println(AnsiConsol.message("red", "\n돈은 정수형으로 적어주세요."));
				continue;
			}
			if (money.getStake()>money.getMoney()) {
				System.out.println(AnsiConsol.RED("소지금보다 많이 걸 수는 없습니다. 다시 입력해 주세요."));
				System.out.println("현재 소지금 : " + money.getMoney()+"$");
				continue;
			}
			break;
		}
	}

	private void isWin() {
		// TODO Auto-generated method stub
		String result = inGame.printWinner();
		System.out.println();
		if (result.equals("win")) {
			System.out.println(AnsiConsol.YELLOW("+" + money.getStake()+"$\n"));
			money.winTheGame();
		} else if (result.equals("lose")) {
			System.out.println(AnsiConsol.YELLOW("-" + money.getStake()+"$\n"));
			money.loseTheGame();
		}
		System.out.printf(AnsiConsol.YELLOW("$ 현재 소지금 : %d$\n"), money.getMoney());
	}

	private boolean noMoney() {
		if (money.getMoney() <= 0) {
			return true;
		}
		return false;
	}

	private boolean goNogo() {

		System.out.println("\n\n\n");
		while (true) {

			System.out.print("게임을 계속하시겠습니까? (Y/N) >> ");
			String YN = scan.nextLine();
			if (YN.equals("N")) {
				return true;
			} else if (YN.equals("Y")) {
				System.out.println("\n\n\n");
				return false;
			} else {
				System.out.println("Y/N중 하나를 입력해 주세요");
			}
		}
	}



}
