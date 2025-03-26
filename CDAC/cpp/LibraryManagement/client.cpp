#include "PrintInfo.h"
#include "LoginHelper.h"
#include "Librarian.h"
#include "Student.h"
#include "LibraryData.h"

int main() {
	int loginOption;
	cout << "Welcome to IACSD Library !!!" << endl;
	cout << "\nSelect the option to proceed : " << endl;

	//Storage::updateLoginCredential("iacsd","iacsd@123");

	bool exit = false;
	bool isLoggedIn = false;

	while (exit == false) {
		PrintInfo::printLoginOption();
		cin >> loginOption;

		switch (loginOption) {
		case 1:
		if(isLoggedIn == false) {
			try {
				isLoggedIn = LoginHelper::startLoginProcess();
				cout << "\nLogin successful as Librarian....." << endl;

				// show librarian features
				exit = true;
			} catch(CustomException& error) {
				cout << error.getMessage() << endl;
			}
		}
			break;
		case 2:
			cout << "Logged in as Student...." << endl;
			break;
		case 9 :
			exit = true;
			break;
		default :
			cout << "Invalid option selected !!! \nPlease select a valid option....";
		}
	}

	return 0;
}