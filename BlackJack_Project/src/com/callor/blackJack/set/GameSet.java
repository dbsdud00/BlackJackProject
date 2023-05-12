package com.callor.blackJack.set;

import com.callor.blackJack.model.PlayerDto;

public interface GameSet {
	
	public void gameSet();
	public String drawCard(PlayerDto player);
	public int scoreCheck();
	
}
