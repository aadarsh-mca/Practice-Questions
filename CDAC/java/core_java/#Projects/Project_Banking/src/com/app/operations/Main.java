package com.app.operations;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.app.bank.TransactionHistory;
import com.app.bank.AccountType;
import com.app.bank.core.CoreBankingImpl;
import com.app.bank.data.Database;

public class Main {
	private static CoreBankingImpl coreBanking = new CoreBankingImpl();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Database.addDemoData();
		
		boolean toExit = false;
		
		while(toExit == false) {
			printOption();
			
			switch(scan.nextInt()) {
			case 1: 
				newAccountDetail();
				break;
			case 2:
				displayAllAccounts();
				break;
			case 3:
				searchAccount();
				break;
			case 4:
				depositFunds();
				break;
			case 5:
				withdrawFunds();
				break;
			case 6:
				transferFund();
				break;
			case 7:
				printStatement();
				break;
			case 9:
				closeAccount();
				break;
			case 0:
				toExit = true;
				break;
			default:
				System.out.println("Invalid option selected !!!");
			}
		}
		
		scan.close();
	}
	
	private static void printOption() {
		System.out.println("\t========== [ Bank Portal ] ==========");
		
		System.out.println("\n\tPress '1' to Open New Account.");
		System.out.println("\tPress '2' to Display All Account.");
		System.out.println("\tPress '3' to Search Account Detail.");
		System.out.println("\tPress '4' to Deposit Fund.");
		System.out.println("\tPress '5' to Withdraw Fund.");
		System.out.println("\tPress '6' to Transfer Fund (NEFT/IMPS).");
		System.out.println("\tPress '7' to Print Mini Statement.");
		System.out.println("\tPress '9' to Close Account.");
		System.out.println("\tPress '0' to Exit....");
	}
	
	private static void newAccountDetail() {
		int accountNo;
		String firstName, lastName;
		LocalDate dob = LocalDate.parse("1900-01-01");
		AccountType accountType;
		
		
		System.out.println("\nTo create new account, please enter the following detail : ");
		
		System.out.print("\tEnter Account No. : ");
		accountNo = scan.nextInt();
		System.out.print("\tEnter First Name : ");
		firstName = scan.next();
		System.out.print("\tEnter Last Name : ");
		lastName = scan.next();

		System.out.print("\tEnter your Date of Birth (yyyy-mm-dd) : ");
		try {
			dob = LocalDate.parse(scan.next());
		} catch(DateTimeParseException e) {
			System.out.println(e.getMessage());
			System.out.println("Please enter valid date of birth !!!");
			System.exit(0);
		}
		
		System.out.println("\n\tPlease select account type : ");
		System.out.println("\t\tPress '1' for Saving Account");
		System.out.println("\t\tPress '2' for Current Account");
		if(scan.nextInt() == 1) {
			accountType = AccountType.SAVING;
		} else {
			accountType = AccountType.CURRENT;			
		}
		
		System.out.print("\n\tDo you want to add some initial balance ? (y/n) : ");
		if(scan.next().charAt(0) == 'y') {
			System.out.print("\tEnter the initial balance : ");
			int initialBalance = scan.nextInt();
			coreBanking.openBankAccount(accountNo, firstName, lastName, dob, accountType, initialBalance);
		} else {
			coreBanking.openBankAccount(accountNo, firstName, lastName, dob, accountType);
		}
		
	}
	
	private static void displayAllAccounts() {
		System.out.println("\nChoose the option to sort and display all accounts : ");
		System.out.println("\tPress 1. to display unsorted data");
		System.out.println("\tPress 2. to display sorted data (according to Account No.)");
		System.out.println("\tPress 3. to display sorted data (according to Account Type)");
		System.out.println("\tPress 4. to display sorted data (according to Customer DOB & Balance)");
		
		int choice = scan.nextInt();
		switch(choice) {
		case 1:
			coreBanking.displayAllAccount(choice);
			break;
		case 2:
			coreBanking.displayAllAccount(choice);
			break;
		case 3:
			coreBanking.displayAllAccount(choice);
			break;
		case 4:
			coreBanking.displayAllAccount(choice);
			break;
		default :
			System.out.println("Invalid option selected !!!");	
		}
	}
	
	private static void searchAccount() {
		System.out.print("\n\tEnter the Account No. you want to search : ");
		int accountNo = scan.nextInt();
		
		coreBanking.searchAccount(accountNo);
	}
	
	private static void depositFunds() {
		int accountNo;
		int fundToBeAdded;
		
		System.out.print("\n\tEnter your account No. : ");
		accountNo = scan.nextInt();
		System.out.print("\n\tEnter the amount you want to add : ");
		fundToBeAdded = scan.nextInt();
		
		coreBanking.depositFund(accountNo, fundToBeAdded);
	}
	
	private static void withdrawFunds() {
		int accountNo;
		int fundToBeWithdrawn;
		
		System.out.print("\n\tEnter your account No. : ");
		accountNo = scan.nextInt();
		System.out.print("\n\tEnter the amount you want to withdraw : ");
		fundToBeWithdrawn = scan.nextInt();
		
		coreBanking.withdrawFund(accountNo, fundToBeWithdrawn);
	}
	
	private static void transferFund() {
		int fromAccount;
		int toAccount;
		int transferAmount;
		
		System.out.print("\n\tEnter the debit account No. : ");
		fromAccount = scan.nextInt();
		System.out.print("\n\tEnter the credit account No. : ");
		toAccount = scan.nextInt();
		System.out.print("\n\tEnter the amount you want to transfer : ");
		transferAmount = scan.nextInt();
		
		coreBanking.transferAmount(fromAccount, toAccount, transferAmount);
	}
	
	private static void printStatement() {
		int accountNo;
		
		System.out.print("\n\tEnter your account No. : ");
		accountNo = scan.nextInt();
		
		coreBanking.getAccountStatement(accountNo);
	}
	
	private static void closeAccount() {
		int accountNo;
		
		System.out.print("\n\tEnter Account number you want to delete : ");
		accountNo = scan.nextInt();
		
		coreBanking.closeAccount(accountNo);
	}
	
}
