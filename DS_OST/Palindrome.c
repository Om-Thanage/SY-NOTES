/*
#include<stdio.h>
#include<stdlib.h>

struct node{
    int data;
    struct node *link;
};

struct node *top = NULL;

void push(int data){
    struct node* newnode;
    newnode = (struct node *)malloc(sizeof(struct node));
    if(newnode == NULL){
        printf("Stack Overflow\n");
        return;
    }
    newnode->data = data;
    newnode->link = top;
    top = newnode;
}

void pop(){
    if(top == NULL){
        printf("Stack Underflow\n");
        return;
    }
    struct node *temp;
    temp = top;
    top = top->link;
    free(temp);
}

void ispalindrome(int n){
    int original = n;
    while(n > 0){
        push(n % 10);
        n = n / 10;
    }

    int reversed = 0;
    int multiplier = 1;

    while(top != NULL){
        reversed += (top->data * multiplier);
        multiplier *= 10;
        pop();
    }

    if(reversed == original){
        printf("%d is a palindrome.\n", original);
    }
    else{
        printf("%d is not a palindrome.\n", original);
    }
}

int main(){
    int n;
    printf("Enter the number: ");
    scanf("%d", &n);
    ispalindrome(n);
    return 0;
}
*/
