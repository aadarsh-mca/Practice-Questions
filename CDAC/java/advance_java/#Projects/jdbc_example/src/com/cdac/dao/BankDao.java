package com.cdac.dao;

import java.sql.SQLException;
import java.util.List;

import com.cdac.pojos.Bank;

public interface BankDao {

	// TCL -> 
	void toggleAutoCommit() throws SQLException;
	void commit() throws SQLException;
	void callRollback() throws SQLException;
	
	// calling procedure
	List<Bank> getAllAccount() throws SQLException;
	void callTransferFund_procedure(int srcAcc, int destAcc, int amt) throws SQLException;
	double callTransferFund_function(int srcAcc, int destAcc, int amt) throws SQLException;
	
	// cleanup
	void cleanUp() throws SQLException;
}
