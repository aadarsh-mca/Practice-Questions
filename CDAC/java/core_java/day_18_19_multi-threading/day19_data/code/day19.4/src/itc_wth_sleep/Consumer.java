package itc_wth_sleep;

public class Consumer implements Runnable {
	private EmpUtils u;
	private boolean exit;
	public Consumer(EmpUtils u) {
		this.u=u;
	}

	@Override
	public void run() {
		System.out.println("started thrd  -- "
				+ Thread.currentThread().getName());
		try {
		
			while (!exit) {
			//	System.out.println("Read Data "+u.readData());
				u.readData();
				Thread.sleep(40);
			}
		} catch (Exception e) {
			System.out.println("err in " + Thread.currentThread().getName()
					+ "  " + e);
		}
		System.out.println("thrd over -- " + Thread.currentThread().getName());

	}
	public void stop()
	{
		exit=true;
	}

}
