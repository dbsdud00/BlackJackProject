package com.callor.blackJack.set;

public class MoneyV1 implements Money {
	
	private int money;
	private int stake;


	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getStake() {
		return stake;
	}

	public void setStake(int stake) {
		this.stake = stake;
	}



	@Override
	public int winTheGame() {
		// TODO Auto-generated method stub
		return money += this.stake;
	}

	@Override
	public int loseTheGame() {
		// TODO Auto-generated method stub
		return money -= this.stake;
	}




}
