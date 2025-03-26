
#include"FileIO.h"
#include"SavingAccount.h"

int main()
{
	cout << "\n 1. Write Account data to file " <<
		"\n 2. Read all account data" <<
		"\n 3. Search By Accno";
	cout << "\n Enter your choice:";
	int choice;
	cin >> choice;
	switch (choice)
	{
	case 1:
		cout << "\n writing the data into file";
		FileIO::writeToFile();
		break;
	case 2:
		cout << "\n reading the data from file";
		FileIO::readFromFile();
		break;
	case 3:
		cout << "\n enter the accno to search:";
		int accno;
		cin >> accno;
		FileIO::searchByAccountNo(accno);
		break;
	default:
		break;
	}
	
	
}