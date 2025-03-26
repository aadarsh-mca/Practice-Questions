#include "Product.h"
using namespace std;

int main() {
	string name;
	float price;

	cout << "Enter the detail of product : " << endl;
	cout << "\tName : ";
	cin >> name;
	cout << "\tPrice : ";
	cin >> price;

	try {
		Product *prod = new Product(name, price);
	}
	catch (CustomException exception) {
		cout << exception.getMessage();
	}

	return 0;
}