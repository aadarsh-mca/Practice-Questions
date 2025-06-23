package com.cdac.tester;

import java.util.Scanner;

import com.cdac.dao.BankAccountDao;
import com.cdac.dao.BankAccountDaoImpl;
import com.cdac.pojos.BankAccount;

public class TestStoredProcedure {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// dao instance
			BankAccountDao bankAccountDao = new BankAccountDaoImpl();
			System.out.println("Enter src , dest acct nos n amount");
			System.out.println(bankAccountDao
					.transFundsViaProc(sc.nextInt(), sc.nextInt(),sc.nextDouble()));
			bankAccountDao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
