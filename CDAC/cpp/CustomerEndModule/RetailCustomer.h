#ifndef RETAILCUSTOMER_H
#define RETAILCUSTOMER_H

#include "Customer.h"

class RetailCustomer : public Customer {
private:
	float orderAmt;
	float discount;

	void getRetailCustomerData() {
		cout << "Enter the Order Amount : ";
		cin >> orderAmt;
	}
public:
	RetailCustomer() : Customer() {
		getRetailCustomerData();
	}

	void display() override {
		Customer::display();
		cout << "\tTotal Order Amount : " << orderAmt << endl;
	}

	void calculate_discount() {
		if(orderAmt > 1000) {
			// give 10% discount
			discount = orderAmt * 0.1;
		}

		cout << "\t10% Discount : " << discount << endl;
		cout << "\tFinal bill : " << (orderAmt - discount) << endl;
	}
};

#endif