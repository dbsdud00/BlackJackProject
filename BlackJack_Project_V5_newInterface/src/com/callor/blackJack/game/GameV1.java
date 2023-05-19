package com.callor.blackJack.game;

import com.callor.blackJack.service.interfaceService;
import com.callor.blackJack.service.interfaceServiceV1;

public class GameV1 {
	public static void main(String[] args) {


		interfaceService test = new interfaceServiceV1();
		test.gameStart();
		test.gameEnd();

	}
}
