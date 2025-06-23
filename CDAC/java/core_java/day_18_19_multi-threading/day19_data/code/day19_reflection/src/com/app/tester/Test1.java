package com.app.tester;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) throws ClassNotFoundException {
		try(Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter name of the class or interface (to find internal details) :: ");
			String className = scan.next();
			
			/**
			 * How to load specifiec class in the memory (method area - metaspace)
			 * 
			 * Method of java.lang.Class<T>
			 * 
			 * 		public static Class<?> forName(String fully_qualified_class_name) throws ClassNotFoundException
			 * 		--> loads the specified class in the method area, then
			 * 			JVM creates the singleton instance of Class<T> in heap and 
			 * 			returns the reference to the caller;
			 * 
			 * 
			 * Trigger for Class Loading :: 
			 * 	1. creating class instance  or
			 * 	2. accessing static members
			 * 	3. Class.forName()
			 * 	4. NameOfClass.class
			 * 
			 */
			
			Class<?> anyClass = Class.forName(className);
			
			if(anyClass.isInterface()) {
				System.out.println(anyClass.getName() + " is a Interface !!!");
				System.out.println("All direct super interfaces :: ");
				System.out.println(Arrays.toString(anyClass.getGenericInterfaces()));
			} else {
				System.out.println(anyClass.getName() + " is a Class !!!");	
				
				System.out.println("All direct super classes :: ");
				System.out.println(anyClass.getSuperclass());
				
				System.out.println("All implemented interfaces :: ");
				Arrays.stream(anyClass.getInterfaces())
//					.forEach(obj -> System.out.println(obj));
					.forEach(System.out::println);

				anyClass.getModifiers();
				
				System.out.println(Arrays.toString(anyClass.getDeclaredFields()));
			}
			
		}
		
	}

}
