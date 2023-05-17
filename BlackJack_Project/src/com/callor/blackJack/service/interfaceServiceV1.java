package com.callor.blackJack.service;

import java.util.Scanner;

public class interfaceServiceV1 implements interfaceService {

	@Override
	public void gameStart() {
		// TODO Auto-generated method stub
//		int front = 15;
//		int back = 15;
//		int middle = 31-front-back;
//		System.out.println("*".repeat(31));
//		System.out.println("*".repeat(31));
//		
//		for (int i = 0;i< 8 ; i++) {
//			System.out.print("*".repeat(front));
//			System.out.print(" ".repeat(middle));
//			System.out.print("*".repeat(back));
//			front--;
//			back--;
//			middle = 31-front-back;
//			System.out.println();
//		}
//		for (int i = 0;i< 8 ; i++) {
//			front++;
//			back++;
//			middle = 31-front-back;
//			System.out.print("*".repeat(front));
//			System.out.print(" ".repeat(middle));
//			System.out.print("*".repeat(back));
//			System.out.println();
//		}
//		System.out.println("*".repeat(31));
//		System.out.println("*".repeat(31));
//		System.out.println();
		
		
		System.out.println("*".repeat(81));
		System.out.println("*\t@@@@   @       @@@    @@@@  @   @     @@@@@   @@@    @@@@  @   @\t*");
		System.out.println("*\t@   @  @      @   @  @      @  @        @    @   @  @      @  @ \t*");
		System.out.println("*\t@   @  @      @   @  @      @ @         @    @   @  @      @ @  \t*");
		System.out.println("*\t@@@@   @      @@@@@  @      @@          @    @@@@@  @      @@   \t*");
		System.out.println("*\t@   @  @      @   @  @      @ @         @    @   @  @      @ @  \t*");
		System.out.println("*\t@   @  @      @   @  @      @  @        @    @   @  @      @  @ \t*"); 
		System.out.println("*\t@@@@   @@@@@  @   @   @@@@  @   @     @@@    @   @   @@@@  @   @\t*");
		System.out.println("*".repeat(81));
		
		System.out.println("@".repeat(81));
		System.out.println("@@@@@@@@    @@@ @@@@@@@   @@@@    @@ @@@ @@@@@     @@@   @@@@    @@ @@@@ @@@@@@@@");
		System.out.println("@@@@@@@@ @@@ @@ @@@@@@ @@@ @@ @@@@@@ @@ @@@@@@@@ @@@@ @@@ @@ @@@@@@ @@  @@@@@@@@@");
		System.out.println("@@@@@@@@ @@@ @@ @@@@@@ @@@ @@ @@@@@@ @ @@@@@@@@@ @@@@ @@@ @@ @@@@@@ @ @@@@@@@@@@@");
		System.out.println("@@@@@@@@    @@@ @@@@@@     @@ @@@@@@  @@@@@@@@@@ @@@@     @@ @@@@@@  @@@@@@@@@@@@");
		System.out.println("@@@@@@@@ @@@ @@ @@@@@@ @@@ @@ @@@@@@ @ @@@@@@@@@ @@@@ @@@ @@ @@@@@@ @ @@@@@@@@@@@");
		System.out.println("@@@@@@@@ @@@ @@ @@@@@@ @@@ @@ @@@@@@ @@ @@@@@@@@ @@@@ @@@ @@ @@@@@@ @@ @@@@@@@@@@"); 
		System.out.println("@@@@@@@@    @@@     @@ @@@ @@@    @@ @@@ @@@@@   @@@@ @@@ @@@    @@ @@@ @@@@@@@@@");
		System.out.println("@".repeat(81));
		System.out.println();
		
		
		
		
		
		
		
		
		System.out.println("블랙잭 게임을 시작합니다.");
		
		Scanner scan = new Scanner(System.in);
		InGame inGame ;
		
		while(true) {
			inGame = new InGameV3();
			inGame.gameStart();
			System.out.println("\n\n\n");
			System.out.print("게임을 계속하시겠습니까? (Y/N) >> "); 
			String YN = scan.nextLine();
			if (YN.equals("N")) {
				break;
			}
			else if (YN.equals("Y")) {
				System.out.println("\n\n\n");
			}else {
				System.out.println("Y/N중 하나를 입력해 주세요");
			}
			
			
		}
		System.out.println("\n게임을 종료합니다.");
	}

	@Override
	public void gameEnd() {
		// TODO Auto-generated method stub
		
		
	}

}
