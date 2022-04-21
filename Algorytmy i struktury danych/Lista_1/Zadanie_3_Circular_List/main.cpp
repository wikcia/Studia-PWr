#include <iostream>
/**
 * Doubly Circular Linked List Implementation
 */
// node struct
struct Node{
    int data;
    Node* next; // pointer to next node in doubly linked list
    Node* prev; // pointer to previous node in doubly linked list
};

// function to insert a new node at the end
void insertEnd(Node** start, int value)
{
    // If the list is empty, create a single node
    if (*start == nullptr)
    {
        Node* new_node = new Node;
        new_node->data = value;
        new_node->next = new_node->prev = new_node;
        *start = new_node;
        return;
    }

    // if list is not empty

    // find last node
    Node *last = (*start)->prev;

    // create node dynamically
    Node* new_node = new Node;

    // assign a new data to a newly created node
    new_node->data = value;

    // Start is going to be next of new_node
    new_node->next = *start;

    // Make new node previous of start
    (*start)->prev = new_node;

    // Make last previous of new node
    new_node->prev = last;

    // Make new node next of old last
    last->next = new_node;
}

int search(Node* start, int val) {
    // temporary variable
    Node *temp = start;

    // control variables for the searching
    int count = 0, flag = 0;

    // if start is NULL return -1
    if(temp == nullptr)
        return -1;
    else
    {
        // Move the temp pointer until temp->next doesn't move start address
        while(temp->next != start) {
            // if it is found raise the flag and break the loop
            if(temp->data == val)
            {
                flag = 1;
                break;
            }
            // increment temp pointer
            temp = temp->next;
        }
        // at the last, as the last node is not visited yet check for the n element
        if(temp->data == val)
        {
            flag = 1;
        }

        // if flag is true, then element found, else not found
        if(flag == 1)
            std::cout << val << " found in the circular list" << std::endl;
        else
            std::cout << "\n" << val << " not found" << std::endl;
    }
}
void display(struct Node* start) {
    struct Node *temp = start;

    while (temp->next != start)
    {
        std::cout << temp->data << " => ";
        temp = temp->next;
    }
    std::cout << temp->data << std::endl;
}

Node* merge(Node* start_1, Node* start_2) {
    // if either is NULL, return other
    if (start_1 == nullptr)
        return start_2;
    if (start_2 == nullptr)
        return start_1;

    start_1->next->prev = start_2->prev;
    start_2->prev->next = start_1->next;
    start_1->next = start_2;
    start_2->prev = start_1;
}

void test(Node *head) {
    int x;
    std::chrono::steady_clock::time_point begin = std::chrono::steady_clock::now();
    search(head,5);
    std::chrono::steady_clock::time_point end = std::chrono::steady_clock::now();

    std::cout << "TEST 1 -> Time difference = "
              << std::chrono::duration_cast<std::chrono::nanoseconds>(end - begin).count() << "[ns]" << std::endl;

    std::chrono::steady_clock::time_point begin2 = std::chrono::steady_clock::now();
    search(head,19);
    std::chrono::steady_clock::time_point end2 = std::chrono::steady_clock::now();

    std::cout << "TEST 2 -> Time difference = "
              << std::chrono::duration_cast<std::chrono::nanoseconds>(end2 - begin2).count() << "[ns]" << std::endl;

    std::chrono::steady_clock::time_point begin3 = std::chrono::steady_clock::now();
    search(head,10);
    std::chrono::steady_clock::time_point end3 = std::chrono::steady_clock::now();

    std::cout << "TEST 3 -> Time difference = "
              << std::chrono::duration_cast<std::chrono::nanoseconds>(end2 - begin2).count() << "[ns]" << std::endl;

    std::chrono::steady_clock::time_point begin4 = std::chrono::steady_clock::now();
    search(head,7);
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

int main() {
    Node* start = nullptr;
    Node* start_2 = nullptr;

    insertEnd(&start, 5);
    insertEnd(&start, 4);
    insertEnd(&start, 7);
    insertEnd(&start, 8);

    insertEnd(&start_2, 9);
    insertEnd(&start_2, 10);
    insertEnd(&start_2, 19);
    insertEnd(&start_2, 13);
    merge(start,start_2);

    std::cout << "Doubly linked list is as follows: " << std::endl;
    display(start);
    search(start,8);
    search(start,5);
    test(start);

    return 0;
}
