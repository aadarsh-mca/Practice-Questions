package com.app.bank.core;

import java.util.List;
import com.app.bank.data.Database;
import com.app.validator.Validator;
import com.app.validator.exception.AccountDoesNotExistException;
import com.app.validator.exception.InsufficientBalanceException;
import com.app.validator.exception.MinBalanceException;
import com.app.validator.exception.UnableToOpenNewAccountException;
import com.app.bank.BankAccount;

public class CoreBankingImpl extends Database implements CoreBanking {

	private static final String LINE_START = "==============================================================";
	private static final String LINE_END = "\n==============================================================";

	public void openBankAccount(String firstName, String lastName, AccountType accountType, int defaultBalance) {
		System.out.println(LINE_START);
		try {
			Validator.minBalanceValidator(defaultBalance);
			
			System.out.println(super.addNewAccount(new BankAccount(firstName, lastName, accountType, defaultBalance)));
		} catch (MinBalanceException e) {
			System.out.println(e.getMessage());
		} catch (UnableToOpenNewAccountException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(LINE_END);
	}

	public void displayAllAccount() {
		System.out.println(LINE_START);
		List<BankAccount> accountList = super.getAllAccounts();
		if (accountList.size() == 0) {
			System.out.println("\n\t\tNo account found !!!");
		} else {
			for (BankAccount account : accountList) {
				System.out.println("\n\t\t" + account.toString());
			}
		}
		System.out.println(LINE_END);
	}

	public void searchAccount(int accountNo) {
		System.out.println(LINE_START);
		try {
			System.out.println(super.getAccountByAcNo(accountNo));
		} catch (AccountDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(LINE_END);
	}

	public void depositFund(int accountNo, int fundToBeAdded) {
		System.out.println(LINE_START);
		try {
			System.out.println(super.depositFunds(accountNo, fundToBeAdded));
		} catch (AccountDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(LINE_END);
	}

	public void withdrawFund(int accountNo, int fundToBeWithdrawn) {
		System.out.println(LINE_START);
		try {
			System.out.println(super.withdrawFunds(accountNo, fundToBeWithdrawn));
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		} catch (AccountDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(LINE_END);
	}

	public void deleteAccount(int accountNo) {
		System.out.println(LINE_START);
		try {
			System.out.println(super.deleteAcc(accountNo));
		} catch (AccountDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(LINE_END);
	}

}
