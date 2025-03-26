#include "BankAccount.h"

class SavingAccount: public BankAccount {
private:
	float balance;
public:
	SavingAccount() 
		: BankAccount() {
		cout << "Enter Saving account balance : ";
		cin >> balance;
	}
	
	float& getBalance() {
		return balance;
	}

	void displaySavingInfo() {
		displayPersonalInfo();
		cout << "Saving Account Balance : " << getBalance() << endl;
	}
};