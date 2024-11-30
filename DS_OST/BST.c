#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *left;
    struct node *right;
};

struct node *root = NULL; // Initialize root

void insert(int item);
void search(int key);

void main() {
    int choice, item, key;

    do {
        printf("\nEnter the item which you want to insert?\n");
        scanf("%d", &item);
        insert(item);
        printf("\nPress 0 to insert more?\n");
        scanf("%d", &choice);
    } while (choice == 0);

    printf("Enter the key to search: ");
    scanf("%d", &key);
    search(key);

    preorder(root);
    postorder(root);
    inorder(root);
}

void insert(int item) {
    struct node *ptr, *parentptr, *nodeptr;
    ptr = (struct node *)malloc(sizeof(struct node));
    if (ptr == NULL) {
        printf("Can't insert\n");
    } else {
        ptr->data = item;
        ptr->left = NULL;
        ptr->right = NULL;

        if (root == NULL) {
            root = ptr;
            printf("Node Inserted as root\n");
        } else {
            parentptr = NULL;
            nodeptr = root;
            while (nodeptr != NULL) {
                parentptr = nodeptr;
                if (item < nodeptr->data) {
                    nodeptr = nodeptr->left;
                } else {
                    nodeptr = nodeptr->right;
                }
            }
            if (item < parentptr->data) {
                parentptr->left = ptr;
            } else {
                parentptr->right = ptr;
            }
            printf("Node Inserted\n");
        }
    }
}

void search(int key) {
    if (root == NULL) {
        printf("Tree is empty\n");
        return;
    }

    struct node *temp = root;
    while (temp != NULL) {
        if (key == temp->data) {
            printf("Key Found\n");
            return;
        } else if (key < temp->data) {
            temp = temp->left;
        } else {
            temp = temp->right;
        }
    }

    printf("Key not found\n");
}

// Preorder traversal (Root, Left, Right)
void preorder(struct node *node) {
    if (node != NULL) {
        printf("%d ", node->data);
        preorder(node->left);
        preorder(node->right);
    }
}

// Inorder traversal (Left, Root, Right)
void inorder(struct node *node) {
    if (node != NULL) {
        inorder(node->left);
        printf("%d ", node->data);
        inorder(node->right);
    }
}

// Postorder traversal (Left, Right, Root)
void postorder(struct node *node) {
    if (node != NULL) {
        postorder(node->left);
        postorder(node->right);
        printf("%d ", node->data);
    }
}

