package com.cdac.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.cdac.pojos.Bank;
import com.cdac.utils.DBUtils;

public class BankDaoImpl implements BankDao {
	
	private Connection connection;
	
	private PreparedStatement allAccountStatement;
	
	/**
	 * 
	 * transfer_funds_proc
	 * 
	 * in sid int ,
	   in did int,
	   in amt double ,
	   out sbal double,
	   out dbal double 
	 */
	private CallableStatement callProcedureStatement;
	
	/**
	 * transfer_funds_func
	 * 
	 * sid int, 
	 * did int, 
	 * amt double
	 */
	private CallableStatement callFunctionStatement;
	
	public BankDaoImpl() throws SQLException {
		// open cn
		connection = DBUtils.openConnection();
		
		allAccountStatement = connection.prepareStatement("Select * From accounts");
		
		//                                                                      // 1  2  3  4  5
		callProcedureStatement = connection.prepareCall("{call transfer_funds_proc(?, ?, ?, ?, ?)}");
		callProcedureStatement.registerOutParameter(4, Types.DOUBLE);
		callProcedureStatement.registerOutParameter(5, Types.DOUBLE);
		
		callFunctionStatement = connection.prepareCall("{? = call transfer_funds_func(?, ?, ?)}");
		callFunctionStatement.registerOutParameter(1, Types.DOUBLE);
		
		System.out.println("bank dao created !");
	}
	
	public void toggleAutoCommit() throws SQLException {
		connection.setAutoCommit(!connection.getAutoCommit());
		System.out.println("\n\t====== [ AutoCommit = " + connection.getAutoCommit() + " ] ======");
	}
	
	public void commit() throws SQLException {
		connection.commit();
		System.out.println("\n\t====== [ Commit SuccessFul ] ======");
	}
	
	public void callRollback() throws SQLException {
		connection.rollback();
		System.out.println("\n\t====== [ Rollback SuccessFul ] ======");
	}

	//
	public List<Bank> getAllAccount() throws SQLException {
		List<Bank> bankAccounts = new ArrayList<>();
		
		try(ResultSet result = allAccountStatement.executeQuery()) {
			while(result.next()) {
				Bank bank = new Bank(result.getInt(1), result.getString(2), result.getString(3), result.getDouble(4));
				
				bankAccounts.add(bank);
			}
		}
		return bankAccounts;
	}
	
	
	//
	public void callTransferFund_procedure(int srcAcc, int destAcc, int amt) throws SQLException {
		callProcedureStatement.setInt(1, srcAcc);
		callProcedureStatement.setInt(2, destAcc);
		callProcedureStatement.setInt(3, amt);
		
		boolean status = callProcedureStatement.execute();
		
		double srcBal = callProcedureStatement.getDouble(4);
		double destBal = callProcedureStatement.getDouble(5);
		
		System.out.println("====== [ Src : " + srcBal + " :: Dest : " + destBal + " ] ======");
		System.out.println("Status : " + status + "\n");
	};
	
	public double callTransferFund_function(int srcAcc, int destAcc, int amt) throws SQLException {
		callFunctionStatement.setInt(2, srcAcc);
		callFunctionStatement.setInt(3, destAcc);
		callFunctionStatement.setInt(4, amt);
		
		boolean status = callFunctionStatement.execute();
		
		double destBal = callFunctionStatement.getDouble(1);
		
		System.out.println("\n\t====== [ Dest Acc : " + destBal + " ] ======");
		return destBal;
	};
	
	
	
	@Override
	public void cleanUp() throws SQLException {
		if(callProcedureStatement != null) callProcedureStatement.close();
		if(callFunctionStatement != null) callFunctionStatement.close();
			
		DBUtils.closeConnection();
		System.out.println("user dao cleaned up !");
	}

}
