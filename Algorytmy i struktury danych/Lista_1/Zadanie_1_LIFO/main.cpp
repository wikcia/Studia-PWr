/*
 * Implementation of stack - data structure LIFO (Last in - First out)
 */
#include <iostream>

using namespace std;

#define MAX 10
int size = 0;

// Creating a stack
struct Stack {
    int items[MAX]; // declaration of an array
    int top;
};

void createEmptyStack(Stack *s) {
    s->top = -1;
}

// Check if the stack is full
bool isFull(Stack *s) {
    if (s->top == MAX - 1)
        return true;
    else
        return false;
}

// Check if the stack is empty
bool isEmpty(Stack *s) {
    if (s->top == -1)
        return true;
    else
        return false;
}

// Add elements into stack
void push(Stack *s, int newItem) {
    if (isFull(s)) {
        cout << "Stack overflow";
    } else {
        s->top++;
        s->items[s->top] = newItem;
    }
    size++;
}

// Remove element from stack
void pop(Stack *s) {
    if (isEmpty(s)) {
        cout << "Stack is empty" << endl;
    } else {
        cout << "Item popped= " << s->items[s->top];
        s->top--;
    }
    size--;
    cout << endl;
}

// Print elements of stack
void printStack(Stack *s) {
    printf("Stack: ");
    for (int i = 0; i < size; i++) {
        cout << s->items[i] << " ";
    }
    cout << endl;
}

// Driver code
int main() {

    Stack *s = new Stack;

    createEmptyStack(s);

    push(s, 1);
    push(s, 2);
    push(s, 3);
    push(s, 4);

    printStack(s);

    pop(s);

    cout << "After popping out " << endl;
    printStack(s);
    delete s;
}
