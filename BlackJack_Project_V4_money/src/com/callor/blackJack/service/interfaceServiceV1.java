package com.callor.blackJack.service;

import java.util.Scanner;

import com.callor.blackJack.set.MoneyV1;

public class interfaceServiceV1 implements interfaceService {
	protected InGame inGame;
	protected Scanner scan;
	protected MoneyV1 money;

	public interfaceServiceV1() {
		scan = new Scanner(System.in);
		money = new MoneyV1();
	}

	@Override
	public void gameStart() {

		System.out.println();
		System.out.println("블랙잭 게임을 시작합니다.");
		System.out.println();

		setTheMoney();

		while (true) {
			inGame = new InGameV1();
			System.out.println("게임을 시작합니다.");

			setTheStake();

			inGame.gameStart();
			isWin();
			if (noMoney()) {
				System.out.println("\n돈이 없으시면 나가주세요.");
				break;
			}
			if (goNogo()) break;
		}
		System.out.println("\n게임을 종료합니다.");
	}
	
	
	
	
	
	

	private void setTheMoney() {
		while (true) {
			System.out.print("소지한 금액을 적어주세요 >> ");
			try {
				money.setMoney(Integer.valueOf(scan.nextLine()));
			} catch (Exception e) {
				System.out.println("돈은 정수형으로 적어주세요.");
				continue;
			}
			break;
		}
	}

	private void setTheStake() {
		while (true) {
			System.out.print("판돈을 설정해 주세요 >> ");
			try {
				money.setStake(Integer.valueOf(scan.nextLine()));
			} catch (Exception e) {
				System.out.println("돈은 정수형으로 적어주세요.");
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
			System.out.println("+" + money.getStake());
			money.winTheGame();
		} else if (result.equals("lose")) {
			System.out.println("-" + money.getStake());
			money.loseTheGame();
		}
		System.out.printf("현재 소지금 : %d\n", money.getMoney());
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
