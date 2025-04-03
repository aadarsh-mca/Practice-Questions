package com.app.tester;
import com.app.shapes.*;

public class TestBoundedShapes {

	public static void main(String[] args) {
		/*
		 * create array of shapes n init it
		 * {c1,r1,c2,r2}
		 */
	//	BoundedShape myShape=new BoundedShape(10,20);
		BoundedShape[] shapes= {new Circle(10,20, 10.5),
				new Rectangle(30, 40, 10, 20.5),
				new Circle(11,21, 31.5),
				new Rectangle(15,25,13.3,14.4)}; //up casting 
		//for each & display details , area
		for(BoundedShape shape : shapes)
		{
			System.out.println(shape);//run time poly.			
			System.out.println(shape.computeArea());//run time poly.	
		}

	}

}
