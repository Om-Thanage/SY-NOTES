/*#include<stdlib.h>
#include<stdio.h>
#define Max 5

int queue[Max];
int front = -1, rear = -1;

void enqueue(int n){
    if( rear == Max - 1){
        printf("Queue is full\n");
    }
    else if( front == -1 && rear ==-1){
        front = 0;
        rear = 0;
        queue[rear] = n;
        printf("%d entered\n", n);
    }
    else{
        rear++;
        queue[rear] = n;
        printf("%d entered\n", n);
    }
}

void display(){
    if(front == -1 && rear == -1){
        printf("The queue is empty.");
    }
    else{
        for(int i = front; i<= rear; i++){
            printf("%d ", queue[i]);
        }
    }
}

void dequeue(){
    if(front == -1 && rear == -1){
        printf("The queue is empty.");
    }
    else if(front == rear){
        printf("%d deleted\n", queue[front]);
        front = rear = -1;
    }
    else{
        printf("%d deleted\n", queue[front]);
        front++;
    }
}

int main(){
    enqueue(5);
    enqueue(10);
    enqueue(5);
    enqueue(10);
    enqueue(5);
    enqueue(10);
    dequeue();
    dequeue();
    dequeue();
    dequeue();
    dequeue();
    dequeue();
    display();
}
*/

/*
#include <stdio.h>
#include<stdlib.h>

struct node{
    int data;
    struct node *link;
};

struct node *front = NULL;
struct node *rear = NULL;

void enqueue(int n){
    struct node *newnode;
    newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = n;
    newnode->link = NULL;
    if(front == NULL && rear == NULL){
        front = rear = newnode;
    }
    else{
        rear->link = newnode;
        rear = newnode;
    }
}

void dequeue(){
    struct node *temp;
    temp = front;
    if(front == NULL && rear == NULL){
        printf("Queue is Empty");
    }
    else{
        printf("%d is deleted\n", front->data);
        front = front->link;
        free(temp);
    }

}

void display(){
    struct node *temp;
    if(front == NULL && rear == NULL){
        printf("Queue is Empty");
    }
    else{
        temp = front;
        while(temp != NULL){
            printf("%d ", temp->data);
            temp = temp->link;
        }
        printf("\n");
    }
}

int main(){
    enqueue(5);
    enqueue(50);
    enqueue(59);
    enqueue(50);
    display();
    dequeue();
    dequeue();
    display();

}*/
