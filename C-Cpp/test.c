#include <stdio.h>
#include<string.h>
// #include <unistd.h>

int *testhack() {
    static int val = 5;
    return &val;
}

int main() {
    pid_t var1;
}
