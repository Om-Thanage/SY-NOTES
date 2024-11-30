/*
#include<stdio.h>
#include<stdlib.h>
#define MAX 5

int c_queue[MAX];
int front = -1;
int rear = -1;

void enqueue(int n){
    if(front == -1 && rear == -1){
        front = rear = 0;
        c_queue[rear] = n;
    }
    else if( ((rear + 1) % MAX) == front){ //Changed condition
        printf("Queue is full\n");
    }
    else{
        rear = ((rear + 1) % MAX);
        c_queue[rear] = n;
    }
}


void dequeue(){
    if(front == -1 && rear == -1){
        printf("The queue is empty.\n");
    }
    else if( front == rear){
        printf("%d is deleted\n", c_queue[front]);
        front = rear = -1;
    }
    else{
        printf("%d is deleted\n", c_queue[front]);
        front = (front+1)%MAX;
    }

}

void display(){
    int i = front;
    if(front == -1 && rear == -1){
        printf("The queue is empty.\n");
    }
    else{
        while(i != rear + 1){
            printf("%d ", c_queue[i]);
            i = (i+1)%MAX;
        }
    }
}



int main(){
    enqueue(50);
    enqueue(78);
    enqueue(89);
    enqueue(50);
    enqueue(78);
    dequeue();
    dequeue();
    dequeue();
    enqueue(45);
    display();
}

*/

/*
#include<stdio.h>
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
    newnode-> data = n;
    newnode-> link = NULL;
    if(front == NULL && rear == NULL){
        front = rear =  newnode;
        rear-> link = front;
    }
    else{
        rear ->link = newnode;
        rear = newnode;
        rear->link = front;
    }
}

void dequeue(){
    struct node *temp;
    temp = front;
    if( front == NULL && rear == NULL){
        printf("Queue is empty.\n");
    }
    else if( front ==  rear){
        front = rear = NULL;
        free(temp);
    }
    else{
        front = front->link;
        rear->link = front;
        free(temp);
    }

}

void display(){
    struct node *temp;
    temp = front;
    if(front == NULL && rear == NULL){
        printf("The queue is empty.\n");
    }
    else{
        while(temp ->link != front){
            printf("%d ", temp->data);
            temp = temp->link;
        }
        printf("%d ", temp ->data);
        printf("\n");
    }
}
int main(){
    enqueue(89);
    enqueue(45);
    enqueue(23);
    enqueue(65);
    display();
    dequeue();
    display();
}
*/
