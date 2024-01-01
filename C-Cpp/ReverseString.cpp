#include <iostream>
using namespace std;

class _className_ {


};

int main() {
    string str = "Welcome";
    string result = "";

    int len = str.length();

    for(int i=len-1; i>=0; i--) {
        result = result + str[i];
    }

    cout << result << endl;

    return 0;
}