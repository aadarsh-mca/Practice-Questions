package modern_features;

public interface Formula {
	// javac - public static final
	int DATA = 100;

	// javac - public abstract
	double calculate(double a, double b);

	// default method - 
	//default keyword => default method imple.
	//javac - public 
	default double sqrt(double a, double b) {
		System.out.println("1");
		return Math.sqrt(a + b);
	}
	//static method , javac - public 
	static void show() {
		System.out.println("in i/f  static method");
	}

}
