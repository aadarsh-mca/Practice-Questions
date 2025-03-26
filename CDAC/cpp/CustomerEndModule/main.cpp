#include "Customer.h"
#include "RetailCustomer.h"
#include "WholesaleCustomer.h"
#include "Printer.h"

#include <vector>

int main () {
	vector<Customer *> customerList;
	bool toExit = false;

	while(toExit == false) {
		int menuChoice = 0;
		Printer::menu(menuChoice);

		int addCustomerMenuChoice = 1;

		switch(menuChoice) {
		case 1:
			Printer::addCustomerMenu(addCustomerMenuChoice);

			if(addCustomerMenuChoice == 1) {
				customerList.push_back(new RetailCustomer());
			} else if(addCustomerMenuChoice == 2) {
				customerList.push_back(new WholesaleCustomer());
			}
			break;
		case 2:
			for(int i=0; i < customerList.size(); i++) {
				Printer::displayCustomerDetail(customerList[i]);
			}

			break;
		case 3:
			toExit = true;
			break;
		default:
			cout << "Invalid input !!!";
		}
	}


	return 0;
}