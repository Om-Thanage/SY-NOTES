/*
#include<stdio.h>
#include<stdlib.h>

// Define the structure for a stack node
struct node {
    char letter;
    struct node *link;
} *top = NULL;

// Function to push an element onto the stack
void push(char letter) {
    struct node* newNode;
    newNode = malloc(sizeof(struct node)); // Allocate memory for the new node
    if (newNode == NULL) {
        printf("Stack Overflow\n");
        return;
    }
    newNode->letter = letter;
    newNode->link = top;  // Link the new node to the current top
    top = newNode;  // Update top to the new node
}

// Function to pop an element from the stack
char pop() {
    struct node *temp;
    char poppedChar;

    temp = top;  // Point to the current top
    if (temp == NULL) {
        return '\0';  // Return null if stack is empty
    } else {
        poppedChar = temp->letter;  // Get the letter at top
        top = top->link;  // Move top to the next node
        free(temp);  // Free the memory of the popped node
        return poppedChar;  // Return the popped character
    }
}

// Function to check if a pair of parentheses is matching
int isMatchingPair(char open, char close) {
    if (open == '(' && close == ')') return 1;
    if (open == '{' && close == '}') return 1;
    if (open == '[' && close == ']') return 1;
    return 0;
}

// Function to check if the parentheses in an expression are balanced
int checkBalancedParentheses(char expression[]) {
    for (int i = 0; expression[i] != '\0'; i++) {
        if (expression[i] == '(' || expression[i] == '{' || expression[i] == '[') {
            push(expression[i]);  // Push opening parentheses onto the stack
        } else if (expression[i] == ')' || expression[i] == '}' || expression[i] == ']') {
            // Pop and check if the popped character is a matching pair
            char poppedChar = pop();
            if (poppedChar == '\0' || !isMatchingPair(poppedChar, expression[i])) {
                return 0;  // Unbalanced if no matching pair found
            }
        }
    }
    // At the end, stack should be empty if balanced
    return (top == NULL);
}

int main() {
    char expression[100];

    printf("Enter the expression: ");
    scanf("%s", expression);  // Take input expression

    if (checkBalancedParentheses(expression)) {
        printf("Balanced Parentheses\n");
    } else {
        printf("Unbalanced Parentheses\n");
    }

    return 0;
}
*/
