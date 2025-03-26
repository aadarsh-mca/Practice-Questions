package com.app.operations;

import java.util.Scanner;
import com.app.bank.core.AccountType;
import com.app.bank.core.CoreBankingImpl;

public class Main {
	private static CoreBankingImpl coreBanking = new CoreBankingImpl();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
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
			case 9:
				deleteAccount();
				break;
			case 0:
				toExit = true;
				break;
			default:
				System.out.println("Invalid option selected !!!");
			}
		}
	}
	
	private static void printOption() {
		System.out.println("\nPress '1' to Open New Account.");
		System.out.println("Press '2' to Display All Account.");
		System.out.println("Press '3' to Search Account Detail.");
		System.out.println("Press '4' to Deposit Fund.");
		System.out.println("Press '5' to Withdraw Fund.");
		System.out.println("Press '9' to Delete Account.");
		System.out.println("Press '0' to Exit....");
	}
	
	private static void newAccountDetail() {
		String firstName, lastName;
		AccountType accountType;
		int initialBalance = 0;
		
		
		System.out.println("\nTo create new account, please enter the following detail : ");
		
		System.out.print("\tEnter First Name : ");
		firstName = scan.next();
		System.out.print("\tEnter Last Name : ");
		lastName = scan.next();
		
		System.out.println("\n\tPlease select account type : ");
		System.out.println("\t\tPress '1' for Saving Account");
		System.out.println("\t\tPress '2' for Current Account");
		if(scan.nextInt() == 1) {
			accountType = AccountType.Saving;
		} else {
			accountType = AccountType.Current;			
		}
		
		System.out.print("\n\tDo you want to add some initial balance ? (y/n) : ");
		if(scan.next().charAt(0) == 'y') {
			System.out.print("\tEnter the initial balance : ");
			initialBalance = scan.nextInt();
		}
		
		coreBanking.openBankAccount(firstName, lastName, accountType, initialBalance);
	}
	
	private static void displayAllAccounts() {
		coreBanking.displayAllAccount();
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
	
	private static void deleteAccount() {
		int accountNo;
		
		System.out.print("\n\tEnter Account number you want to delete : ");
		accountNo = scan.nextInt();
		
		coreBanking.deleteAccount(accountNo);
	}
}
