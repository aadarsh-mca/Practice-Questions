package com.app.core;

import static java.lang.Thread.*;

public class JointAccount {
	private double balance;

	public JointAccount(double balance) {
		super();
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "JointAccount [balance=" + balance + "]";
	}

	// update balance
	public   void updateBalance(double amt) throws Exception {
		System.out.println("Updating bal : " + currentThread().getName());
		balance = balance + amt;
		System.out.println("Cancelling updates, after a dly");
		Thread.sleep(17);
		balance = balance - amt;
		System.out.println("Updations over by " + currentThread().getName());
	}

	// chk balance
	public  double checkBalance() throws Exception {
		System.out.println("Checking balance : by "+ currentThread().getName());
		Thread.sleep(37);
		return balance;

	}

}
