package com.app.core;

public class Student {
	private String rollNo;
	private String name;
	private int marks;

	public Student(String rollNo, String name, int marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	}
	//override equals to replace ref equality by content eq - PK (UID) - identitty
	@Override
	public boolean equals(Object o)
	{
		System.out.println("in student eq");
		if(o instanceof Student)
		{
			Student s=(Student)o;
			return this.rollNo.equals(s.rollNo);
		}
		return false;
	}
	//override hashCode to satisfy the contract between equals n hashCode
	@Override
	public int hashCode() {
		System.out.println("in student hashCode");
//		return 100;
		return this.rollNo.hashCode();
	}

}
