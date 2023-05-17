package com.callor.blackJack.game;

import com.callor.blackJack.service.interfaceService;
import com.callor.blackJack.service.interfaceServiceV1;

public class GameV1 {
	public static void main(String[] args) {
//		GameSet test = new GameSet();
//		test.gameSet();
//		
//		for (int i = 0 ; i< 53; i++) {
//			System.out.print(i+1+". "+test.drawCard()+" : ");
//			System.out.println(test.scoreCheck());
//		}
//		InGame game = new InGameV2();
//		game.gameStart();

		interfaceService test = new interfaceServiceV1();
		test.gameStart();
		

	}
}
