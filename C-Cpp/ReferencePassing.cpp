#include <iostream>
using namespace std;

class Test1 { 
	public :
		int a;
};

void fun1(Test1 obj) {
	obj.a = 20;
}

void fun2(Test1& obj) {
	obj.a = 30;
}

Test1 ret1(Test1 obj) {
	return obj;
}

Test1& ret2(Test1& obj) {
	return obj;
}

int main() {
	Test1 obj;

	obj.a = 10;
	cout << "Value of a : " << obj.a << endl;

	fun1(obj);
	cout << "Call by value (a) : " << obj.a << endl; 

	fun2(obj);
	cout << "Call by refernce (a) : " << obj.a << endl; 

	cout << "Return by value (a) : " << ret1(obj).a << endl;

	int b = obj.a;
	int& c = obj.a;
	ret2(obj).a = 100;
	cout << "Return by reference (a) : " << obj.a << endl;
	cout << "Return by reference (b) : " << b << endl;
	cout << "Return by reference (c) : " << c << endl;

	return 0;
}