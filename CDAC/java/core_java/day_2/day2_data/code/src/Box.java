class Box {
//state -non static data members (instance vars) - allocated in heap
//tight encapsulation - private state 
 private double width;
 private double depth;
 private double height;
 //add a parameterized ctor to init state of the box
  Box(double w,double d,double height) {
	   this.width=w;//optional 
	   depth=d;
	   this.height=height;//mandatory
  }
  //Add non static method To return Box details in a String form (dims of Box)
   String getBoxDetails() {
	   System.out.println(this);
	   return "Box dims "+width+" "+depth+" "+height;
   }
   //Add non static method To return Box volume
   double getBoxVolume() {
	   
	   return this.width*this.depth*this.height;//optional to use "this" here !
   }
}