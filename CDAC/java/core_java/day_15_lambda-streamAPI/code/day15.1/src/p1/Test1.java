package p1;

public class Test1 {

	public static void main(String[] args) {
		//addition of 2 doubles - using Computable
		Computable adder = new Adder();
		System.out.println(adder.compute(10, 20));
		//create ano inner class - to multiply 2 nums
		Computable multiplier=new Computable() {
			
			@Override
			public double compute(double a, double b) {
				// TODO Auto-generated method stub
				return a*b;
			}
		};
		System.out.println(multiplier.compute(12, 34));
		//Since Java SE 8 -- Functinal prog -- Functional i/f
		/*
		 * Function i/f  can be substituted by lambda expression
		 * double compute(double a, double b);
		 */
		Computable divider=(a,b)-> a/b;//function literal 
		/*
		 * Function literal = assigning lambda expression to the variable
		 * (func i/f reference)
		 */
		System.out.println("division"+divider.compute(26, 5));
		
		System.out.println("division"+divider.compute(28, 15));
		
		
		
	

	}

}
