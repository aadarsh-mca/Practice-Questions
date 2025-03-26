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
	//static Storage& getInstance() {
	//	if(instance == nullptr) {
	//		instance = new Storage(); // The new Storage(); allocation is never freed, which leads to a memory leak.
	//	}
	//	return *instance;
	//}

	static void close(fstream &file) {
		if(file.is_open()) {
			file.close();
		}
	}

	/*

		Credential File Handling

	*/
	
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

		//LoginCredential loginCred;
		//currFile.read((char *)&loginCred,sizeof(LoginCredential)); // error
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

	/*

		Book File Handling
	
	*/
	static fstream openBookFileForWriteOnly() {
		fstream currFile;
		currFile.open(STUDENT_DATA_FILE, ios::out);
		return currFile;
	}

	static void writeAllBookData(Book *allBooks) {
		fstream currFile = openBookFileForWriteOnly();

		currFile.write((char *)allBooks,sizeof(Book));

		close(currFile);
	}

};

//// Initialize the static member variable
//Storage* Storage::instance = nullptr;