// #include <bits/stdc++.h>
#include <iostream>
using namespace std;

void xyz(void);

class Parent {
	private:
	string pri = "Private";
	protected:
	string pro = "Protected";
	public :
	string pub = "public";
	virtual int common() {

	}
};

class Child : protected Parent {
public :
	public :
	int common() override {
		
	}

	void specificToChild() {
		cout << pub;
		cout << pro;
	}
};

class SubChild : public Child {
	public:
	void specificToSubChild() {
		cout << pub;
		cout << pro;
	}
};

class {

} anonObj;


int main() {
	Parent* parent;
	Child child;

	parent = &child;

	cout << sizeof(anonObj) << endl;

	int x = 10;
	int* y = &x;
	int z = 20;

	*y = z;

	cout << *y << endl;

	int a = 5;
	int b = 2;

	float c = a / b;

	cout << c;

	return 0;
}