package com.app.fruits;

public class Orange extends Fruit {
	public Orange(String color, double weight, String name) {
		super(color, weight, name);
	}
	
//	@Override
//	public String toString() {
//		return "" + getName() + " - " + getColor() + " - " + getWeight();
//	}
	
	@Override
	public String taste() {
		return "sour";
	}
	
	public void juice() {
		System.out.println("Name : " + getName() + ", Weight : " + getWeight());
		System.out.println("\tExtracting juice !!!");
	}
}