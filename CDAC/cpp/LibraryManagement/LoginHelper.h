#include "CustomException.h"
#include "Storage.h"
#include <iostream>
using namespace std;

class LoginHelper {
private:
	static bool login(const string& username, const string& password) {
		LoginCredential loginCred = Storage::getLoginCredential();

		if(username == loginCred.getUsername() && password == loginCred.getPassword()) {
			return true;
		}
		return false;
	}

public:
	static bool startLoginProcess() {
		string username,password;

		cout << "\nTo login as Librarian, you need to enter username and password" << endl;
		cout << "Enter username : ";
		cin >> username;
		cout << "Enter password : ";
		cin >> password;

		if(login(username,password)) {
			return true;
		} else {
			throw CustomException("\nLogin failed... Invalid Librarian Credential !!! \nPlease enter the correct username and password.");
			return false;
		}
	}
};