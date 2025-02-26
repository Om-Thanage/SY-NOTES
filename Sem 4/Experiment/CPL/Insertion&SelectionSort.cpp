#include <bits/stdc++.h>
#include <chrono>
using namespace std;
using namespace std::chrono;

void insertion_sort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

// Best case: sorted array O(n)
// Worst case: reverse sorted array O(n^2)
void selection_sort(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[minIdx] > arr[j]) {
                minIdx = j;
            }
        }
        swap(arr[i], arr[minIdx]);
    }
}

int main() {
    int arr1[10000];
    int arr2[10000];
    int arr3[10000];

    //Sorted array
    for (int i = 0; i < 10000; i++) {
        arr1[i] = i + 1;
    }
    int n = sizeof(arr1) / sizeof(arr1[0]);

    //Reverse sorted array
    // for (int i = 100000; i >= 1; i--) {
    //     arr2[i] = i;
    // }
    // int n = sizeof(arr2) / sizeof(arr2[0]);

    //Random Array
    // for (int i = 0; i < 10000; i++) {
    //     arr3[i] = rand();
    // }
    // int n = sizeof(arr3) / sizeof(arr3[0]);

    auto start = high_resolution_clock::now();

    insertion_sort(arr1, n);

    auto stop = high_resolution_clock::now();

    auto duration = duration_cast<microseconds>(stop - start);
    cout << "\nTime taken by insertion_sort: " << duration.count() << " microseconds" << endl;


    return 0;
}
