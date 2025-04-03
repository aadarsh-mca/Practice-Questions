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

	string* setUsername() {
		return &username;
	}

	const string getPassword() {
		return password;
	}

	string* setPassword() {
		return &password;
	}

};