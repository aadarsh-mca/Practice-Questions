package threads3;

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
		t2.join();//main gets blocked on join till t2 : dead
		t3.join();//main gets blocked on join till t3 : dead
		System.out.println(t1.isAlive()+" "+t2.isAlive()+" "+t3.isAlive());//f f f 
		System.out.println("main over....");
		

	}

}
