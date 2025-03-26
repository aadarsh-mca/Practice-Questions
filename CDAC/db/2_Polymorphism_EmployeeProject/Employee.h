#pragma once
#include"Date.h"

class Employee
{
protected:
	int empid;
	string name;
	double salary;
	Date doj;
	static int count;
public:
	Employee();
	Employee(string name, double salary, Date& doj);
	virtual void accept();
	virtual void display();
	virtual double computeSal();
	static int getCount();
};