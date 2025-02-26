//Static Implementation of Stack
/*
#include <stdio.h>
#include <stdlib.h>
#define Max 4

//defining globally
int stack[Max];
int top = -1;

void push(int data){
    if(top == Max-1){
        printf("Stack Overflow\n");
        return;
    }
    top = top + 1;
    stack[top] = data;
    printf("Pushed %d into the stack\n", data);
}

void pop(){
    if(top == -1){
        printf("Stack is empty\n");
        return;
    }
    int data = stack[top];
    top = top - 1;
    printf("Popped %d from stack\n", data);
}

int peek(){
    if(top == -1){
        printf("Stack is empty.\n");
        return;
    }
    return stack[top];

}

int print(){
    while(top != -1){
        printf("%d ", stack[top]);
        top--;
    }
    printf("\n");
}

int main()
{
    push(1);
    push(3);
    push(89);
    push(0);
    push(45);
    pop();
    pop();
    printf("%d\n",peek());
    printf("%d\n",peek());
    printf("%d\n",peek());
    push(67);
    printf("%d\n",peek());
    print();

    return 0;
}
*/


//Dynamic Implementation of Stack
/*
#include<stdio.h>
#include<stdlib.h>

struct node {
    int data;
    struct node *link;
} *top = NULL;

void push(int data) {
    struct node* newNode;
    newNode = (struct node*)malloc(sizeof(struct node)); // Allocate memory using size of 'struct node'
    if (newNode == NULL) {
        printf("Stack Overflow\n");
        return;
    }
    newNode->data = data;
    newNode->link = top;  // Link the new node to the current top
    top = newNode;  // Update top to the new node
}

void display() {
    struct node *temp;
    temp = top;  // Initialize temp to point to top of stack
    if (top == NULL) {
        printf("Stack is Empty\n");
    } else {
        while (temp != NULL) {
            printf("%d ", temp->data);
            temp = temp->link;  // Move to the next node
        }
        printf("\n");
    }
}

void pop() {
    struct node *temp;
    temp = top;
    if (temp == NULL) {
        printf("Stack is Empty.\n");  // Add a newline for better formatting
    } else {
        printf("%d popped from stack\n", top->data);  // Inform which element is popped
        top = top->link;  // Move top to the next node
        free(temp);  // Free the memory of the popped node
    }
}

int main() {
    push(78);
    push(59);
    push(89);
    push(65);
    push(90);
    display();
    pop();
    pop();
    pop();
    push(78);
    display();

    return 0;
}
*/



