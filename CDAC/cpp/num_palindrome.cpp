#include <iostream>
using namespace std;

int revNum(int);

int main() {
    int num;
    cout << "Enter a number to check plaindrom: ";
    cin >> num;

    int rev = revNum(num);
    (num == rev) ? cout << "Is Palindrome" : cout << "Not a Palindrome";

    return 0;
}

int revNum(int num) {
    int rev = 0;
    int temp = num;
    while(num > 0) {
        int digit = num % 10;
        rev = (rev * 10) + digit;
        num /= 10;
    }
    return rev;
}