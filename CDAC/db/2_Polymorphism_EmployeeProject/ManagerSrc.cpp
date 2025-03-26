#include"Manager.h"

Manager::Manager() //Manager m1;  1. Employee(); 2. Manager()
{
	fa = 0.0;
	ta = 0.0;
}

// Manager m2("King",56000, doj1,10000,5000)
//and if we skip on member init list
//then 1. Employee() 2. Manager(para)- wrong
//we need 1. Employee(para) 2. Manager(para)- correct
//hence we need to provide memebr init list


Manager::Manager(string name, 
	double salary, Date& doj, double fa, double ta)
	:Employee(name,salary,doj)
{
	this->fa = fa;
	this->ta = ta;
}

void Manager::accept()
{
	Employee::accept(); //invoke base class fun using class name
	cout << "\n enter the food all:";
	cin >> fa;
	cout << "\n enter  the travel all:";
	cin >> ta;
}

void Manager::display()
{
	Employee::display();
	cout << "\n fa-" << fa;
	cout << "\n ta-" << ta;
}

double Manager::computeSal()
{
	return salary + fa + ta;
}