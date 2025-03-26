#pragma once
#include<iostream>
using namespace std;
class Date
{
private:
	int day, month, year;
public:
	Date(); //no-args constr
	Date(int day, int month, int year); //para constr
	void accept(); //mutator- changes the state of a current object
	void display(); //facilitator- display the current state of an object
	int getYear();  //accessor- reads the state of a current object
	void setYear(int year);  //mutator
};
