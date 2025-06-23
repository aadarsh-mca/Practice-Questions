package com.cdac.dao;

import java.sql.SQLException;

public interface BankAccountDao {
//add a method to transfer funds
	String transFundsViaProc(int srcAcctNo, int destAcctNo, double amount) throws SQLException;

	// clean up
	void cleanUp() throws SQLException;
}
