package com.app.tester;

import java.util.Scanner;
import com.app.fruits.Fruit;
import com.app.fruits.Apple;
import com.app.fruits.Orange;
import com.app.fruits.mango.Alphonso;

public class FruitBasket {
	
	private static int cartCapacity = 0;
	private static int cartCounter = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Enter the size of your Fruit Basket : ");
		cartCapacity = scan.nextInt();
		
		Fruit[] fruitCart = new Fruit[cartCapacity];
		boolean toExit = false;
		
		while(toExit == false) {
			printOption();
			switch(scan.nextInt()) {
			case 1:
				if(isCartFull() == false) {
					System.out.println("Enter the detail of Alphonso in the following order : \n'Color', 'Weight', 'Name' -->");
					fruitCart[cartCounter++] = new Alphonso(scan.next(), scan.nextDouble(), scan.next());
				}
				break;
			case 2:
				if(isCartFull() == false) {
					System.out.println("Enter the detail of Orange in the following order : \n'Color', 'Weight', 'Name' -->");
					fruitCart[cartCounter++] = new Orange(scan.next(), scan.nextDouble(), scan.next());
				}
				break;
			case 3:
				if(isCartFull() == false) {
					System.out.println("Enter the detail of Apple in the following order : \n'Color', 'Weight', 'Name' -->");
					fruitCart[cartCounter++] = new Apple(scan.next(), scan.nextDouble(), scan.next());
				}
				break;
			case 4:
				printNameOfFruits(fruitCart);
				break;
			case 5:
				printAllDetailOfFruits(fruitCart);
				break;
			case 6:
				makeSpecialDish(fruitCart);
				break;
			//
			case 7:
				markStale(scan, fruitCart);
				break;
			case 8:
				markSourStale(scan, fruitCart);
				break;
			//
			case 0:
				toExit = true;
				cartCounter = 0;
				cartCapacity = 0;
				break;
			default:
				System.out.println("Invalid option selected.......");
			}
		}
	
	}
	
	private static boolean isCartFull() {
		return (cartCounter >= cartCapacity);
	}
	
	private static void printOption() {
		System.out.println("Press 1. Add Alphonso");
		System.out.println("Press 2. Add Orange");
		System.out.println("Press 3. Add Apple");
		//
		System.out.println("Press 4. Display name of all fruits in cart...");
		System.out.println("Press 5. Display name, color, weight of all fruits in cart...");
		System.out.println("Press 6. Make special dish !!!");
		//
		System.out.println("Press 7. Mark given fruit - stale !!!");
		System.out.println("Press 8. Mark all sour fruit - stale !!!");
		//
		System.out.println("Press 0. Exit ");
	}
	
	private static void printNameOfFruits(Fruit[] cart) {
		int idx = 1;
		for(Fruit fruit : cart) {
			System.out.println("\tItem at index number " + idx++ + " : " + fruit.getName());
		}
	}
	
	private static void printAllDetailOfFruits(Fruit[] cart) {
		int idx = 1;
		for(Fruit fruit : cart) {
			System.out.println("Item at " + idx++ + " -- \n\tName : " + fruit.getName() + "\n\tColor : " + fruit.getColor() + "\n\tWeight : " + fruit.getWeight() + "\n\tTaste : " + fruit.taste() + "\n\tisFresh : " + fruit.getIsFreshFalse());
		}
	}
	
	private static void makeSpecialDish(Fruit[] cart) {
		/*
		 * System.out.println("Press 1. Apple Jam");
		 * System.out.println("Press 2. Orange Juice");
		 * System.out.println("Press 3. Mango Pulp");
		 */
		for(Fruit fruit : cart) {
			if(fruit instanceof Apple) {
				((Apple)fruit).jam();
			} else if(fruit instanceof Orange) {
				((Orange)(fruit)).juice();
			} else {
				((Alphonso)fruit).pulp();
			}
		}
		
	}
	
	private static void markStale(Scanner scan, Fruit[] cart) {
		System.out.println("Enter the index of fruit to make it stale : ");
		int idx = scan.nextInt();
		if(idx >= cartCapacity) {
			System.out.println("Invalid choice !!!");
		} else {
			cart[idx].setIsFreshFalse();
		}
	}
	
	private static void markSourStale(Scanner scan, Fruit[] cart) {
		for(Fruit fruit : cart) {
			if(fruit != null && fruit.taste().equals("sour")) {
				fruit.setIsFreshFalse();
			}
		}
	}
	
}