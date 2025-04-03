package non_generic;

public class Test {

	public static void main(String[] args) {
		// Create a Holder to hold an int - 12345
		Holder intHolder=new Holder(12345);//auto boxing --> up casting
		System.out.println(intHolder.getReference().getClass());
		int data=(Integer)intHolder.getReference();
		// Create a Holder to hold a string "hello"
		Holder stringHolder=new Holder("hello");//up casting
		String s=(String)stringHolder.getReference();
		intHolder=stringHolder;
		data=(Integer)intHolder.getReference();//class cast exc !!!!!
		System.out.println(data);
	}

}
