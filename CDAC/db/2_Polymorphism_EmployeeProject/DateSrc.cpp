#include"Date.h"

Date::Date()
{
	day = 1;
	month = 1;
	year = 2025;
}

Date::Date(int day, int month, int year)
{
	this->day = day;   //curr object's day=para day value
	this->month = month;
	this->year = year;
}
void Date::accept()
{
	cout << "\n Enter the date:";
	cin >> day >> month >> year;

}
void Date::display()
{
	cout << "\n date " << day << "/" << month << "/" << year;
}

int Date::getYear()
{
	return year;
}

void Date::setYear(int year)
{
	this->year = year;
}