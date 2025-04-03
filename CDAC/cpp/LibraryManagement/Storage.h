#include "Book.h"
#include "LoginCredential.h"
#include <fstream>
using namespace std;

#define STUDENT_DATA_FILE "File_StudentData.dat"
#define CREDENTIAL_DATA_FILE "File_Credential.dat"

class Storage {
private:
	static Storage* instance;
	Storage() { }

public:
	static void close(fstream &file) {
		if(file.is_open()) {
			file.close();
		}
	}
	
	static fstream openCredentialFileForReadOnly() {
		fstream currFile;
		currFile.open(CREDENTIAL_DATA_FILE, ios::in);
		return currFile;
	}

	static fstream openCredentialFileForWriteOnly() {
		fstream currFile;
		currFile.open(CREDENTIAL_DATA_FILE, ios::out);
		return currFile;
	}

	static LoginCredential getLoginCredential() {
		fstream currFile = openCredentialFileForReadOnly();

		string username,password;
		currFile >> username >> password;

		close(currFile);

		return LoginCredential(username,password);
	}

	static void updateLoginCredential(string username, string password) {
		fstream currFile = openCredentialFileForWriteOnly();

		LoginCredential loginCred(username, password);
		//currFile.write((char *)&loginCred,sizeof(LoginCredential)); // error

		string cred = username + " " + password;
		currFile.write((char *)cred.data(),cred.size());

		close(currFile);
	}

};
