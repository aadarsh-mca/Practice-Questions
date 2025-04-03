#include "PrintInfo.h"
#include "LoginHelper.h"
#include "Library.h"
#include <vector>

void librarianMenu(Library &lib) {
	int choice;
	do {
		cout << "\nLibrarian Menu:\n1. Add Book\n2. Remove Book\n3. View Books\n4. Logout\nEnter choice: ";
		cin >> choice;
		switch(choice) {
		case 1: lib.addBook(); break;
		case 2: lib.removeBook(); break;
		case 3: lib.viewBooks(); break;
		case 4: return;
		default: cout << "Invalid choice!\n";
		}
	} while(true);
}

void studentMenu(Library &lib) {
	int choice;
	do {
		cout << "\nStudent Menu:\n1. View Books\n2. Borrow Book\n3. Return Book\n4. Logout\nEnter choice: ";
		cin >> choice;
		switch(choice) {
		case 1: lib.viewBooks(); break;
		case 2: lib.borrowBook(); break;
		case 3: lib.returnBook(); break;
		case 4: return;
		default: cout << "Invalid choice!\n";
		}
	} while(true);
}

void printLoginOption() {
	cout << "\n\tPress '1' to continue as Librarian" << endl;
	cout << "\tPress '2' to continue as Student" << endl;
	cout << "\n\tPress '9' to Exit." << endl;
}

int main() {
	int loginOption;
	cout << "Welcome to IACSD Library !!!" << endl;
	cout << "\nSelect the option to proceed : " << endl;

	Library lib;

	bool exit = false;
	bool isLoggedIn = false;

	while (exit == false) {
		printLoginOption();
		cin >> loginOption;

		switch (loginOption) {
		case 1:
		if(isLoggedIn == false) {
			try {
				isLoggedIn = LoginHelper::startLoginProcess();
				cout << "\nLogin successful as Librarian....." << endl;

				librarianMenu(lib);
				exit = true;
			} catch(CustomException& error) {
				cout << error.getMessage() << endl;
			}
		}
			break;
		case 2:
			cout << "Logged in as Student...." << endl;
			studentMenu(lib);
			break;
		case 9 :
			exit = true;
			cout << "Closing the library app...." << endl;
			break;
		default :
			cout << "Invalid option selected !!! \nPlease select a valid option....";
		}
	}

	return 0;
}