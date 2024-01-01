#include <iostream>
#include <cmath>
using namespace std;

int countZero(int L, int K) {
    if (K == 0) {
        return L;
    }
    if (K == L) {
        return 0;
    }
    
    if (K == 1) {
        return (int)L/2;
    }
    return (int) ceil((double)(L-K) / (double)K);
}

int main() {
    int L, K;
    cin >> L >> K;
    cout << countZero(L, K) << endl;
    return 0;
}