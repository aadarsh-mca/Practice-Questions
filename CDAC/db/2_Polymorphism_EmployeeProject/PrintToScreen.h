#include<iostream>
using namespace std;
#include"Employee.h"
class PrintToScreen
{
public:
	//display the details of an employee recevied in para - generic pointer
	/*static void displayEmployeeDetails(Employee * emp)
	{
		emp->display();
	}*/

	static void displayEmployeeDetails(Employee& emp)  //emp is a generic ref
	{
		emp.display();
		cout << "\n the computed salary is:" << emp.computeSal();
	}
};