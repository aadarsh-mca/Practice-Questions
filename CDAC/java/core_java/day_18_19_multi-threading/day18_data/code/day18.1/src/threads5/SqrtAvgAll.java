package threads5;

import static java.lang.Thread.currentThread;

import java.util.stream.IntStream;

public class SqrtAvgAll implements Runnable {
	private int begin;
	private int end;

	public SqrtAvgAll(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
		System.out.println("in ctor of " + getClass() + " invoked by - " + currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println(currentThread().getName() + " strted");
		try {
			double avg = IntStream.rangeClosed(begin, end)
			.mapToDouble(i -> Math.sqrt(i)) 
			.average()
			.orElseThrow(() -> new RuntimeException("Empty stream !!!!!"));
					
			System.out.println("avg " 
					+ avg + " by " + Thread.currentThread().getName());
		} catch (Exception e) {
			System.out.println("err in thread " + currentThread().getName() + " " + e);
		}
		System.out.println(currentThread().getName() + " over");

	}

}
