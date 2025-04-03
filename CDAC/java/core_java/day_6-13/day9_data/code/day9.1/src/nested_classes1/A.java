package nested_classes1;

public class A {
	private int i;
	private static int j;
	static {
		j = 12345;
	}

	public A(int i) {
		this.i = i;

	}

	// static method
	static void test() {
		System.out.println("in static method - outer class " + j);
		//how to invoke test3() - inner cls's method
		//create outer class instance n withing that create inner cls instance
		B innerClsRef=new A(11).new B(33);
		innerClsRef.test3();
		
	}

	// non static method = instance method
	void test2() {
		System.out.println("in non static  method - outer class " + i + " " + j);
		//can outer class directly access inner class members ? NO
		B ref=new B(11);
		System.out.println(ref.l);//accessing inner cls's private data member
		ref.test3();
	}

	// Inner class - non static nested class
	class B {
		// private static int k;
		private static final int k = 1234;
		private int l;

		public B(int l) {
			super();
			this.l = l;
		}

		// static method - NO
//		static void show() {
//			
//		}
		// non static method
		/*
		 * Can innner class access outer's members directly ? YES
		 */
		void test3() {
			System.out.println("in inner cls's non static method - " 
		+ i + " " + j + " " + k + "  " + l);
		}

	}
}
