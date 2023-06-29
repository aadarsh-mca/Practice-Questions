#include <iostream>
using namespace std;

template <T t>;

class ExcepHand {
    public : 
        void fun() {
            cout << "Code starts" << endl;

            try {
                int a = 2 / 0;
            } catch(std::exception& e) {
                cout << "Exception caught" << endl;
            }

            cout << "Code ends" << endl;

/**
            try {
                // code
            } catch(const std::exception& e) {
                std::cerr << e.what() << '\n';
            }
**/
            

        }
};

int main() {
    ExcepHand obj;
    obj.fun();

    return 0;
}