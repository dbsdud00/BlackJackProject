package com.callor.blackJack.model;

public class PlayerDto {
	private int score;
	public PlayerDto() {
		setScore(0);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
