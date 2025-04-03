package wrappers;

import java.time.LocalDate;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
	//	Integer i1=new Integer(100);//boxing
		Integer i1=Integer.valueOf(100);//boxing
		int data=i1.intValue();//un boxing
		i1=12345;//auto boxing
		data=i1;//auto un boxing
		Double d1=123.456;//auto boxing (double -> Double)
		Character ch='a';//auto boxing
		String s="12345678";
//		s++;
//		s *= 1234;
	//	s += "gfdh";
		LocalDate date=LocalDate.now();
	//	date++;
		i1++;//auto un boxing, inc , auto box
		System.out.println(i1);
		d1 += 10.5;
		System.out.println(d1);
		double d2=123.456f;//widening conversion
		//d1=123.45f;//javac - auto boxing (float --> Float) ---X-- converted to Double
		d1=(double)123.45f;//auto boxing - javac
		d2=12345;
		d1=(double)12345;
		Number n1=123.456f;//auto boxing , up casting
		System.out.println(n1.getClass());//java.lang.Float
		n1=123;
		System.out.println(n1.getClass());//java.lang.Integer
		/*
		 * Is Java pure object oriented ? NO 
		 * since it supports - primitive types for efficiency purpose
		 * + it does not support all OO features.
		 * Can Object type reference , refer to ANY type (primitves as well
		 * ref types in Java ) ? YES
		 */
		Object o=12345;//auto boxing ---> up casting
		System.out.println(o.getClass());//java.lang.Integer
		o=12.3456;
		System.out.println(o.getClass());//java.lang.Double
		o=100;
		o=true;
		o='d';
		o=new Date();//up casting !
		

	}

}
