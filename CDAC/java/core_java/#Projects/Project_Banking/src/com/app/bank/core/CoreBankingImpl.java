package com.app.bank.core;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.app.bank.data.Database;
import com.app.validator.Constants;
import com.app.validator.Validate;
import com.app.validator.exception.AccountDoesNotExistException;
import com.app.validator.exception.AgeException;
import com.app.validator.exception.DuplicateAccountException;
import com.app.validator.exception.InsufficientBalanceException;
import com.app.validator.exception.MinBalanceException;
import com.app.validator.exception.NoTransactionException;
import com.app.validator.exception.UnableToOpenNewAccountException;
import com.app.bank.AccountType;
import com.app.bank.BankAccount;
import com.app.bank.TransactionHistory;
import com.app.bank.TransactionType;

public class CoreBankingImpl implements CoreBanking {

	private static final String LINE_START = "==============================================================";
	private static final String LINE_END = "\n==============================================================";
	
	public void openBankAccount(int accountNo, String firstName, String lastName, LocalDate dob, AccountType accountType) {
		System.out.println(LINE_START);
		try {
			Validate.minAge(dob);
			
			System.out.println(Database.addNewAccount(new BankAccount(accountNo, firstName, lastName, dob, accountType, 0)));
		} catch(AgeException e) {
			System.out.println(e.getMessage());
		} catch(DuplicateAccountException e) {
			System.out.println(e.getMessage());
		} catch (UnableToOpenNewAccountException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(LINE_END);
	}
	
	public void openBankAccount(int accountNo, String firstName, String lastName, LocalDate dob, AccountType accountType, int defaultBalance) {
		System.out.println(LINE_START);
		try {
			Validate.minAge(dob);
//			Validate.minInitialBalance(defaultBalance);
			Validate.minInitialBalance(accountType, defaultBalance);
			
			System.out.println(Database.addNewAccount(new BankAccount(accountNo, firstName, lastName, dob, accountType, defaultBalance)));
		} catch(AgeException e) {
			System.out.println(e.getMessage());
		} catch(DuplicateAccountException e) {
			System.out.println(e.getMessage());
		} catch (MinBalanceException e) {
			System.out.println(e.getMessage());
		} catch (UnableToOpenNewAccountException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(LINE_END);
	}

	public void displayAllAccount(int choice) {
		System.out.println(LINE_START);
		List<BankAccount> accountList = Database.getAllAccounts();
		if (accountList.size() == 0) {
			System.out.println("\n\t\tNo account found !!!");
		} else {
			/*
			 * "Press 1. to display unsorted data"
			 * "Press 2. to display sorted data (according to Account No.)"
			 * "Press 3. to display sorted data (according to Account Type)"
			 * "Press 4. to display sorted data (according to Customer DOB & Balance)"
			 */
			
			switch(choice) {
			case 1:
				// Do nothing
				break;
			case 2:
				Collections.sort(accountList);
				break;
			case 3:
				Collections.sort(accountList, new Comparator<BankAccount> () {
					@Override
					public int compare(BankAccount o1, BankAccount o2) {
						return o1.getAccountType().name().compareTo(o2.getAccountType().name());
					}
				});
				break;
			case 4:
				Collections.sort(accountList, new Comparator<BankAccount> () {
					@Override
					public int compare(BankAccount o1, BankAccount o2) {
						int compareVal = o1.getDob().compareTo(o2.getDob());
						if(compareVal == 0) {
							return Integer.compare(o2.getBalance(), o1.getBalance());
						}
						return compareVal;
					}
				});
				break;
			}
			
			int idx = 1;
			for (BankAccount account : accountList) {
				System.out.println("\n========== [ " + idx++ + " of " + accountList.size() + " ] Details :: ");
				System.out.println("\n\t\t" + account.toString());
			}
		}
		System.out.println(LINE_END);
	}

	public void searchAccount(int accountNo) {
		System.out.println(LINE_START);
		try {
			BankAccount account = Database.getAccountByAcNo(accountNo);
			System.out.println(account.toString());
		} catch (AccountDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(LINE_END);
	}

	public void depositFund(int accountNo, int fundToBeAdded) {
		
		System.out.println(LINE_START);
		try {
			BankAccount account = Database.getAccountByAcNo(accountNo);
			
			TransactionHistory transaction = new TransactionHistory(account.getBalance(), fundToBeAdded, TransactionType.CREDIT, LocalDate.now());

			account.setBalance(account.getBalance() + fundToBeAdded);
			System.out.println(Constants.FUND_ADDED);
			
			account.addTransaction(transaction);
		} catch (AccountDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(LINE_END);
	}

	public int withdrawFund(int accountNo, int fundToBeWithdrawn) {
		System.out.println(LINE_START);
		try {
			BankAccount account = Database.getAccountByAcNo(accountNo);
			
			Validate.balance(account, fundToBeWithdrawn);
			
			TransactionHistory transaction = new TransactionHistory(account.getBalance(), fundToBeWithdrawn, TransactionType.DEBIT, LocalDate.now());
			
			account.setBalance(account.getBalance() - fundToBeWithdrawn);
			System.out.println(Constants.FUND_WITHDRAWN);
			
			account.addTransaction(transaction);
			
			return fundToBeWithdrawn;
		} catch (AccountDoesNotExistException e) {
			System.out.println(e.getMessage());
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println(LINE_END);
		}
		return -1;
	}
	
	public void transferAmount(int fromAccount, int toAccount, int transferAmount) {
		System.out.println(LINE_START);
		
		int amtWithdrawnSuccessfully = withdrawFund(fromAccount, transferAmount);
		if(amtWithdrawnSuccessfully == -1) {
			System.out.println(Constants.TRANSFER_ABORTED);
			System.out.println(LINE_END);
			return;
		}
		depositFund(toAccount, amtWithdrawnSuccessfully);
		
		System.out.println(Constants.FUNDS_TRANSFERRED_SUCCESSFULLY);
		System.out.println(LINE_END);
	}
	
	public void getAccountStatement(int accountNo) {
		System.out.println(LINE_START);
		try {
			BankAccount account = Database.getAccountByAcNo(accountNo);
			System.out.println("Account No. : " + account.getAccountNo());
			
			int idx = 1;
			for(TransactionHistory history : account.getTransactionHistory()) {
				System.out.println("========== Transaction No. :: [ " + idx++ + " ] ==========");
				System.out.println(history.toString());
			}
		} catch (AccountDoesNotExistException e) {
			System.out.println(e.getMessage());
		} catch(NoTransactionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(LINE_END);
	}

	public void closeAccount(int accountNo) {
		System.out.println(LINE_START);
		try {
			System.out.println(Database.closeAcc(accountNo));
		} catch (AccountDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(LINE_END);
	}

}
