package com.lighterletter.www.thelist.exercise.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * From: http://www.sanfoundry.com/java-program-implement-stack-using-linked-list/
 * <p>
 * Description:
 * <p>
 * A Stack is an area of memory that holds all local variables and parameters used by any function,
 * and remembers the order in which functions are called so that function returns occur correctly.
 * Each time a function is called, its local variables and parameters are “pushed onto” the stack.
 * When the function returns, these locals and parameters are “popped”. Because of this, the size
 * of a program’s stack fluctuates constantly as the program is running, but it has some maximum
 * size. Stack is a Last In First Out (LIFO) abstract data type and linear data structure. Linked
 * list is a data structure consisting of a group of nodes which together represent a sequence.
 * This class uses the structure of linked lists to perform the basic operations of a stack.
 */

public class LinkedStack<T> {
    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (top == null)
            top = newNode;
        else {
            newNode.setNext(top);
            top = newNode;
        }
        size++;
    }

    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        Node<T> node = top;
        top = node.getNext();
        size--;
        return node.getData();
    }

    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return top.getData();
    }

    public List<T> getCurrentStack() {
        List<T> currentStack = new ArrayList<>();
        System.out.print("\nCurrent Stack : ~~~~~");
        if (size == 0) {
            return currentStack; // empty list
        }
        Node<T> node = top;
        while (node != null) {
            currentStack.add(node.getData());
            node = node.getNext();
        }
        System.out.println();
        return currentStack;
    }
}
