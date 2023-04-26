    // Prefix : / + a b + c d
#include <iostream>

using namespace std;
char expression[] = "46+32+/)";
int expLen = sizeof(expression);
char stack[100];

int main() {
    // Postfix : d c + b a + /
    // 4 6 + 3 2 + /
    // (4 + 6) / (3 + 2)
    // 10 / 5 = " 2 "

    for(int i=0; i <= expLen; i++) {
        cout<<expression[i]<<endl;
    }

    return 0;
}

void push() {
    stack[]
}