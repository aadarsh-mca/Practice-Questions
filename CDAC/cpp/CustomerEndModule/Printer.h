#ifndef PRINTER_H
#define PRINTER_H

#include <iostream>
using namespace std;

class Printer {
public:
	static void menu(int &choice) {
		cout << "\n==========================================" << endl;
		cout << "Press '1' : Add new customer...." << endl;
		cout << "Press '2' : Display all customer details...." << endl;
		cout << "Press '3' : Exit...." << endl;
		cin >> choice;
	}

	static void addCustomerMenu(int &choice) {
		cout << "\n\tPress '1' : Add Retail Customer...." << endl;
		cout << "\tPress '2' : Add Wholesale Customer...." << endl;
		cin >> choice;
	}

	static void displayCustomerDetail(Customer *customer) {
		cout << "\n--> Here are the Customer Data : " << endl;
		customer->display();

		if(typeid(*customer) == typeid(RetailCustomer)) {
			cout << "\nHere are the Retail_Customer specific Data : " << endl;
			RetailCustomer *retail = dynamic_cast<RetailCustomer*>(customer);
			retail->calculate_discount();
		}

		if(typeid(*customer) == typeid(WholesaleCustomer)) {
			cout << "\nHere are the Wholesale_Customer specific Data : " << endl;
			WholesaleCustomer *wholesale = dynamic_cast<WholesaleCustomer*>(customer);
			wholesale->calculate_discount_on_qty();
		}
	}
};

#endif // !PRINTER_H
