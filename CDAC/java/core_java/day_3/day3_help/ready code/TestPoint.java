package com.tester;
import java.util.Scanner;
import com.developers.geometry.Point2D;
class TestPoint {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter x n y for the 1st point");//10 20
		Point2D p1=new Point2D(sc.nextInt(),sc.nextInt());
		System.out.println(p1.show());
		System.out.println("Enter x n y for the 2nd point");//10 20
		Point2D p2=new Point2D(sc.nextInt(),sc.nextInt());
		System.out.println(p2.show());
		System.out.println("p1 : "+p1);
		System.out.println("p2 : "+p2);
		System.out.println(p1.isEqual(p2));
		System.out.println(p1==p2);		
		sc.close();
	}
}