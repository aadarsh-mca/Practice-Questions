package generics;

public class Test {

	public static void main(String[] args) {
		// Create a Holder to hold an int - 12345
		Holder<Integer> intHolder = new Holder<>(12345);// auto boxing
		int data = intHolder.getReference();// auto un boxing
		// Create a Holder to hold a string "hello"
		Holder<String> stringHolder=new Holder<>("hello");//NONE!!!!
		String s=stringHolder.getReference();
	//	intHolder=stringHolder;un comment to understand error !
	}

}
