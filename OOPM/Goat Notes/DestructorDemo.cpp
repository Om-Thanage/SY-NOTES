#include <iostream>
using namespace std;

class MyClass {
private:
    int* data;  // Pointer to dynamically allocated memory

public:
    // Constructor to allocate memory
    MyClass(int size) {
        cout << "Constructor: Allocating memory of size " << size << endl;
        data = new int[size];  // Allocating memory dynamically
    }

    // Destructor to free memory
    ~MyClass() {
        cout << "Destructor: Releasing allocated memory" << endl;
        delete[] data;  // Releasing the allocated memory
    }

    // Method to set data
    void setData(int index, int value) {
        data[index] = value;
    }

    // Method to print data
    void printData(int size) {
        for (int i = 0; i < size; i++) {
            cout << data[i] << " ";
        }
        cout << endl;
    }
};

int main() {
    MyClass obj(5);  // Object of MyClass created
    obj.setData(0, 10);
    obj.setData(1, 20);
    obj.setData(2, 30);
    obj.setData(3, 40);
    obj.setData(4, 50);

    obj.printData(5);  // Output the data

    // Destructor is automatically called when the object goes out of scope
    return 0;
}
