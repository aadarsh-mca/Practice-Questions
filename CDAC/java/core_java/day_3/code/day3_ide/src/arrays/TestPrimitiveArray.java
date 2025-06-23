package arrays;

import java.util.Scanner;

public class TestPrimitiveArray {

	public static void main(String[] args) {
		//create scanner instance to wrap console i/p
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of doubles , "
				+ "to be stored in the array");
		/*
		 * 1. array class i sloaded in method area
		 * 2. array object created in the heap
		 * 3. array ref is stored in the stack - data
		 */
		double[] data;//data - array type of ref var
		data=new double[sc.nextInt()];//RHS - array object
		//how to find the name of the cls loaded ?
		System.out.println("loaded class "+data.getClass());//[D
		//display array contents - for loop
		System.out.println("Default contents of the array -");
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		//accept array data from the client n fill up array
		for(int i=0;i<data.length;i++) {
			System.out.println("Enter next double value");
			data[i]=sc.nextDouble();
		}
		//display array data again ,using for-each
		System.out.println("Inited contents of the array using for-each");
//		for(int i=0;i<data.length;i++) {
//			System.out.print(data[i]+" ");
//		}
		for(double d1 : data)//d1=data[0].....d1=data[data.length-1]
			System.out.print(d1+" ");
		//doubling data
		for(double d : data) {
			d *= 2;
		}
		
		System.out.println("contents after doubling ");
		for(double d : data)
			System.out.print(d+" ");

		sc.close();

	}

}
