package com.cdac.dao;

import java.sql.*;
import static com.cdac.utils.DBUtils.*;

public class BankAccountDaoImpl implements BankAccountDao {
	private  Connection connection;
	private CallableStatement cst1;
	
	public BankAccountDaoImpl()throws SQLException{
		// open cn
		connection=openConnection();
		//create cst
		String invokeProc="{call transfer_funds_proc(?,?,?,?,?)}";
		cst1=connection.prepareCall(invokeProc);
		// reg OUT param 
		cst1.registerOutParameter(4,Types.DOUBLE);//updated src balance
		cst1.registerOutParameter(5,Types.DOUBLE);
		System.out.println("bank acct dao created!");
		
	}

	@Override
	public String transFundsViaProc(int srcAcctNo, int destAcctNo, double amount) throws SQLException {
		// set IN params
		cst1.setInt(1, srcAcctNo);
		cst1.setInt(2, destAcctNo);
		cst1.setDouble(3, amount);
		//execute stored proc
		cst1.execute();
		return "Upadated src bal "+cst1.getDouble(4)+" dest bal "+cst1.getDouble(5);
	}

	@Override
	public void cleanUp() throws SQLException {
		if (cst1 != null)
			cst1.close();
		closeConnection();
		System.out.println("bank acct dao cleaned up....");


	}

}
