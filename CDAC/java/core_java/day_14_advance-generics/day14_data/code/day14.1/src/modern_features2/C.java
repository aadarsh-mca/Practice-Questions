package modern_features2;

public class C implements A,B{
// in case of dup method - must override inherited def method
	@Override
	public void show() {
		System.out.println("in class's show method");
		A.super.show();
		B.super.show();
	}

	
}
