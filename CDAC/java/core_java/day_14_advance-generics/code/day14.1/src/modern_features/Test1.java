package modern_features;

public class Test1 {

	public static void main(String[] args) {
		Formula f1=new Formula1();
		f1.calculate(10, 20);//200
		Formula.show();
		Formula1.show();
		f1=new Formula2();
		f1.calculate(13, 12);
		f1.sqrt(200,100);
		

	}

}
