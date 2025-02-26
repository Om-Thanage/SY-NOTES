/*
#include<stdio.h>
#include<stdlib.h>

struct node{
    int data;
    struct node *left, *right;
};

struct node* create(){
    struct node *newnode = (struct node*)(malloc(sizeof(struct node)));
    printf("Enter data (-1 for no node)");
    int num;
    scanf("%d",&num);
    if(num == -1){
        return 0;
    }
    newnode->data = num;
    printf("Enter the left child");
    newnode->left = create();
    printf("Enter the right child");
    newnode->right = create();
    return newnode;
};


void main(){
    struct node* root = NULL;
    root = create();
}
*/
