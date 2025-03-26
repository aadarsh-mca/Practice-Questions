package com.app.fruits;

public abstract class Fruit {
	private String color;
	private double weight;
	private String name;
	private boolean isFresh;
	
	protected Fruit(String color, double weight, String name) {
		this.color = color;
		this.weight = weight;
		this.name = name;
		this.isFresh = true;
	}
	
	public abstract String taste();
	
	@Override
	public String toString() {
		return name + " -> " + color + " -> " + weight;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setName(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getIsFreshFalse() {
		return isFresh;
	}
	
	public void setIsFreshFalse() {
		this.isFresh = false;
	}
}