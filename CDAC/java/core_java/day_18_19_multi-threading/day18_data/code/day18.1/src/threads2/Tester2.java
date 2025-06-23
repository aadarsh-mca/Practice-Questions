package threads2;

public class Tester2 {

	public static void main(String[] args) throws InterruptedException{
		System.out.println(Thread.currentThread());
		//create n start child thread - using lambda expression
		//name - "child_thrd" , print mesg - "child_thrd" executing
		Thread t1=new Thread(() -> 
		System.out.println(Thread.currentThread().getName()+" exec")
				, "child_thread");
		t1.start();
		
	//	Thread.sleep(100);
		System.out.println("main over.....");

	}

}
