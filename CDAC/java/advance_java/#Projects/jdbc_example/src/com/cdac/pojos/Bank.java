package com.cdac.pojos;

public class Bank {
	private int id;
	private String name;
	private String type;
	private double bal;
	
	public Bank(int id, String name, String type, double bal) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.bal = bal;
	}
	
	
	
	@Override
	public String toString() {
		return "Bank [\n\tid = " + id + ", \n\tname = " + name + ", \n\ttype = " + type + ", \n\tbal = " + bal + "\n ]";
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	
	

}
