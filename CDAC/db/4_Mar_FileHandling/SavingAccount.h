#pragma once
#include<iostream>
using namespace std;

class SavingAccount
{
private:
	int accno;
	string name;
	double bal;
public:
	SavingAccount();
	void accept();
	void display();
	int getAccno();
};
