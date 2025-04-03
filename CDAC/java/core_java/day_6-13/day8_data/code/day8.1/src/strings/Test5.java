package strings;

import java.util.Date;

public class Test5 {

	public static void main(String[] args) {
		StringBuilder sb1=new StringBuilder("Hello");//1 literal string , 1 dyn created SB
		System.out.println(sb1.length()+" "+sb1.capacity());//5 21
		StringBuilder sb2=sb1.append(123.456);
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb1==sb2);//t
		sb2=sb1.append(true)
		.append(123)
		.append(33.45F)
		.append("asdfghjkl  ")
		.append(new Date());
		System.out.println(sb1);
		System.out.println(sb1);
		sb1.insert(0, "99999999");
		System.out.println(sb1);
		System.out.println(sb1.length()+" "+sb1.capacity());
		sb1.delete(0, sb1.length());
		System.out.println(sb1.length()+" "+sb1.capacity());
		sb1.trimToSize();
		System.out.println(sb1.length()+" "+sb1.capacity());

	}

}
