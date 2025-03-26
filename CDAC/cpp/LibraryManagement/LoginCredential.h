#include <iostream>
using namespace std;

class LoginCredential {
private:
	string username;
	string password;

public:
	LoginCredential() {
		username = "-NA-";
		password = "-NA-";
	}
	LoginCredential(string username, string password) {
		this->username = username;
		this->password = password;
	}

	const string getUsername() {
		return username;
	}

	//const void setUsername(string username) {
	//	this->username = username;
	//}
	string* setUsername() {
		return &username;
	}

	const string getPassword() {
		return password;
	}

	//const void setPassword(string password) {
	//	this->password = password;
	//}
	string* setPassword() {
		return &password;
	}

};