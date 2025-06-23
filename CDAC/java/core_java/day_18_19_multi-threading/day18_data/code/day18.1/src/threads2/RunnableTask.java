package threads2;

public class RunnableTask implements Runnable {
	

	/*overriding or implementing form of the  method 
	 * can't throws any NEW or BROADER checked exceptions	  
	 */
	@Override
	public void run() /* throws Exception */ {
		System.out.println(Thread.currentThread().getName() + " strted");
		try {
			// dummy B.L - for loop
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " exec counter " + i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " thread got exc " + e);
		}
		System.out.println(Thread.currentThread().getName() + " over");
	}

}
