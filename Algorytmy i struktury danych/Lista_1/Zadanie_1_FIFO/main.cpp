#include <iostream>
#define MAX_SIZE 5
#define ERROR 10000000;
using namespace std;

// FIFO data structure
struct Queue {
    int myQueue[MAX_SIZE];
    int head;
    int tail;
    Queue(); // declaration od the constructor

    bool isFull(){
        if(head == 0 && tail == MAX_SIZE - 1){
            return true;
        }
        return false;
    }

    bool isEmpty(){
        if(head == -1) {
            return true;
        }
        else
            return false;
    }

    // add an item to the queue; addition of an item to the queue is always done at the rear of the queue.
    int enqueue(int value){
        if(isFull()){
            cout << endl<< "Queue is full!!";
            return ERROR;
        } else {
            if (head == -1) { // if queue is empty make a new queue
                head = 0;
            }
            tail++;
            myQueue[tail] = value;
            cout << value << " ";
            return value;
        }
    }
    // remove an item from the queue; an item is removed always from the front of the queue.
    int dequeue(){
        int value;
        if(isEmpty()){ // if queue is empty, display an underflow error and exit
            cout << "Queue is empty!!" << endl;
            return(-1); }
        else {
            value = myQueue[head];
            if(head >= tail){      //only one element in queue
                head = -1;
                tail = -1;
            }
            else {
                head++;
            }
            cout << endl << "Deleted => " << value << " from myQueue";
            return(value);
        }
    }

    /* Function to display elements of Queue */
    void displayQueue()
    {
        int i;
        if(isEmpty()) {
            cout << endl << "Queue is Empty!!" << endl;
        }
        else {
            cout << endl << "Queue elements : ";
            for(i = head; i <= tail; i++) // iterating over queue elements
                cout << myQueue[i] << " ";
        }
    }
};
// head and tail of the queue are firstly set to -1(indexes)
Queue::Queue() {
    head = -1;
    tail = -1;
}
int main()
{
    Queue myQueue;

    myQueue.dequeue();      //dequeue

    cout<<"Queue created:"<<endl;
    myQueue.enqueue(1);
    myQueue.enqueue(2);
    myQueue.enqueue(3);
    myQueue.enqueue(4);
    myQueue.enqueue(5);
    myQueue.enqueue(6); // trying to add another element results in error; queue size is 5

    myQueue.displayQueue();

    //dequeue removes head which is equal to 10
    myQueue.dequeue();

    //queue after dequeue
    myQueue.displayQueue();

    return 0;
}