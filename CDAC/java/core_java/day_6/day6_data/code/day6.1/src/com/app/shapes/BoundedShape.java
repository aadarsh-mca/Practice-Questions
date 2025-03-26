package com.app.shapes;

public abstract class BoundedShape {
	private int x;
	private int y;
	public BoundedShape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}	
	//abstract method declaration
	public  abstract double computeArea();
	//{
//		return -1;
//	}

}
