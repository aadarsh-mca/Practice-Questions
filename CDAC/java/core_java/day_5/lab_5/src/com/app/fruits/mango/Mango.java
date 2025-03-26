package com.app.fruits.mango;

import com.app.fruits.Fruit;

public class Mango extends Fruit {
	Mango(String color, double weight, String name) {
		super(color, weight, name);
	}
	
//	@Override
//	public String toString() {
//		return "" + getName() + " - " + getColor() + " - " + getWeight();
//	}
	
	@Override
	public String taste() {
		return "sweet";
	}
}