#pragma once
#include"SavingAccount.h"
#include<fstream>

class FileIO
{
public:
	static void writeToFile()
	{
		fstream fs;
		fs.open("AccountData.dat", ios::out|ios::binary);
		char wish;
		do
		{
			SavingAccount acc;
			acc.accept();
			fs.write((char*)&acc, sizeof(acc));
			cout << "Do u want to enter more records:";
			cin >> wish;
		} while (wish == 'y' || wish == 'Y');

		fs.close();
	}
	static void readFromFile()
	{
		fstream fs;
		fs.open("AccountData.dat", ios::in);
		SavingAccount acc;
		while (fs.read((char*)&acc, sizeof(acc)))
		{
			acc.display();
		}
		fs.close();
	}

	static void searchByAccountNo(int accno)
	{
		fstream fs;
		fs.open("AccountData.dat", ios::in);
		SavingAccount acc;
		while (fs.read((char*)&acc, sizeof(acc)))
		{
			if (acc.getAccno() == accno)
			{
				acc.display();
				break;
			}
		}
		fs.close();
	}
};
