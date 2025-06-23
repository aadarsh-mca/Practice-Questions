package itc_wth_sleep;

public class EmpUtils {
	private Emp e;
	private boolean dataReady;
	
	/**
	 * 
	 * Helpful when CPU calls Consumer thread again after reading the data (without getting produced by Producer)
	 * Or
	 * when CPU calls Producer thread again after producing the data (without getting read by Consumer)
	 * 
	 */

	public synchronized void writeData(Emp ref) throws Exception {
		System.out.println("write entered --- " + Thread.currentThread().getName());
		while(dataReady) {
//			Thread.sleep(23);
			this.wait();  // signal the producer(itself) to wait until consumer read the data
		}
		// produce data
		e = ref;
		System.out.println("Write Data " + e);
		System.out.println("write exited --- " + Thread.currentThread().getName());
		dataReady=true;
		this.notify();  // producer sending notification signal -> consumer
	}

	public synchronized Emp readData() throws Exception {
		System.out.println("r entered --- " + Thread.currentThread().getName());
		while(!dataReady) {
//			Thread.sleep(29);
			this.wait();  // signal the consumer(itself) to wait until producer creates the data
		}
		// consume data
		System.out.println("Read  Data " + e);
		System.out.println("r exited --- " + Thread.currentThread().getName());
		dataReady=false;
		this.notify();  // consumer sending notification signal -> producer
		return e;
	}

}
