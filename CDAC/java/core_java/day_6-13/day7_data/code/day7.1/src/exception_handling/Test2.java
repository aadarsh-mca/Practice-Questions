package exception_handling;

public class Test2 {

	public static void main(String[] args) {
		System.out.println("Before sleep");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("sleep inrupted!!!!!!!!!");
		}
		System.out.println("After sleep");

	}

}
