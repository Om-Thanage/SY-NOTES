/*#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};

struct node *head = NULL;

// Insertion at the beginning
void insertbeg(int element) {
    struct node *newNode = (struct node *)malloc(sizeof(struct node));
    newNode->data = element;
    if (head == NULL) {
        head = newNode;
        newNode->next = head;
    } else {
        struct node *temp = head;
        while (temp->next != head) {
            temp = temp->next;
        }
        newNode->next = head;
        temp->next = newNode;
        head = newNode;
    }
    printf("%d inserted at beginning\n", element);
}

// Insertion at the end
void insertend(int element) {
    struct node *newNode = (struct node *)malloc(sizeof(struct node));
    newNode->data = element;
    if (head == NULL) {
        head = newNode;
        newNode->next = head;
    } else {
        struct node *temp = head;
        while (temp->next != head) {
            temp = temp->next;
        }
        temp->next = newNode;
        newNode->next = head;
    }
    printf("%d inserted at end\n", element);
}

// Insertion at a specific position
void insertmid(int element, int position) {
    struct node *newNode = (struct node *)malloc(sizeof(struct node));
    newNode->data = element;

    if (position == 1 || head == NULL) {
        insertbeg(element);
        return;
    }

    struct node *temp = head;
    for (int i = 1; i < position - 1 && temp->next != head; i++) {
        temp = temp->next;
    }

    if (temp->next == head && position > 1) {
        printf("Position out of bounds, inserting at the end.\n");
        insertend(element);
        return;
    }

    newNode->next = temp->next;
    temp->next = newNode;
    printf("%d inserted at position %d\n", element, position);
}

// Traversing the circular linked list
void transverse() {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct node *temp = head;
    do {
        printf("%d -> ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("HEAD\n");
}

// Searching for an element in the circular linked list
void search(int element) {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct node *temp = head;
    int index = 1;
    do {
        if (temp->data == element) {
            printf("Element %d found at index %d\n", element, index);
            return;
        }
        temp = temp->next;
        index++;
    } while (temp != head);

    printf("Element %d not found.\n", element);
}

// Deletion at the beginning
void deletebeg() {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct node *temp = head;
    if (head->next == head) {
        free(head);
        head = NULL;
    } else {
        struct node *last = head;
        while (last->next != head) {
            last = last->next;
        }
        head = head->next;
        last->next = head;
        free(temp);
    }
    printf("Element deleted from the beginning.\n");
}

// Deletion at the end
void deleteend() {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct node *temp = head;
    if (head->next == head) {
        free(head);
        head = NULL;
    } else {
        struct node *prev = NULL;
        while (temp->next != head) {
            prev = temp;
            temp = temp->next;
        }
        prev->next = head;
        free(temp);
    }
    printf("Element deleted from the end.\n");
}

// Deletion at a specific position
void deletemid(int position) {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    if (position == 1) {
        deletebeg();
        return;
    }

    struct node *temp = head;
    struct node *prev = NULL;
    for (int i = 1; i < position && temp->next != head; i++) {
        prev = temp;
        temp = temp->next;
    }

    if (temp == head || temp->next == head && position > 1) {
        printf("Invalid position.\n");
    } else {
        prev->next = temp->next;
        free(temp);
        printf("Element deleted at position %d.\n", position);
    }
}

// Menu-driven program
int main() {
    int choice, element, position;

    while (1) {
        printf("\nCircular Linked List Menu:\n");
        printf("1. Insert at beginning\n");
        printf("2. Insert at end\n");
        printf("3. Insert at position\n");
        printf("4. Delete from beginning\n");
        printf("5. Delete from end\n");
        printf("6. Delete from position\n");
        printf("7. Traverse list\n");
        printf("8. Search element\n");
        printf("9. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter element to insert at beginning: ");
                scanf("%d", &element);
                insertbeg(element);
                break;
            case 2:
                printf("Enter element to insert at end: ");
                scanf("%d", &element);
                insertend(element);
                break;
            case 3:
                printf("Enter element to insert: ");
                scanf("%d", &element);
                printf("Enter position : ");
                scanf("%d", &position);
                insertmid(element, position);
                break;
            case 4:
                deletebeg();
                break;
            case 5:
                deleteend();
                break;
            case 6:
                printf("Enter position to delete: ");
                scanf("%d", &position);
                deletemid(position);
                break;
            case 7:
                transverse();
                break;
            case 8:
                printf("Enter element to search: ");
                scanf("%d", &element);
                search(element);
                break;
            case 9:
                printf("Exiting...\n");
                exit(0);
            default:
                printf("Invalid choice! Please try again.\n");
        }
    }

    return 0;
}
*/
