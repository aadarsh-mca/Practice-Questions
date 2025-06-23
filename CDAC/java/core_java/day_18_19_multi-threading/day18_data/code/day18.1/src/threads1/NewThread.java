package threads1;

public class NewThread extends Thread {
	public NewThread(String name) {
		super(name);// state : NEW
	}

	/*overriding or implementing form of the  method 
	 * can't throws any NEW or BROADER checked exceptions	  
	 */
	@Override
	public void run() /* throws Exception */ {
		System.out.println(getName() + " strted");
		try {
			// dummy B.L - for loop
			for (int i = 0; i < 10; i++) {
				System.out.println(getName() + " exec counter " + i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println(getName() + " thread got exc " + e);
		}
		System.out.println(getName() + " over");
	}

}
