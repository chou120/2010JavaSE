#include<stdio.h>

int *getIntArr() {
    int arr[5] = {1, 2, 3, 4, 5};
    return arr;
}

int *getIntArr2() {
    int *arr = malloc(sizeof(int) * 5);
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 3;
    arr[3] = 4;
    arr[4] = 5;
    return arr;
}

int main() {

    int a[5];
    printf("%d\n", sizeof(a) / sizeof(int));
    //int *arr = getIntArr();
    int *arr = getIntArr2();
    printf("%d\n", sizeof(arr) / sizeof(int));

    for (int i = 0; i < 5; i++) {
        printf("%d\n", arr[i]);
    }


}
