#include "BankAccount.h"

class CurrentAccount: public BankAccount {
private:
	float balance;
public:
	CurrentAccount() : BankAccount() {
		cout << "Enter Current account balance : ";
		cin >> balance;
	}
	float& getBalance() {
		return balance;
	}

	void displayCurrentInfo() {
		displayPersonalInfo();
		cout << "Current Account Balance : " << getBalance() << endl;
	}
};