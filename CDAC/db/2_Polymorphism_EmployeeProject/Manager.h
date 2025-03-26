#pragma once
#include"Employee.h"

class Manager :public Employee
{
private:
	double fa, ta;
public:
	Manager();
	Manager(string name, double salary, Date& doj, double fa, double ta);
	void accept();
	void display();
	double computeSal();
};
