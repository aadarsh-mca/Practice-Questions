#include <iostream>
using namespace std;

class PrintInfo {
public :
	static void printLoginOption() {
		cout << "\n\tPress '1' to continue as Librarian" << endl; 
		cout << "\tPress '2' to continue as Student" << endl; 
		cout << "\n\tPress '9' to Exit." << endl;
	}
};