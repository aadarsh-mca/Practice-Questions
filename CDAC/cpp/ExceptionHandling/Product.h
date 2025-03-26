#include <iostream>
using namespace std;
#include "CustomException.h"

class Product {
private:
	string name;
	float price;
public:
	Product(string name, float price) {
		this->name = name;

		if (price <= 0) {
			throw CustomException("The price of " + name + " cannot be negative !!!");
		}

		this->price = price;
	}

};