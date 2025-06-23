package threads5;

import static java.lang.Thread.currentThread;

import java.util.stream.IntStream;

public class SumOfOddSquares implements Runnable {
	private int begin;
	private int end;

	public SumOfOddSquares(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
		System.out.println("in ctor of " + getClass() + " invoked by - " + currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println(currentThread().getName() + " strted");
		try {
			int sum = IntStream.rangeClosed(begin, end)
					.filter(i -> i % 2 != 0)
					.map(i -> i * i)
					.sum();
			System.out.println("Sum of sq of odd nos in the range " 
					+ sum + " by " + Thread.currentThread().getName());
		} catch (Exception e) {
			System.out.println("err in thread " + currentThread().getName() + " " + e);
		}
		System.out.println(currentThread().getName() + " over");

	}

}
