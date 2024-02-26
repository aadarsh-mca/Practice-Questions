#include <stdio.h>
#include<string.h>
// #include <unistd.h>

int func(int x) {
    return 6 ^ 3;
}

int main() {
    int i = 1;
    do {
        i++;
    } while (i--);
    
    printf("%d", i);

    return 0;
}
