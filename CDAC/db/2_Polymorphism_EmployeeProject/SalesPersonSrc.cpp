#include"SalesPerson.h"

SalesPerson::SalesPerson()
{
	nos = 0;
	comm = 0.0;
}

SalesPerson::SalesPerson(string name, 
	double salary, Date& doj, int nos, double comm)
	:Employee(name,salary,doj)
{
	this->nos = nos;
	this->comm = comm;
}

void SalesPerson::accept()
{
	Employee::accept();
	cout << "\n enter the nos:";
	cin >> nos;
	cout << "\n enter the comm:";
	cin >> comm;
}

void SalesPerson::display()
{
	Employee::display();
	cout << "\n nos-" << nos;
	cout << "\n comm-" << comm;
}

double SalesPerson::computeSal()
{
	return (salary)+(nos * comm);
}