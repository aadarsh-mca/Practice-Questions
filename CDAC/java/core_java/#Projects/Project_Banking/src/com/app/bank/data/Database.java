package com.app.bank.data;

import com.app.bank.AccountType;
import com.app.bank.BankAccount;
import com.app.validator.Constants;
import com.app.validator.Validate;
import com.app.validator.exception.*;
import java.util.List;
import java.util.function.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Database {
	private static List<BankAccount> accounts = new ArrayList<>();
	
	private Database() {
	}
	
	public static void addDemoData() {
		accounts.add(new BankAccount(102, "p2", "z2", LocalDate.parse("1999-09-01"), AccountType.CURRENT, 5000));
		accounts.add(new BankAccount(104, "p4", "z4", LocalDate.parse("1993-09-01"), AccountType.CURRENT, 20000));
		accounts.add(new BankAccount(101, "p1", "z1", LocalDate.parse("1999-09-01"), AccountType.SAVING, 0));
		accounts.add(new BankAccount(103, "p3", "z3", LocalDate.parse("1963-09-01"), AccountType.SAVING, 10000));
	}
	
	public static List<BankAccount> getAllAccounts() {
		return Database.accounts;
	}
	
	public static BankAccount getAccountByAcNo(int accountNo) throws AccountDoesNotExistException {
		for(BankAccount bankAc : Database.accounts) {
			if(bankAc.getAccountNo() == accountNo) {
				return bankAc;
			}
		}
		throw new AccountDoesNotExistException(Constants.ACCOUNT_NOT_EXIST);
	}
	
	public static String addNewAccount(BankAccount newAccount) throws DuplicateAccountException, UnableToOpenNewAccountException {
		for(BankAccount account : Database.accounts) {
			if(account.getAccountNo() == newAccount.getAccountNo()) {
				throw new DuplicateAccountException(Constants.ACCOUNT_ALREADY_EXIST);
			}
		}
		
		if(Database.accounts.add(newAccount)) {
			return Constants.ACCOUNT_OPENED;
		} else {
			throw new UnableToOpenNewAccountException(Constants.UNABLE_TO_OPEN_ACCOUNT);
		}
	}
	
	public static String closeAcc(int accountNo) throws AccountDoesNotExistException {
		/**
		 * 
		 * Will not give account does not exist exception
		 * 
		 */
//		Database.accounts.remove(Database.accounts.indexOf(new BankAccount(accountNo))); 
		
		/**
		 * 
		 * Below will require to run loop twice -> TC : O(2n)
		 * 
		 */
//		BankAccount account = getAccountByAcNo(accountNo);
//		Database.accounts.remove(account);
//		return Constants.ACCOUNT_DELETED;
		
		/**
		 * 
		 * with iterator
		 * 
		 */
//		Iterator<BankAccount> itr = Database.accounts.iterator();
//		while(itr.hasNext()) {
//			if(itr.next().getAccountNo() == accountNo) {
//				itr.remove();
//			}
//		}
		
		int index = Database.accounts.indexOf(new BankAccount(accountNo));
		if(index == -1) {
			throw new AccountDoesNotExistException(Constants.ACCOUNT_NOT_EXIST);
		}
		
		Database.accounts.remove(index);
		return Constants.ACCOUNT_DELETED;
	}
	
	
	
}
