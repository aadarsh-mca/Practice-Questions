#include <iostream>
using namespace std;

class MainClass;

class Class2 {
    public :
        void display(MainClass obj);
};

class MainClass {
    private:
        int private_variable;

    protected:
        int protected_variable;

    public:
        MainClass() {
            private_variable = 10;
            protected_variable = 99;
        }

    friend void fun(MainClass obj);
    friend void Class2::display(MainClass obj);
    friend class FriendClass;
};

void fun(MainClass obj) {
    cout << "Normal function :" << endl;
    cout << "\tProtected : " << obj.protected_variable << endl;
}

void Class2::display(MainClass obj) {
    cout << "Class 2 :" << endl;
    cout << "\tPrivate : " << obj.private_variable << endl;
}

class FriendClass {
    MainClass obj;
    
    public :
        FriendClass() {
            cout << "Friend Class : " << endl;
            cout << "\tPrivate : " << obj.private_variable << endl;
            cout << "\tProtected : " << obj.protected_variable << endl;
        }
};

int main() {
    MainClass mainClass;
    
    fun(mainClass);

    Class2 class2;
    class2.display(mainClass);

    FriendClass obj;

	return 0;
}
