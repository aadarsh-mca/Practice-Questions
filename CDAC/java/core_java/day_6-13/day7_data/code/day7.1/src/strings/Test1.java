package strings;

public class Test1 {

	public static void main(String[] args) {
		String s1 = "Hello World";
		String s2 = s1.concat("Hi there !!!!");
		System.out.println(s1);
		System.out.println(s2);
		s1 += " testing strings";//s1 = s1.concat("testing strings");
		System.out.println(s1);//Hello World testing strings
		System.out.println(s1.toUpperCase());//upper cased
		String s3=s1.toUpperCase();
		System.out.println(s1);//orig
		System.out.println(s3);//upper cased
		s2=s1.replace('t','p');
		System.out.println(s1);
		System.out.println(s2);

	}

}
