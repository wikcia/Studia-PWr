#include <iostream>
#include <chrono>
/**
 * Doubly Linked List Implementation
 */
// node struct
struct Node{
    int data;
    Node* next; // Pointer to next node in doubly linked list
    Node* prev; // Pointer to previous node in doubly linked list
};

// function to add a node at the front of the doubly linked list
// wazne !!! dajemy wskaznik na wskaznik zeby operowac na konkretnym miejscu w pamieci !!!

void insertFront(Node** head_ref, int new_data) // given a reference (pointer to pointer) to the head of a list
{
    // make a new node
    Node* new_node = new Node();

    // assign a new data to a newly created node
    new_node->data = new_data;

    // Make next of new node as head and previous as NULL
    new_node->next = (*head_ref);
    new_node->prev = nullptr;

    // change prev of head node to new node
    if ((*head_ref) != nullptr)
        (*head_ref)->prev = new_node;

    // move the head to point to the new node
    (*head_ref) = new_node;
}

// function adding a node after a given node

void insertAfterAGivenNode(Node* prev_node, int new_data)
{
    // check if the given prev_node is not NULL
    if (prev_node == nullptr)
    {
        std::cout<<"The given previous node cannot be NULL";
        return;
    }
    // make a new node
    Node* new_node = new Node();

    // assign a new data to a newly created node
    new_node->data = new_data;

    // make next of new node as next of prev_node
    new_node->next = prev_node->next;

    // make prev_node as previous of new_node
    new_node->prev = prev_node;

    // make the next of prev_node as new_node
    prev_node->next = new_node;

    // A -> B -> C ... A -> B -> E -> C ; E is inserted
    // change previous pointer of new_node's next node(which is C); we are changing next node (new_node->next is C)
    if (new_node->next != nullptr)
        new_node->next->prev = new_node;
}

void insertAtTheEnd(Node** head_ref, int new_data)
{
    // make a new node
    Node* new_node = new Node();

    // assign a new data to a newly created node
    new_node->data = new_data;

    // this new node is going to be the last node
    new_node->next = nullptr;

    // if the Linked List is empty, then make the new node as head
    if (*head_ref == nullptr)
    {
        new_node->prev = nullptr;
        *head_ref = new_node;
        return;
    }

    // else traverse till the last node
    Node* last = *head_ref;

    while (last->next != nullptr)
        last = last->next; // we are getting at the end of the list

    // change the next of last node
    last->next = new_node;

    // make last node as previous of new node
    new_node->prev = last;

    return;
}

// this function prints contents of linked list
void displayList(Node* node) {
    while (node != nullptr) {
        std::cout << node->data << std::endl;
        node = node->next;
    }
    if(node == nullptr) {
        std::cout << "NULL" << std::endl;
    }
}

// loop over the list; return true if element found
int search(Node *head, int val)
{
    while(head != nullptr) {
        if (head->data == val) {
            std::cout << "Value " << val << " found!" << std::endl;
            return 0;
        }
        head = head->next;
    }
    std:: cout << "Value " << val << " not found!" << std::endl;
}

// this function concatenates two lists
void merge(Node *first, Node **second)
{
    Node *firstRef = first;

    // finding the last node of the first linked list
    while (firstRef->next != nullptr)
    {
        firstRef = firstRef->next;
    }
    firstRef->next = *second;
}
void test(Node *head) {
    int x;
    std::chrono::steady_clock::time_point begin = std::chrono::steady_clock::now();
    search(head,100);
    std::chrono::steady_clock::time_point end = std::chrono::steady_clock::now();

    std::cout << "TEST 1 -> Time difference = "
              << std::chrono::duration_cast<std::chrono::nanoseconds>(end - begin).count() << "[ns]" << std::endl;

    std::chrono::steady_clock::time_point begin2 = std::chrono::steady_clock::now();
    search(head,50);
    std::chrono::steady_clock::time_point end2 = std::chrono::steady_clock::now();

    std::cout << "TEST 2 -> Time difference = "
              << std::chrono::duration_cast<std::chrono::nanoseconds>(end2 - begin2).count() << "[ns]" << std::endl;

    std::chrono::steady_clock::time_point begin3 = std::chrono::steady_clock::now();
    search(head,10);
    std::chrono::steady_clock::time_point end3 = std::chrono::steady_clock::now();

    std::cout << "TEST 3 -> Time difference = "
              << std::chrono::duration_cast<std::chrono::nanoseconds>(end2 - begin2).count() << "[ns]" << std::endl;

    std::chrono::steady_clock::time_point begin4 = std::chrono::steady_clock::now();
    search(head,90);
    std::chrono::steady_clock::time_point end4 = std::chrono::steady_clock::now();

    std::cout << "TEST 4 -> Time difference = "
              << std::chrono::duration_cast<std::chrono::nanoseconds>(end3 - begin3).count() << "[ns]" << std::endl;

    std::chrono::steady_clock::time_point begin5 = std::chrono::steady_clock::now();
    x = std::rand() % 1000 + 1;
    search(head,x);
    std::chrono::steady_clock::time_point end5 = std::chrono::steady_clock::now();

    std::cout << "TEST 5 (random variable) -> Time difference = "
              << std::chrono::duration_cast<std::chrono::nanoseconds>(end4 - begin4).count() << "[ns]" << std::endl;
}

int main(){

    Node *headPointer = nullptr;
    for(int i = 0; i < 1000; i++){

        insertFront(&headPointer,(std::rand() % 1000) + 1);
    }

    std::cout << "List is as follows: " << std::endl;
    displayList(headPointer);
    test(headPointer);

    /*
    Node *head = nullptr;
    Node *secondHead = nullptr;
    insertFront(&head, 20);
    insertFront(&head, 10);
    insertFront(&head, 50);
    insertAtTheEnd(&head, 40);
    insertAfterAGivenNode(head->next->next, 30); // we have to give an address of the previous node

    insertFront(&head, 60);
    insertFront(&head, 70);
    insertFront(&head, 80);
    insertAtTheEnd(&head, 90);
    insertAfterAGivenNode(head->next, 100); // we have to give an address of the previous node

    merge(head, &secondHead);

    std::cout << "Merged list is as follows: " << std::endl;
    std::cout << "head"<< head << std::endl;
    displayList(head);

    test(head);
     */
    return 0;
}

