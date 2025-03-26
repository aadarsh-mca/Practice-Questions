#pragma once
#include"Employee.h"

class SalesPerson :public Employee
{
private:
	double comm;
	int nos;
public:
	SalesPerson();
	SalesPerson(string name, double salary, Date& doj, int nos, double comm);
	void accept();
	void display();
	double computeSal();
};
