package com.app.bank;

import java.time.LocalDate;

public class TransactionHistory {
	private int beforeAmount;
	private int tAmount;
	private TransactionType tType;
	private LocalDate tDate;
	
	public TransactionHistory(int beforeAmount, int tAmount, TransactionType tType, LocalDate tDate) {
		super();
		this.beforeAmount = beforeAmount;
		this.tAmount = tAmount;
		this.tType = tType;
		this.tDate = tDate;
	}

	@Override
	public String toString() {
		return "\nOpening Balance : " + beforeAmount + 
				"\n\tTransaction Amount :: " + tAmount + 
				"\n\tTransaction Type :: " + tType + 
				"\n\tTransaction Date :: " + tDate + 
				"\nClosing Balance : " + getAfterBalance() + "\n\n";
	}
	
	private int getAfterBalance() {
		if(tType == TransactionType.CREDIT) {
			return (beforeAmount + tAmount);
		} else {
			return (beforeAmount - tAmount);
		}
	}
}
