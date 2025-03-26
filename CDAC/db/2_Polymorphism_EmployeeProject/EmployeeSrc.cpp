#include"Employee.h"
int Employee::count = 100;
Employee::Employee()
{
	count++;
	empid = count;
	name = "NA";
	salary = 0.0;
}
Employee::Employee(string name, double salary, Date& doj)
{
	count++;
	empid = count;
	this->name = name;
	this->salary = salary;
	this->doj = doj;
}

void Employee::accept()
{
	cout << "Enter the name:";
	cin >> name;
	cout << "\n enter the salary:";
	cin >> salary;
	doj.accept();
}

void Employee::display()
{
	cout << "\n the details are:";
	cout << "\n id-" << empid;
	cout << "\n name-" << name;
	cout << "\n salary-" << salary;
	doj.display();
}

int Employee::getCount()
{
	return count;
}

double Employee::computeSal()
{
	return salary;
}