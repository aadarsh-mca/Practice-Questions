#include <iostream>
using namespace std;

class Book {
private:

public:
	int id;
	string title;
	string author;
	bool isIssuedByAnyone;
	string issuedBy;

	Book() {
		title = "-NA-";
		author = "-NA-";
		isIssuedByAnyone = false;
		issuedBy = "-NA-";
	}
};