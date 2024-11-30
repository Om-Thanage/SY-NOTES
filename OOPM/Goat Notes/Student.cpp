#include <iostream>
using namespace std;

class Student {
private:
    string name;

public:
    // Constructor
    Student(string studentName) {
        name = studentName;
        cout << "Constructor: object " << name << " created." << endl;
    }

    // Destructor
    ~Student() {
        cout << "Destructor: object " << name << " destroyed." << endl;
    }

    // Method to display student name
    void display() {
        cout << "Student Name: " << name << endl;
    }
};

int main() {
    // Creating a Student object
    Student student1("Alice");
    student1.display();

    // Destructor will be automatically called at the end of the scope
    return 0;
}

