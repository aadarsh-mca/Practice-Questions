package com.app.bank.data;

import com.app.bank.BankAccount;
import com.app.validator.exception.*;
import java.util.List;
import java.util.ArrayList;

public class Database {
	private static List<BankAccount> accounts = new ArrayList<>();
	
	protected static List<BankAccount> getAllAccounts() {
		return Database.accounts;
	}
	
	protected static String getAccountByAcNo(int accountNo) throws AccountDoesNotExistException {
		for(BankAccount bankAc : Database.accounts) {
			if(bankAc.getAccountNo() == accountNo) {
				return bankAc.toString();
			}
		}
//		return "\n\t\tAccount does not exist !!!";
		throw new AccountDoesNotExistException("\n\t\tAccount does not exist !!!");
	}
	
	protected static String addNewAccount(BankAccount newAccount) throws UnableToOpenNewAccountException {
		if(Database.accounts.add(newAccount)) {
			return "\n\t\tAccount opened successfully...";
		} else {
//			return "\n\t\tUnable to open new account !!!";
			throw new UnableToOpenNewAccountException("\n\t\tUnable to open new account !!!");
		}
	}
	
	protected static String depositFunds(int accountNo, int fundToBeAdded) throws AccountDoesNotExistException {
		for(BankAccount account : Database.accounts) {
			if(account.getAccountNo() == accountNo) {
				account.setBalance(account.getBalance() + fundToBeAdded);
				return "\n\t\tFund added successfully...";
			}
		}
//		return "\n\t\tAccount does not exist !!!";
		throw new AccountDoesNotExistException("\n\t\tAccount does not exist !!!");
	}

	protected static String withdrawFunds(int accountNo, int fundToBeWithdrawn) throws InsufficientBalanceException, AccountDoesNotExistException {
		for(BankAccount account : Database.accounts) {
			if(account.getAccountNo() == accountNo) {
				if(account.getBalance() >= fundToBeWithdrawn) {
					account.setBalance(account.getBalance() - fundToBeWithdrawn);					
					return "\n\t\tFund withdrawn successfully...";
				} else {
//					return "\n\t\tInsufficient Balance !!!";
					throw new InsufficientBalanceException("\n\t\tInsufficient Balance !!!");
				}
			}
		}
//		return "\n\t\tAccount does not exist !!!";
		throw new AccountDoesNotExistException("\n\t\tAccount does not exist !!!");
	}
	
	protected static String deleteAcc(int accountNo) throws AccountDoesNotExistException {
		int idx = 0;
		for(BankAccount account : Database.accounts) {
			if(account.getAccountNo() == accountNo) {
				Database.accounts.remove(idx);
				return "\n\t\tAccount deleted successfully...";
			}
			idx++;
		}
//		return "\n\t\tAccount does not exist !!!";
		throw new AccountDoesNotExistException("\n\t\tAccount does not exist !!!");
	}
	
	
	
}
