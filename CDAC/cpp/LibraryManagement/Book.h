#include <iostream>
using namespace std;

class Book {
private:
	string name;
	string category;
	bool isIssuedByAnyone;
	string issuedBy;

public:
	Book() {
		name = "-NA-";
		category = "-NA-";
		isIssuedByAnyone = false;
		issuedBy = "-NA-";
	}

	Book(string name, string category, bool isIssued, string issuedBy) {
		this->name = name;
		this->category = category;
		this->isIssuedByAnyone = isIssued;
		this->issuedBy = issuedBy;
	}

	string getName() {
		return name;
	}

	string getCategory() {
		return category;
	}

	bool isIssued() {
		return isIssuedByAnyone;
	}

	string getIssuedBy() {
		return issuedBy;
	}
};