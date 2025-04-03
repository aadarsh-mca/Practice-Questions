package com.app.bank;

public enum AccountType {
//	SAVING,
//	CURRENT
	
	SAVING(5000),
	CURRENT(10000);
	
	private int minBalance;
	
	private AccountType(int minBalance) {
		this.minBalance = minBalance;
	}

	public int getMinBalance() {
		return minBalance;
	}
}
