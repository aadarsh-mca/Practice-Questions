package hashmaps;

//public class Student {
public class Student implements Comparable<Student> {
	private String rollNo;
	private String name;
	private int marks;

	public Student(String rollNo, String name, int marks) {
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}
	
	

	public String getRollNo() {
		return rollNo;
	}



	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getMarks() {
		return marks;
	}



	public void setMarks(int marks) {
		this.marks = marks;
	}



	@Override
	public String toString() {
		return "  Student [rollNo = " + rollNo + ", name = " + name + ", marks = " + marks + "]\n";
	}
	
	@Override
	public int compareTo(Student aStudent) {
		return this.getName().compareTo(aStudent.getName());
	}
	
	
	
	//override equals to replace ref equality by content eq - PK (UID) - identitty
//	@Override
//	public boolean equals(Object o)
//	{
//		System.out.println("in student eq");
//		if(o instanceof Student)
//		{
//			Student s=(Student)o;
//			return this.rollNo.equals(s.rollNo);
//		}
//		return false;
//	}
	//override hashCode to satisfy the contract between equals n hashCode
//	@Override
//	public int hashCode() {
//		System.out.println("in student hashCode");
////		return 100;
//		return this.rollNo.hashCode();
//	}

}
