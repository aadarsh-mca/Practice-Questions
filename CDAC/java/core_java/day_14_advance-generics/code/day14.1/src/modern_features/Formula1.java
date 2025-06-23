package modern_features;

public class Formula1 implements Formula {
/*
 * Can imple class inherit the default method - yes
 */
	@Override
	public double calculate(double a, double b) {
		System.out.println("2");
		//calling static method - with i/f Name.static method name
		Formula.show();
		return a*b;
	}
	//@Override
	static void show() {
		System.out.println("in class static method");
	//	Formula.show();
	}

}
