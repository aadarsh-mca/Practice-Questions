package strings;
/*
 *  literal strings vs non literal
 */
public class Test3 {

	public static void main(String[] args) {
		String s1="Hello";
		String s2=new String(s1);
		String s3="Hello";
		String s4="hello";
		System.out.println(s1==s2);//f
		System.out.println(s1==s3);//t
		System.out.println(s1==s4);//f
		
		System.out.println(s1.equals(s2));//t
		System.out.println(s1.equals(s3));//t
		System.out.println(s1.equals(s4));//f
		System.out.println(s1.equalsIgnoreCase(s4));//t
		
		

	}

}
