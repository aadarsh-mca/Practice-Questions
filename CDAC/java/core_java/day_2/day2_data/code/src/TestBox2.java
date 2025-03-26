/*
Go through code sample n guess what will happen ?

*/

class TestBox {
	 public static void main(String[] args) {
		 int data;
		 System.out.println(data);		 
		  Box b1; 
		  System.out.println(b1);
	      b1=new Box(10,20,30);
		  System.out.println(b1);
		  System.out.println(b1.getBoxDetails());
		  Box b2=b1;
		   System.out.println(b2);
		  System.out.println(b2.getBoxDetails());
		  b1=null;//any objs marked for GC ?
		  System.out.println(b1.getBoxDetails());
		  System.out.println(b2.getBoxDetails());
		  b2=null;//any objs marked for GC ?
		  Box b3=new Box(1,2,3);
		  b3=new Box(4,5,6);//any objs marked for GC ?
	
		  //close scanner - to avoid resource leak
		  sc.close();
	 }
}