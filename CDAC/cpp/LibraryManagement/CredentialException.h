#include <iostream>
#include "CustomException.h"

using namespace std;

class CredentialException : public CustomException {
public:
	CredentialException(string msg): CustomException(msg) {}
};