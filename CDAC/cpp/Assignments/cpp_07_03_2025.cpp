/**
 * 
 * 1.	Write a Program to Copy String Without strcpy().
 * 
 */
// #include <iostream>
// using namespace std;
//  int main() {
// 	string str1 = "Aadarsh";
// 	string str2 = "";
// 	cout << "Before Copying : " << endl;
// 	cout << "\tString 1 : " << str1 << endl;
// 	cout << "\tString 3 : " << str2 << endl;
// 	for(char ch : str1) {
// 		str2 += ch;
// 	}
// 	cout << "After Copying : " << endl;
// 	cout << "\tString 1 : " << str1 << endl;
// 	cout << "\tString 3 : " << str2 << endl;
// }







/**
 * 
 * 0
 * 01
 * 010
 * 0101
 * 01010
 * 
 */
// #include <iostream>
// using namespace std;
// int main() {
// 	int n;
// 	cout << "Enter the size of pattern : ";
// 	cin >> n;
// 	for(int i=1; i <= n; i++) {
// 		for(int j = 1; j <= i; j++) {
// 			if(j % 2 != 0) {
// 				cout << "0";
// 			} else {
// 				cout << "1";
// 			}
// 		}
// 		cout << endl;
// 	}
// 	return 0;
// } 






/**
 * 
 * Write a Program to perform multiple inheritance for class Bank_Account as Base class 
 * and Saving_Account & Current_Account as derived classes. 
 * consider suitable data members and member functions.
 * And invoke the same.
 * 
 */
// #include <iostream>
// using namespace std;

// class BankAccount {
// private:
// 	int accNo;
// 	string name;
// 	string phoneNo;
// public:
// 	BankAccount() {
// 		cout << "Enter the following details one by one : " << endl;
// 		cout << "Enter account number : ";
// 		cin >> accNo;
// 		cout << "Enter account holder name : ";
// 		cin >> name;
// 		cout << "Enter account holder phone number : ";
// 		cin >> phoneNo;
// 	}

// 	void displayPersonalInfo() {
// 		cout << "\nThe details of " << name << "'s saving account are : " << endl;
// 		cout << "Account No. : " << accNo << endl;
// 		cout << "Name : " << name << endl;
// 		cout << "Phone No : " << phoneNo << endl;
// 	}

// 	int getAccNo() {
// 		return accNo;
// 	}

// 	string getName() {
// 		return name;
// 	}

// 	string getPhoneNo() {
// 		return phoneNo;
// 	}
// };

// class SavingAccount : public BankAccount {
// private:
// 	float balance;
// public:
// 	SavingAccount() : BankAccount() {
// 		cout << "Enter Saving account balance : ";
// 		cin >> balance;
// 	}
// 	float& getBalance() {
// 		return balance;
// 	}

// 	void displaySavingInfo() {
// 		displayPersonalInfo();
// 		cout << "Saving Account Balance : " << getBalance() << endl;
// 	}
// };

// class CurrentAccount : public BankAccount {
// private:
// 	float balance;
// public:
// 	CurrentAccount() : BankAccount() {
// 		cout << "Enter Saving account balance : ";
// 		cin >> balance;
// 	}
// 	float& getBalance() {
// 		return balance;
// 	}

// 	void displayCurrentInfo() {
// 		displayPersonalInfo();
// 		cout << "Current Account Balance : " << getBalance() << endl;
// 	}
// };

// int main() {
// 	SavingAccount saving = SavingAccount();
// 	CurrentAccount current = CurrentAccount();

// 	saving.displaySavingInfo();
// 	current.displayCurrentInfo();

// 	return 0;
// }





/**
 * 
 * WAP to implement Inheritance, Dynamic polymorphism, RTTI  for given scenario.
 * 
 	  - Consider a Movie class having attributes as (id,Movie_Name,Realese_Date,ticket_amount)
     	And a member function display()-virtual function.
       
		- Inherite Movie class to Bollywood_Movie class having attributes (no.of ticktes,rating)
		- Method
 	   2.1 cal_Tick_amount(){ Tick_amount =no_of_seats *ticket_amount)
 	   2.2 display() ->display info of movie

     Invoke display() to show information of Movie and also invoke cal_Tick_amount()  using    
     downcasting.
 * 
 * 
 */
// #include <iostream>
// using namespace std;

// class Movie {
// private:
// 	int id;
// 	string movieName;
// 	string releaseDate;
// 	float ticketAmt;

// 	void getData() {
// 		cout << "\nEnter the following info one by one : " << endl;
// 		cout << "\tEnter the ID of movie : ";
// 		cin >> id;
// 		cout << "\tEnter the Name of movie : ";
// 		cin >> movieName;
// 		cout << "\tEnter the Release Data of movie : ";
// 		cin >> releaseDate;
// 		cout << "\tEnter the ticket amount of movie : ";
// 		cin >> ticketAmt;
// 	}
// public:
// 	Movie() {
// 		getData();
// 	}
// 	virtual void display() {
// 		cout << "\nMovie details are as follow : " << endl;
// 		cout << "\tID : " << id << endl;
// 		cout << "\tMovie Name : " << movieName << endl;
// 		cout << "\tRelease Date : " << releaseDate << endl;
// 		cout << "\tTicket Amount : " << ticketAmt << endl;
// 	}
// 	float getTicketAmt() {
// 		return ticketAmt;
// 	}
// };

// class BollywoodMovie : public Movie {
// private:
// 	int noOfTicket;
// 	float rating;
// 	float totalTicketAmount = 0.0;

// 	void getData() {
// 		cout << "\tEnter the No. of tickets of movie : ";
// 		cin >> noOfTicket;
// 		cout << "\tEnter the rating of movie : ";
// 		cin >> rating;
// 	}
// public:
// 	BollywoodMovie() : Movie() {
// 		getData();
// 		cal_Tick_amount();
// 	}
// 	void display() override {
// 		Movie::display();
// 		cout << "\tRating : " << rating << endl;
// 		cout << "\tTotal No. of tickets : " << noOfTicket << endl;
// 		cout << "\tTotal ticket amount : " << totalTicketAmount << endl;
// 	}
// 	void cal_Tick_amount() {
//         totalTicketAmount = noOfTicket * getTicketAmt();
//     }
// };

// int main() {
// 	int size;
// 	cout << "Enter the size of array : ";
// 	cin >> size;
// 	BollywoodMovie *arr = new BollywoodMovie[size];
// 	for(int i=0; i < size; i++) {
// 		arr[i].display();
// 	}
// 	return 0;
// }






/**
 * 
 * Given a sorted array of distinct integers and a target value, 
 * return the index if the target is found.  
 * If not, return the index where it would be if it were inserted in order.
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2(index of target elelment in array)
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * 
 */
// #include <iostream>
// using namespace std;
// #include <vector>

// int getCorrectIndex(vector<int>, int);

// int main() {
// 	// vector<int> arr = {1,3,5,6};
// 	// int target = 5;	
// 	vector<int> arr = {1,3,5,6};
// 	int target = 2;	
// 	cout << "The index of " << target << " is : " << getCorrectIndex(arr, target);	
// }

// int getCorrectIndex(vector<int> arr, int target) {
// 	int n = arr.size();
// 	if(arr[0] == target) {
// 		return 0;
// 	}
// 	if(arr[n-1] == target) {
// 		return n-1;
// 	}
// 	for(int i = 1; i < n-1; i++) {
// 		if((arr[i] == target) || (arr[i-1] < target && arr[i+1] > target)) {
// 			return i;
// 		}
// 	}
// }






/**
 * 
 * 7. 	Check whether entered two strings are anagram or not.
 * Example 1:
 * Input: str1-“nat”   str2= “tan”
 * Output: strings are anagram.
 * Input: str1=”fan”  str2=”cat”
 * Output=strings are not anagram
 * Explanation:
 * e.g. 1)The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * e.g. 2) The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

 * 
 */
// #include <iostream>
// using namespace std;
// #include <unordered_map>

// bool isAnagram(string, string);

// int main() {
// 	// string str1 = "nat";
// 	// string str2 = "tan";
// 	// string str1 = "ate";
// 	// string str2 = "eat";
// 	// string str1 = "ate";
// 	// string str2 = "tat";
// 	string str1 = "nat";
// 	string str2 = "Tan";

// 	cout << endl;
// 	if(isAnagram(str1, str2)) {
// 		cout << str1 << " and " << str2 << " are Anagram" << endl;
// 	} else {
// 		cout << str1 << " and " << str2 << " are NOT Anagram" << endl;
// 	}
// }

// bool isAnagram(string str1, string str2) {
// 	unordered_map<char, int> freqMap;
// 	for(char ch : str1) {
// 		freqMap[ch-'a']++;
// 	}
// 	for(char ch : str2) {
// 		freqMap[ch-'a']--;
// 	}
// 	for(auto ele : freqMap) {
// 		if(ele.second != 0) {
// 			return false;
// 		}
// 	}
// 	return true;
// }





/**
 * 
 * Using a function template write a program 
 * to find out minimum value contained in an array.
 * 
 */
// #include <iostream>
// using namespace std;

// template <typename T>
// T getMinimum(T arr[], int size);

// int main() {
// 	int intArr[] = {10, 3, 6, 5, 1, 6, 9, 28};
// 	float floatArr[] = {10.2, 3.4, 6.2, 5.7, 18.3, 6.5, 9.8, 28.1};
// 	int intArrSize = sizeof(intArr) / sizeof(intArr[0]);
// 	int floatArrSize = sizeof(floatArr) / sizeof(floatArr[0]);
// 	cout << "\nMinimum value of int array is : " << getMinimum(intArr, intArrSize) << endl;
// 	cout << "Minimum value of float array is : " << getMinimum(floatArr, floatArrSize) << endl;
// 	return 0;
// }

// template <typename T>
// T getMinimum(T arr[], int size) {
// 	T min = arr[0];
// 	for(int i=0; i<size; i++) {
// 		if(arr[i] < min) {
// 			min = arr[i];
// 		}
// 	}
// 	return min;
// }






/**
 * 
 * Palindrome
 * 
 */
// #include <iostream>
// using namespace std;

// bool isPalindrome(string);
// bool isAlphaNumeric(char);

// int main() {
//     // string str = "racecar";
//     // string str = "A man, a plan, a canal: Panama";
//     string str = "0patpap0";
// 	cout << endl;
//     if(isPalindrome(str)) {
//         cout << str << " is a Palindrome" << endl;
//     } else {
//         cout << str << " is NOT a Palindrome" << endl;
//     }
//     return 0;
// }


// bool isPalindrome(string s) {
//     int left = 0;
//     int right = s.size() - 1;
//     while (left < right) {
//         char leftCh = tolower(s[left]);
//         char rightCh = tolower(s[right]);
//         if (isAlphaNumeric(leftCh) &&
//             isAlphaNumeric(rightCh)) {
//             if (leftCh != rightCh) {
//                 return false;
//             }
//             left++;
//             right--;
//         } else if (isAlphaNumeric(leftCh) == false) {
//             left++;
//         } else if (isAlphaNumeric(rightCh) == false) {
//             right--;
//         }
//     }
//     return true;
// }


// bool isAlphaNumeric(char ch) {
//     if (ch >= 97 && ch <= 122 ||
//         ch >= 48 && ch <= 57) {
//         return true;
//     }
//     return false;
// }






/**
 * 
 * Write a program to find sum of all even and odd numbers between 1 to n
 * 
 */
// #include <iostream>
// using namespace std;

// int main() {
// 	cout << "Enter a number : ";
// 	int n;
// 	cin >> n;
// 	int oddSum = 0;
// 	int evenSum = 0;
// 	for(int i=1; i <= n; i++) {
// 		if(i % 2 == 0) {
// 			evenSum += i;
// 		} else {
// 			oddSum += i;
// 		}
// 	}
// 	cout << "Sum of all even number from 1 to " << n << " is : " << evenSum << endl;
// 	cout << "Sum of all odd number from 1 to " << n << " is : " << oddSum << endl;
// 	return 0;
// }





/**
 * 
 * 
 * 
 */
#include <iostream>
using namespace std;

class Parent {
public:
	Parent() {
		cout << "\nParent Constructor" << endl;
	}

	virtual void display() {
		cout << "\nFrom Parent diplay () ...." << endl;
	}
};

class Child : public Parent {
public:
	Child() {
		cout << "Child Constructor" << endl;
	}
	void display() override {
		cout << "From Child diplay () ...." << endl;
	}
	void onlyFromChild() {
		cout << "\n\tOnly from child () ....." << endl;
	}
};
 
int main() {
	// Parent parent = Parent();
	// Child child = Child();

	// parent.display();
	// child.display();

	cout << endl << endl;
	Parent* over = new Child();
	over->display();

	dynamic_cast<Child*>(over)->onlyFromChild();

	// delete parent;
	// delete child;
	delete over;
	return 0;
}