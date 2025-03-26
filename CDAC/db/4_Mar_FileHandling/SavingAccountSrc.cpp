#include"SavingAccount.h"

SavingAccount::SavingAccount()
{
	accno = 0;
	name = "NA";
	bal = 0.0;
}

void SavingAccount::accept()
{
	cout << "\n enter  the details:";
	cin >> accno >> name >> bal;
}

void SavingAccount::display()
{
	cout << "\n the account details are:------------"<<endl;
	cout << accno << endl;
	cout << name << endl;
	cout << bal << endl;
}

int SavingAccount::getAccno()
{
	return accno;
}