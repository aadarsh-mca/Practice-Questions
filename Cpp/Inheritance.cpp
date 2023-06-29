#include <iostream>
using namespace std;

class Base_1 {
    public :
        string base = "Base_1";

        Base_1() {
            cout << "Base_1 Constructor" << endl;
        }

        virtual void function() {
            cout << "Base_1 Function" << endl;
        }
};

class Base_2 {
    public :
        string base = "Base_2";

        Base_2() {
            cout << "Base_2 Constructor" << endl;
        }
};

class Child_1 : public Base_1 {
    public :
        Child_1() {
            cout << "Child_1 Constructor" << endl;
        }

        void function() {
            cout << "Child_1 Function" << endl;
        }
};

class Child_2 : Base_1 {
    public :
        Child_2() {
            cout << "Child_2 Constructor" << endl;
        }
};

class Child_3 : Base_1, Base_2 {
    public :
        Child_3() {
            cout << "Child_3 Constructor" << endl;
        }
};

class SubChild_1 : Child_1 {
    public :
        SubChild_1() {
            cout << "SubChild_1 Constructor" << endl;
        }
};

int main() {
    // Base_1 base_1;
    // base_1.function();
    // Base_2 base_2;
    // Child_1 child_1;
    // child_1.function();

    // cout << "\n" << endl;
    Base_1 *bp = new Child_1;
    bp->function();

    // Child_2 child_2;
    // Child_3 child_3;
    // cout << child_3.base << endl;
    // SubChild_1 SubChild_1;


    return 0;
}











// // C++ program to demonstrate the working
// // of protected inheritance
// #include <iostream>
// using namespace std;

// class Base {
// private:
// 	int pvt = 1;

// protected:
// 	int prot = 2;

// public:
// 	int pub = 3;

// 	// function to access private member
// 	int getPVT() { return pvt; }
// };

// class ProtectedDerived : protected Base {
// public:
//     int getPvt() { return getPVT(); }

// 	// function to access protected member from Base
// 	int getProt() { return prot; }

// 	// function to access public member from Base
// 	int getPub() { return pub; }
// };

// int main()
// {
// 	ProtectedDerived object1;
// 	cout << "Private cannot be accessed." << object1.getPVT() << endl;
// 	cout << "Protected = " << object1.getProt() << endl;
// 	cout << "Public = " << object1.getPub() << endl;
// 	return 0;
// }
