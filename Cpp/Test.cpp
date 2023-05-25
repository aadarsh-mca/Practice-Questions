#include <iostream>
using namespace std;

class Test {
    public :
        int a;

    Test(int val) {
        a = val;
    }
    
    public :
        void printVal(int a) {
            cout<<"Local variable = "<<a<<endl;
            cout<<"Global variable = "<<Test::a<<endl;
        }
};


int main() {
    Test obj = Test(10);
    obj.printVal(0);

    // if(obj.a == 10) {
    //     cout<<"True"<<endl;
    // }

    return 0;
}