package com.app.tester;

import com.app.core.JointAccount;
import com.app.runnable_tasks.CheckBalanceTask;
import com.app.runnable_tasks.UpdateBalanceTask;

public class TestJointAccount {

	public static void main(String[] args) throws InterruptedException{
		//create singleton instance of joint account
		JointAccount a1=new JointAccount(20000);
		//create tasks , attach threads n start
		Thread t1=new Thread(new UpdateBalanceTask(a1), "customer1");
		Thread t2=new Thread(new CheckBalanceTask(a1), "customer2");
		t1.start();
		t2.start();
		System.out.println("waiting.....");
		t1.join();
		t2.join();
		System.out.println("main over....");


	}

}
