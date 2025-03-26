package com.app.fruits.mango;

public class Alphonso extends Mango {
	public Alphonso(String color, double weight, String name) {
		super(color, weight, name);
	}
	
//	@Override
//	public String toString() {
//		return "" + getName() + " - " + getColor() + " - " + getWeight();
//	}
	
	@Override
	public String taste() {
		return "very very sweet";
	}
	
	public void pulp() {
		System.out.println("Name : " + getName() + ", Color : " + getColor());
		System.out.println("\tCreating pulp !!!");
	}
}