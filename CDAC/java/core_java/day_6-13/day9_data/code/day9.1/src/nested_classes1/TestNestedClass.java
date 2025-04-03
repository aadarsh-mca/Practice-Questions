package nested_classes1;



public class TestNestedClass {

	public static void main(String[] args) {
		//invoke inner class' s method - test3()
		A.B ref=new A(100).new B(200);
		ref.test3();

	}

}
