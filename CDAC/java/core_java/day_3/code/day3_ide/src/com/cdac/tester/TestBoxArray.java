package com.cdac.tester;

import com.cdac.core.Box;
import java.util.Scanner;

public class TestBoxArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of boxes to make");
		Box[] boxes=new Box[sc.nextInt()];//single array object is created
		System.out.println(boxes.getClass());//[Lcom.cdac.core.Box;
		//display array contents - using for each
//		for(Box b : boxes)
//		{
//			System.out.println(b);//null
//	//		b.getBoxDetails();//NPE
//		}
		/*
		 * Accept box dims n store them
		 */
		for(int i=0;i<boxes.length;i++)
		{
			System.out.println("Enter box dims -w d h ");
			boxes[i]=new Box(sc.nextDouble(), 
					sc.nextDouble(), sc.nextDouble());			
		}
		//display box dims n volume - for each
		for(Box b : boxes)
		{
			System.out.println(b.getBoxDetails());
			System.out.println("Volume "+b.getBoxVolume());
		}
		
		sc.close();

	}

}
