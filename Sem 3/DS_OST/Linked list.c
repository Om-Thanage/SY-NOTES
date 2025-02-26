/*#include<stdio.h>
#include<stdlib.h>

struct node {
    int data;
    struct node *Link;
};

void print(struct node *head) {
    if (head == NULL) {
        printf("Linked List is Empty\n");
        return;
    }
    struct node *ptr = head;
    while (ptr != NULL) {
        printf("%d ", ptr->data);
        ptr = ptr->Link;
    }
    printf("\n");
}

void add_beg(struct node **head, int d) {
    struct node *ptr = malloc(sizeof(struct node));
    ptr->data = d;
    ptr->Link = *head;
    *head = ptr;
}

void add_end(struct node *head, int data) {
    struct node *ptr = head;
    struct node *temp = malloc(sizeof(struct node));
    temp->data = data;
    temp->Link = NULL;

    while (ptr->Link != NULL) {
        ptr = ptr->Link;
    }
    ptr->Link = temp;
}

void add_at_pos(struct node *head, int data, int pos) {
    struct node *ptr = head;
    struct node *temp = malloc(sizeof(struct node));
    temp->data = data;
    temp->Link = NULL;

    pos--;
    while (pos > 1) {
        ptr = ptr->Link;
        pos--;
    }
    temp->Link = ptr->Link;
    ptr->Link = temp;
}

struct node* del_beg(struct node *head) {
    if (head == NULL) {
        printf("List is already empty\n");
        return NULL;
    } else {
        struct node *temp = head;
        head = head->Link;
        free(temp);
        return head;
    }
}

//Using two pointer
void del_end(struct node *head) {
    if (head == NULL) {
        printf("List is already empty.\n");
        return NULL;
    } else if (head->Link == NULL) {
        free(head);
        return NULL;
    } else {
        struct node *temp = head;
        struct node *temp2 = NULL;
        while (temp->Link != NULL) {
            temp2 = temp;
            temp = temp->Link;
        }
        temp2->Link = NULL;
        free(temp);
    }
}

//Using One pointer
void del_last(struct node *head){
    if(head == NULL){
        printf("List is already empty");
    }
    else if(head->Link == NULL){
        free(head);
        head = NULL;
    }
    else{
        struct node *temp = head;
        while(temp->Link->Link != NULL){
            temp = temp->Link;
        }
        free(temp->Link);
        temp->Link = NULL;
    }
}

void del_at_pos(struct node **head, int pos){
    struct node *current = *head;
    struct node *previous = *head;

    if(*head == NULL){
        printf("List is already empty!");
    }
    else if(pos == 1){
        *head = current->Link;
        free(current);
        current = NULL;
    }
    else{
        while(pos != 1){
            previous = current;
            current = current->Link;
            pos--;
        }
        previous->Link = current->Link;
        free(current);
        current = NULL;
    }
}

struct node* del_list(struct node *head){
    struct node *temp = head;
    while(temp != NULL)
    {
        temp = temp->Link;
        free(temp);
        head = temp;
    }
    return head;
};

int main() {
    struct node *head = malloc(sizeof(struct node));
    head->data = 45;
    head->Link = NULL;

    // For second node
    struct node *current = malloc(sizeof(struct node));
    current->data = 98;
    current->Link = NULL;
    head->Link = current;

    // For third node
    current = malloc(sizeof(struct node));
    current->data = 80;
    current->Link = NULL;
    head->Link->Link = current;

    // Print initial list
    print(head);

    // Adding a node at the end
    add_end(head, 45);
    print(head);

    // Adding a node at the beginning
    add_beg(&head, 50);
    print(head);

    // Adding a node at a specific position
    add_at_pos(head, 2, 2);
    print(head);

    // Deleting the first node
    head = del_beg(head);
    print(head);

    // Deleting the last node
    del_end(head);
    print(head);

    // Deleting the last node using one pointer
    del_last(head);
    print(head);

    del_at_pos(&head, 2);
    print(head);

    head = del_list(head);
    print(head);



    return 0;
}*/
