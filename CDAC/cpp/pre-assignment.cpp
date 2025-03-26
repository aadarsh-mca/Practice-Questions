#include <iostream>
#include <string>

using namespace std;

/**
 * 
 * Write a program to create student class and accept data members of it by the object and
 * display them
 * 
 */
// class Student {
// private:
// 	int rollNo;
// 	string name;

// public: 
//     Student() {
//         rollNo = -1;
//         name = "NA";
//     }
//     void getStudentData() {
//         cout << "\nEnter Roll No. : ";
//         cin >> rollNo;
//         cout << "\nEnter Name : ";
//         cin >> name;
//     }
//     void displayStudentData() {
//         cout << "\nName : " << name;
//         cout << "\nRoll No. : " << rollNo;
//     }
// };

// int main() {
//     int classSize;
//     cout << "Enter Class Size : ";
//     cin >> classSize;

//     Student *arr = new Student[classSize];

//     int i = 0;
//     while(i < classSize) {
//         arr[i].getStudentData();
//         i++;
//     }

//     i = 0;
//     while(i < classSize) {
//         arr[i].displayStudentData();
//         i++;
//     }
//
//     delete[] arr;
//     return 0;
// }


/**
 * 
 * Write a program to create Book class, with data members as follows- book_no, book_name, author,
 * edition, price, qty, bill, discount, netbill . Calculate bill and apply discount 5% on them, also calculate
 * netbill. Initialize these data members by the objects of its class
 * 
 */
// class Book {
//     private:
//     int bookNo;
//     string bookName;
//     string author;
//     int edition;
//     float price;
//     int qty;
//     float grossTotal;
//     float discount;
//     float netTotal;
    
// public:
//     static int discountPercent;

//     Book(int bookNo, string bookName, string author, int edition, float price, int qty) {
//         this->bookNo = bookNo;
//         this->bookName = bookName;
//         this->author = author;
//         this->edition = edition;
//         this->price = price;
//         this->qty = qty;
//     }

//     void calBill() {
//         this->grossTotal = (price * qty);
//         this->discount = (grossTotal * discountPercent / 100);
//         this->netTotal = (grossTotal - discount);
//     }

//     void showBill() {
//         cout << "\n==================================================";
//         cout << "\nBook No. : \t\t\t\t" << bookNo;
//         cout << "\nBook Name : \t\t\t\t" << bookName;
//         cout << "\nAuthor : \t\t\t\t" << author;
//         cout << "\nEdition : \t\t\t\t" << edition;
//         cout << "\nPrice : \t\t\t\t" << price;
//         cout << "\nQty : \t\t\t\t\t" << qty;
//         cout << "\n--------------------------------------------------";
//         cout << "\n\tGross Total : \t\t\t" << grossTotal;
//         cout << "\n\tDiscount 5 % : \t\t\t" << discount;
//         cout << "\nNet Total : \t\t\t\t" << netTotal;
//     }
// };

// int Book::discountPercent = 5;

// int main() {

//     Book bill1 = Book(123, "Book 1", "Author 1", 2012, 159.6, 7);
//     bill1.calBill();
//     bill1.showBill();

//     return 0;
// }



/**
 * 
 * 1. Create a C++ program that demonstrates the use of arrays of objects. The program should
    simulate a simple student management system
        a. Create a class Student with the following attributes:
            - name (string), rollNumber (integer), marks (integer array of size 5)
        b. Implement the following member functions in the Student class:
            - getDetails(): Asks the user to input the student's details (name, roll number, and marks)
            - displayDetails(): Displays the student's details
        c. Create an array of Student objects with a size of 10.
    2. Use a loop to ask the user to input the details of 10 students and store them in the array.
    3. Use another loop to display the details of all students in the array. 
 * 
 */
// class Student {
// private:
//     int rollNo;
//     string name;
//     int marks;
// public:
//     Student() {
//         rollNo = -1;
//         name = "-NA-";
//         marks = -1;
//     }
//     void getDetails(int idx) {
//         cout << "\nEnter the details of Student " << idx;
//         cout << "\n\tEnter Roll No. : ";
//         cin >> rollNo;
//         cout << "\tEnter Name : ";
//         cin >> name;
//         cout << "\tEnter Marks : ";
//         cin >> marks;
//     }
//     void displayDetails(int idx) {
//         cout << "\n------------------------------- ";
//         cout << "\nHere are the details of Student " << idx;
//         cout << "\n\tRoll no. : \t\t" << rollNo;
//         cout << "\n\tName : \t\t\t" << name;
//         cout << "\n\tMarks : \t\t" << marks;
//     }
// };

// int main () {
//     int size;
//     cout << "Enter the size of class : ";
//     cin >> size;

//     Student *stud = new Student[size];

//     for(int i=0; i<size; i++) {
//         stud[i].getDetails(i+1);
//     }

//     for(int i=0; i<size; i++) {
//         stud[i].displayDetails(i+1);
//     }

//     delete[] stud;
//     return 0;
// }


/**
 * 
 * 
 * 
 */