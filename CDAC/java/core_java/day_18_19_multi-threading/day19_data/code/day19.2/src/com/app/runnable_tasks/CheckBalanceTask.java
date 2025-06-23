package com.app.runnable_tasks;

import java.util.Random;

import com.app.core.JointAccount;

public class CheckBalanceTask  implements Runnable {

	private JointAccount jointAccount;
	private Random random;

	public CheckBalanceTask(JointAccount jointAccount) {
		super();
		this.jointAccount = jointAccount;
		random=new Random();
	}


	@Override
	public void run() {
		System.out.println("started "+Thread.currentThread().getName());
		try {
			while(true)
			{
				double balance=jointAccount.checkBalance();
				if(balance != 20000)
				{
					System.out.println("Invalid Balance !!!!!!!!!!! ");
					System.exit(-1);
				}
				Thread.sleep(random.nextInt(100)+1);//1-100
			}
		} catch (Exception e) {
			System.out.println("err in thread "+Thread.currentThread().getName()+" "+e);
		}
		System.out.println("over "+Thread.currentThread().getName());

	}

}
