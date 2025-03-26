#ifndef CUSTOMER_H
#define CUSTOMER_H

#include <iostream>
using namespace std;

class Customer {
private:
	int id;
	string name;
	string phoneNo;

	void getCustomerData() {
		cout << "\nEnter the following data : " << endl;
		cout << "Enter the customer id : ";
		cin >> id;
		cout << "Enter the customer name : ";
		cin >> name;
		cout << "Enter the customer phone : ";
		cin >> phoneNo;
	}
public:
	Customer() {
		getCustomerData();
	}

	virtual void display() {
		cout << "Customer ID : " << id << endl;
		cout << "Customer Name : " << name << endl;
		cout << "Customer Phone No. : " << phoneNo << endl;
	}
};

#endif