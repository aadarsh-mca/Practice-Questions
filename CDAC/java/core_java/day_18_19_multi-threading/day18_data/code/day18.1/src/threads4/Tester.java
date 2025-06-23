package threads4;

public class Tester {

	public static void main(String[] args) throws InterruptedException{
		System.out.println(Thread.currentThread());//Thread [main,5,main]
		//create runnable task
		RunnableTask task=new RunnableTask();
		//create named threads to attach same runnable tasks
		Thread t1=new Thread(task, "one");
		Thread t2=new Thread(task, "two");
		Thread t3=new Thread(task, "three");//runnable - 1
		
		t1.start();
	//	t1.start();
		t2.start();
		t3.start();
		System.out.println(t1.isAlive()+" "+t2.isAlive()+" "+t3.isAlive());//t
		//how many runnable thrds - 4
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " exec counter " + i);
			Thread.sleep(100);
		}		
		System.out.println("main waiting for child thrds to complete exec");
		t1.join();//main gets blocked on join till t1 : dead
		t3.join();//main gets blocked on join till t3 : dead
		System.out.println("main waiting for t2 at the most for 10 secs");
		t2.join(10000);//main gets blocked on join till t2 : dead or tm out 10 secs
		System.out.println("tmout elapsed !!!!!!!, now sending an interrupt to t2");
		t2.interrupt();
		System.out.println("waiting for t2 again");
		t2.join();
		
		System.out.println(t1.isAlive()+" "+t2.isAlive()+" "+t3.isAlive());//f f f 
		System.out.println("main over....");
		

	}

}
