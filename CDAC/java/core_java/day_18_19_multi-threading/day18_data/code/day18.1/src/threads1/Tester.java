package threads1;

public class Tester {

	public static void main(String[] args) throws InterruptedException{
		System.out.println(Thread.currentThread());//Thread [main,5,main]
		//create multiple thrds n confirm async behavior
		NewThread t1=new NewThread("one");
		NewThread t2=new NewThread("two");
		NewThread t3=new NewThread("three");
		//how many runnable thrds - 1
		t1.start();
		t2.start();
		t3.start();
		System.out.println(t1.isAlive()+" "+t2.isAlive()+" "+t3.isAlive());//t
		//how many runnable thrds - 4
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " exec counter " + i);
			Thread.sleep(1000);
		}		
		System.out.println(t1.isAlive()+" "+t2.isAlive()+" "+t3.isAlive());//f f f 
		System.out.println("main over....");
		

	}

}
