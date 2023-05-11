package com.callor.Game;

import com.callor.Rule.InGame;

public class GameV1 {
	public static void main(String[] args) {
//		GameSet test = new GameSet();
//		test.gameSet();
//		
//		for (int i = 0 ; i< 53; i++) {
//			System.out.print(i+1+". "+test.drawCard()+" : ");
//			System.out.println(test.scoreCheck());
//		}
		InGame game = new InGame();
		game.gameStart();
		
		
		

	}
}
