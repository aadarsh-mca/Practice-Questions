#ifndef WHOLESALECUSTOMER_H
#define WHOLESALECUSTOMER_H

#include "Customer.h"

class WholesaleCustomer : public Customer {
private:
	int order_qty;
	int per_unit_price;
	float discount;

	void getWholesaleCustomerData() {
		cout << "Enter the Order Qty : ";
		cin >> order_qty;
		cout << "Enter the Per-Unit-Price : ";
		cin >> per_unit_price;
	}
public:
	WholesaleCustomer(): Customer() {
		getWholesaleCustomerData();
	}

	void display() override {
		Customer::display();
		cout << "\tTotal Order Qty : " << order_qty << endl;
		cout << "\tTotal Per-Unit-Price : " << per_unit_price << endl;
	}

	void calculate_discount_on_qty() {
		if(order_qty > 50) {
			discount = (order_qty * per_unit_price) * 0.15;
		}

		cout << "\t15% Discount : " << discount <<  endl;
		cout << "\tFinal bill : " << ((order_qty * per_unit_price) - discount) << endl;
	}
};

#endif