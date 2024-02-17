// #include <bits/stdc++.h>
#include <iostream>
using namespace std;

class Parent {

};

class Child : public Parent {

};

class A {

};

int main() {

    class A {

    }

    A a;
    
    return 0;
}



// class Base {
//     private :
//         int private_var;
//     public :
//         int public_var;

//         Base(int a, int b) {
//             private_var = a;
//             public_var = b;
//         }

//         void baseFun() {
//             cout << "Base Function : " << private_var + public_var << endl;
//         }
// };

// class Child : Base {
//     public :
//         void childFun() {
//             cout << "Child Function : " << public_var << endl;
//         }
// };

// int main() {
//     Base base(10, 20);
//     base.baseFun();

//     Child child;
//     child.childFun();

//     return 0;
// }






// class Test {
//     public :
//         void fun(int a) const;
// };

// void Test::fun(int a) const {
//     cout << a << endl;
//     a++;
//     cout << a << endl;
// }

// void foo() {
//     const int a = 10;
// }

// int main() {
//     Test test;
//     test.fun(10);
// }






// class Test {
//     public :
//         inline void inlineFunction();
//         inline void normalFunction();

//         // inline void inlineFunction() {
//         //     cout << "Inline function called." << endl;
//         // }

//         // void normalFunction() {
//         //     cout << "Normal function called." << endl;
//         // }
// };

// inline void Test::inlineFunction() {
//     cout << "Inline function called." << endl;
// }

// void Test::normalFunction() {
//     cout << "Normal function called." << endl;
// }

// int main() {
//     Test test;
//     test.inlineFunction();
//     test.normalFunction();

//     Test test1;
//     Test test2;
//     Test test3;
//     Test test4;

//     int arr[] = {1,2,3,4};
//     Test objArr[] = {test1, test2, test3, test4};

//     int len = sizeof(arr) / sizeof(arr[0]);

//     for(int i=0; i<len; i++) {
//         cout << arr[i] << endl;
//         objArr[i].inlineFunction();
//         objArr[i].normalFunction();
//     }

//     return 0;
// }