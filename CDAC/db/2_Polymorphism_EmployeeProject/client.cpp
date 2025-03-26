#include"Manager.h"
#include"SalesPerson.h"
#include"PrintToScreen.h"

int main()
{
	Date doj1(12, 3, 2021);
	Manager m2("King", 45000, doj1, 10000, 4000);
	cout << "\n Manager details are---------";
	//PrintToScreen::displayEmployeeDetails(&m2);
	PrintToScreen::displayEmployeeDetails(m2);
	
	Date doj2(4, 3, 2023);
	SalesPerson sp2("Ernst", 78000, doj2, 1000, 0.10);
	cout << "\n Salesperson details are---------";
	//PrintToScreen::displayEmployeeDetails(&sp2);
	PrintToScreen::displayEmployeeDetails(sp2);

}





