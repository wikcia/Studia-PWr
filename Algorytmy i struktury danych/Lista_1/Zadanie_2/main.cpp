#include <iostream>
using namespace std;

// Making a node struct containing a data int and a pointer
// to another node
struct Node {
    int data;
    Node *next;
};

struct SinglyLinkedList
{
    // head pointer
    Node* head;
    SinglyLinkedList(); // we have to give compiler an information about custom constructor that we are going to give this class

    // inserting elements (At start of the list)
    void insert(int val)
    {
        // make a new node
        Node* new_node = new Node;
        new_node->data = val;
        new_node->next = nullptr;

        // If list is empty, make the new node, the head
        if (head == nullptr)
            head = new_node;
            // else, make the new_node the head and its next, the previous
            // head
        else
        {
            new_node->next = head;
            head = new_node;
        }
    }

    // loop over the list; return true if element found
    bool search(int val)
    {
        Node* temp = head;
        while(temp != nullptr)
        {
            if (temp->data == val)
                return true;
            temp = temp->next;
        }
        return false;
    }


    void display()
    {
        Node* temp = head;
        while(temp != nullptr)
        {
            cout << temp->data << " " <<endl;
            temp = temp->next;
        }
    }

    // recursive function
    // we are firstly checking if the next node (a->next) is NULL or not. If it is NULL,
    // then we are just changing its value from NULL to ‘b’ (a->next = b)
    // and if it is not then we are calling the ‘merge’ function again with the next element to traverse over the list.
    static void merge(Node *head_1, Node *head_2)
    {

        if(head_1 != nullptr && head_2 != nullptr)
        {
            if (head_1->next == nullptr)
                head_1->next = head_2;

            else
                merge(head_1->next, head_2);
        }
    }

    Node* getHead()
    {
        return head;
    }

    void test() {
        int x;
        std::chrono::steady_clock::time_point begin = std::chrono::steady_clock::now();
        search(100);
        std::chrono::steady_clock::time_point end = std::chrono::steady_clock::now();

        std::cout << "TEST 1 -> Time difference = "
                  << std::chrono::duration_cast<std::chrono::nanoseconds>(end - begin).count() << "[ns]" << std::endl;

        std::chrono::steady_clock::time_point begin2 = std::chrono::steady_clock::now();
        search(50);
        std::chrono::steady_clock::time_point end2 = std::chrono::steady_clock::now();

        std::cout << "TEST 2 -> Time difference = "
                  << std::chrono::duration_cast<std::chrono::nanoseconds>(end2 - begin2).count() << "[ns]" << std::endl;

        std::chrono::steady_clock::time_point begin3 = std::chrono::steady_clock::now();
        search(10);
        std::chrono::steady_clock::time_point end3 = std::chrono::steady_clock::now();

        std::cout << "TEST 3 -> Time difference = "
                  << std::chrono::duration_cast<std::chrono::nanoseconds>(end2 - begin2).count() << "[ns]" << std::endl;

        std::chrono::steady_clock::time_point begin4 = std::chrono::steady_clock::now();
        search(90);
        std::chrono::steady_clock::time_point end4 = std::chrono::steady_clock::now();

        std::cout << "TEST 4 -> Time difference = "
                  << std::chrono::duration_cast<std::chrono::nanoseconds>(end3 - begin3).count() << "[ns]" << std::endl;

        std::chrono::steady_clock::time_point begin5 = std::chrono::steady_clock::now();
        x = std::rand() % 1000 + 1;
        search(x);
        std::chrono::steady_clock::time_point end5 = std::chrono::steady_clock::now();

        std::cout << "TEST 5 (random variable) -> Time difference = "
                  << std::chrono::duration_cast<std::chrono::nanoseconds>(end4 - begin4).count() << "[ns]" << std::endl;
    }
};

// default constructor. Initializing head pointer
SinglyLinkedList::SinglyLinkedList(){
    head = nullptr;
}

int main() {

    SinglyLinkedList l;
    // inserting 1000 elements
    for(int i = 0; i < 1000; i++){
        l.insert((std::rand() % 1000) + 1);
    }

    l.display();
    l.test();

    /*
    SinglyLinkedList l1;
    l1.insert(1);
    l1.insert(2);
    l1.insert(4);

    SinglyLinkedList l2;
    l2.insert(3);
    l2.insert(5);
    l2.insert(6);

    SinglyLinkedList::merge(l1.getHead(), l2.getHead());
    cout << "Current Linked List: " << endl;
    l1.display();
     */

}
