package modern_features;

public class Formula2 implements Formula {
/*
 * Can imple class inherit the default method - yes
 */
	@Override
	public double calculate(double a, double b) {
		System.out.println("3");		
		return a/b;
	}
	//Can imple class override a default method - yes

	@Override
	public double sqrt(double a, double b) {
		System.out.println("4");
		return Math.sqrt(a-b);
	}
	
	

}
