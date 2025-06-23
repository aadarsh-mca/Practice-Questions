package com.developers.geometry;

public class Point2D {
//state : tight encapsulation
 private int x;
 private int y;
 //ctor
  public Point2D(int x,int y)
  {
     this.x=x;
	 this.y=y;
  }
  //add show method to return x n y
  public String show() {
     return "Point at "+x+" , "+y;
  }
  //add isEqual to test equality of 2 points
  //this=p1 , anotherPoint=p2
  public boolean isEqual(Point2D anotherPoint){
	  System.out.println(this);
	  System.out.println(anotherPoint);
	  return this.x==anotherPoint.x && this.y == anotherPoint.y;
  }

}