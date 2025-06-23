package threads5;
import static java.lang.Thread.currentThread;

import java.util.stream.IntStream;

public class EvenPrinterTask implements Runnable{
	private int begin;
	private int end;
	

	public EvenPrinterTask(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
		System.out.println("in ctor of "+getClass()+" invoked by - "+currentThread().getName());
	}


	@Override
	public void run() {
		System.out.println(currentThread().getName()+" strted");
		try {
			IntStream.rangeClosed(begin, end)
			.filter(i -> i % 2 == 0)
			.forEach(i -> System.out.println("Even "+i));//i -> sop ("Even no i")
		} catch (Exception e) {
			System.out.println("err in thread "+currentThread().getName()+" "+e);
		}
		System.out.println(currentThread().getName()+" over");
		
	}

}
