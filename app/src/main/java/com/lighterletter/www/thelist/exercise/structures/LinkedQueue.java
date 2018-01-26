package com.lighterletter.www.thelist.exercise.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * From: http://www.sanfoundry.com/java-program-implement-queue-using-linked-list/
 * <p>
 * Description:
 * <p>
 * This class implements a queue using a linked list. A queue is a particular kind of
 * abstract data type or collection in which the entities in the collection are kept in order and
 * the principal (or only) operations on the collection are the addition of entities to the rear
 * terminal position and removal of entities from the front terminal position. This makes queue a
 * First-In-First-Out (FIFO) data structure. A linked list is an ordered set of data elements,
 * each containing a link to its successor. Here we modify a linked list to perform the basic
 * operations of a queue.
 */

public class LinkedQueue<T> {

    protected Node<T> front, rear;
    public int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    /*  Function to insert an element to the queue */
    public void insert(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = rear.getNext();
        }
        size++;
    }

    /*  Function to remove front element from the queue */
    public T remove() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        Node<T> node = front;
        front = node.getNext();
        if (front == null)
            rear = null;
        size--;
        return node.getData();
    }

    /*  Function to check the front element of the queue */
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return front.getData();
    }

    /*  Function to getCurrentQueue the status of the queue */
    public List<T> getCurrentQueue() {
        List<T> currentQueue = new ArrayList<>();
        System.out.print("\nCurrent Queue: ~~~~~ ");
        if (size == 0) {
            System.out.print("Empty\n");
            return currentQueue; // will be empty.
        }
        Node<T> node = front;
        while (node != rear.getNext()) {
            currentQueue.add(node.getData());
            node = node.getNext();
        }
        return currentQueue;
    }
}
