package legacy_dates;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		Date d1=new Date();
		System.out.println(d1);
		Date d2=new Date(5000);
		System.out.println(d2);
		System.out.println(d1.getTime());
		System.out.println(d2.getTime());
		System.out.println(d1.before(d2));//f
		System.out.println(d1.after(d2));//t
		System.out.println(d1.equals(d2));//f
		System.out.println(d1.compareTo(d2));//1

	}

}
