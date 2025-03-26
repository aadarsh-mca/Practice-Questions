//#include "SavingAccount.h"
////#include "CurrentAccount.h"
//
//int main() {
//	//SavingAccount saving = SavingAccount();
//	////CurrentAccount current = CurrentAccount();
//
//	//saving.displaySavingInfo();
//	////current.displayInfo();
//
//	string str = "Aadarsh";
//
//	return 0;
//}

#include <iostream>
using namespace std;
#include <vector>

int main() {
	vector<int> arr = {1,2,3,4,5,6,7,8,9,0};
	cout << arr.size() << endl;
	//cout << arr[9] << endl;
	//cout << arr.at(10) << endl;

	arr.erase(find(arr.begin(), arr.end(), 7));

	arr.reserve(arr.size());

	for(int num : arr) {
		cout << num << " ";
	}

	return 0;
}