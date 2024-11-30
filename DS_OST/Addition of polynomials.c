/*#include<stdio.h>
#include<stdlib.h>

struct node {
    int coef;
    int expo;
    struct node *link;
};

// Function to create a new term (node)
struct node* create_node(int coef, int expo) {
    struct node* new_node = (struct node*)malloc(sizeof(struct node));
    new_node->coef = coef;
    new_node->expo = expo;
    new_node->link = NULL;
    return new_node;
}

// Function to insert a term into the polynomial linked list
void insert_node(struct node** head, int coef, int expo) {
    struct node* new_node = create_node(coef, expo);

    if (*head == NULL) {
        *head = new_node;
    } else {
        struct node* temp = *head;
        while (temp->link != NULL) {
            temp = temp->link;
        }
        temp->link = new_node;
    }
}

// Function to create a polynomial by asking the user for terms
struct node* create_polynomial() {
    int n, coef, expo;
    struct node* head = NULL;
    printf("Enter the number of terms: ");
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        printf("Enter the coefficient and exponent for term %d: ", i + 1);
        scanf("%d%d", &coef, &expo);
        insert_node(&head, coef, expo);
    }
    return head;
}

// Function to add two polynomials
struct node* add_polynomials(struct node* poly1, struct node* poly2) {
    struct node* sum = NULL;
    struct node* ptr1 = poly1;
    struct node* ptr2 = poly2;

    while (ptr1 != NULL && ptr2 != NULL) {
        if (ptr1->expo == ptr2->expo) {
            // Same exponent, add the coefficients
            insert_node(&sum, ptr1->coef + ptr2->coef, ptr1->expo);
            ptr1 = ptr1->link;
            ptr2 = ptr2->link;
        } else if (ptr1->expo > ptr2->expo) {
            // Insert the term with larger exponent
            insert_node(&sum, ptr1->coef, ptr1->expo);
            ptr1 = ptr1->link;
        } else {
            insert_node(&sum, ptr2->coef, ptr2->expo);
            ptr2 = ptr2->link;
        }
    }

    // If any terms remain in poly1
    while (ptr1 != NULL) {
        insert_node(&sum, ptr1->coef, ptr1->expo);
        ptr1 = ptr1->link;
    }

    // If any terms remain in poly2
    while (ptr2 != NULL) {
        insert_node(&sum, ptr2->coef, ptr2->expo);
        ptr2 = ptr2->link;
    }

    return sum;
}

// Function to add two polynomials
struct node* sub_polynomials(struct node* poly1, struct node* poly2) {
    struct node* diff = NULL;
    struct node* ptr1 = poly1;
    struct node* ptr2 = poly2;

    while (ptr1 != NULL && ptr2 != NULL) {
        if (ptr1->expo == ptr2->expo) {
            // Same exponent, add the coefficients
            insert_node(&diff, ptr1->coef - ptr2->coef, ptr1->expo);
            ptr1 = ptr1->link;
            ptr2 = ptr2->link;
        } else if (ptr1->expo > ptr2->expo) {
            // Insert the term with larger exponent
            insert_node(&diff, ptr1->coef, ptr1->expo);
            ptr1 = ptr1->link;
        } else {
            insert_node(&diff, ptr2->coef, ptr2->expo);
            ptr2 = ptr2->link;
        }
    }

    // If any terms remain in poly1
    while (ptr1 != NULL) {
        insert_node(&diff, ptr1->coef, ptr1->expo);
        ptr1 = ptr1->link;
    }

    // If any terms remain in poly2
    while (ptr2 != NULL) {
        insert_node(&diff, ptr2->coef, ptr2->expo);
        ptr2 = ptr2->link;
    }

    return diff;
}

// Function to display a polynomial
void display_polynomial(struct node* head) {
    if (head == NULL) {
        printf("Polynomial is empty.\n");
        return;
    }

    struct node *ptr1, *ptr2;
    int temp_coef, temp_expo;

    // Sort the polynomial in descending order based on exponents
    for (ptr1 = head; ptr1 != NULL; ptr1 = ptr1->link) {
        for (ptr2 = ptr1->link; ptr2 != NULL; ptr2 = ptr2->link) {
            if (ptr1->expo < ptr2->expo) {
                // Swap coefficients
                temp_coef = ptr1->coef;
                ptr1->coef = ptr2->coef;
                ptr2->coef = temp_coef;

                // Swap exponents
                temp_expo = ptr1->expo;
                ptr1->expo = ptr2->expo;
                ptr2->expo = temp_expo;
            }
        }
    }

    // Display the sorted polynomial
    struct node* temp = head;
    while (temp != NULL) {
        printf("%dx^%d", temp->coef, temp->expo);
        temp = temp->link;
        if (temp != NULL) {
            printf(" + ");
        }
    }
    printf("\n");
}


int main() {
    struct node *poly1 = NULL, *poly2 = NULL, *sum = NULL, *diff = NULL;

    printf("Enter the first polynomial:\n");
    poly1 = create_polynomial();

    printf("Enter the second polynomial:\n");
    poly2 = create_polynomial();

    sum = add_polynomials(poly1, poly2);

    diff = sub_polynomials(poly1, poly2);

    printf("\nFirst Polynomial: ");
    display_polynomial(poly1);
    printf("Second Polynomial: ");
    display_polynomial(poly2);
    printf("Sum Polynomial: ");
    display_polynomial(sum);
    printf("Diff Polynomial: ");
    display_polynomial(diff);

    return 0;
}

*/
