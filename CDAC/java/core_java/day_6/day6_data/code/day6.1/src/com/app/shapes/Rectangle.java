package com.app.shapes;

public class Rectangle extends BoundedShape {
	private double width;
	private double height;

	public Rectangle(int x, int y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangle " + super.toString() + " w=" + width + " h=" + height;
	}
	@Override
	public double computeArea() {
		return width*height;
	}
	

}
