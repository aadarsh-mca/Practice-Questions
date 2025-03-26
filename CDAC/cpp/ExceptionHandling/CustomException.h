#include <iostream>
using namespace std;

class CustomException :exception {
private:
	string msg;
public:
	CustomException(string msg) {
		this->msg = msg;
	}

	string getMessage() {
		return msg;
	}
};