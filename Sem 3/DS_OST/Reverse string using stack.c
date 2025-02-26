/*
#include<stdio.h>
#include<string.h>
#define MAX 100

// Global variables for the stack
char s1[MAX]; // Stack to reverse string
int top1 = -1; // Top pointer for stack s1

// Function to push elements onto the stack
void push(char stack[], int ch) {
    if (top1 == MAX - 1) {
        printf("Stack overflow\n");
        return;
    }
    top1++;
    stack[top1] = ch;
}

// Function to pop elements from the stack
char pop(char stack[]) {
    if (top1 == -1) {
        printf("Stack underflow\n");
        return '\0'; // Returning null character if stack is empty
    }
    else{
        return stack[top1--];
    }
}

// Function to reverse a string using a stack and check for palindrome
void reverse_string(char str[]) {
    int n = strlen(str); // Get the length of the string
    int count = 0; // Variable to count number of elements
    char reversed[MAX]; // Array to store the reversed string

    // Push all characters of the string onto the stack
    for (int i = 0; i < n; i++) {
        push(s1, str[i]);
        count++; // Count the characters
    }

    printf("Reversed string: ");
    // Pop characters from the stack to reverse the string
    for (int i = 0; i < n; i++) {
        reversed[i] = pop(s1);
        printf("%c", reversed[i]);
    }
    reversed[n] = '\0'; // Null-terminate the reversed string
    printf("\n");

    printf("Number of elements in the string: %d\n", count);

    // Check if the original string is equal to the reversed string (palindrome check)
    if (strcmp(str, reversed) == 0) {
        printf("The string is a palindrome.\n");
    } else {
        printf("The string is not a palindrome.\n");
    }
}

int main() {
    char in_s1[MAX];

    printf("Enter the first string: ");
    scanf("%s", in_s1);

    reverse_string(in_s1); // Reverse the input string and check for palindrome

    return 0;
}
*/
