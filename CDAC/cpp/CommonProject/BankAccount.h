#include <iostream>
using namespace std;

class BankAccount {
private:
	int accNo;
	string name;
	string phoneNo;
public:
	BankAccount() {
		cout << "\nEnter the following details one by one : " << endl;
		cout << "Enter account number : ";
		cin >> accNo;
		cout << "Enter account holder name : ";
		cin >> name;
		cout << "Enter account holder phone number : ";
		cin >> phoneNo;
	}

	void displayPersonalInfo() {
		cout << "\nThe details of " << name << "'s saving account are : " << endl;
		cout << "Account No. : " << accNo << endl;
		cout << "Name : " << name << endl;
		cout << "Phone No : " << phoneNo << endl;
	}

	int getAccNo() {
		return accNo;
	}

	string getName() {
		return name;
	}

	string getPhoneNo() {
		return phoneNo;
	}
};