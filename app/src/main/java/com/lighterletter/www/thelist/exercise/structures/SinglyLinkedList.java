package com.lighterletter.www.thelist.exercise.structures;

/**
 *
 */

public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtStart(T val) {
        Node<T> newNumberNode = new Node<>(val, null);
        size++;
        if (head == null) {
            head = newNumberNode;
            tail = head;
        } else {
            newNumberNode.setNext(head);
            head = newNumberNode;
        }
    }

    public void insertAtEnd(T val) {
        Node<T> newNumberNode = new Node<>(val, null);
        size++;
        if (head == null) {
            head = newNumberNode;
            tail = head;
        } else {
            tail.setNext(newNumberNode);
            tail = newNumberNode;
        }
    }

    public void insertAtPos(T val, int pos) {
        Node<T> newNumberNode = new Node<>(val, null);
        Node<T> node = head;
        pos = pos - 1;
        for (int i = 1; i < size; i++) {
            if (i == pos) {
                Node<T> tmp = node.getNext();
                node.setNext(newNumberNode);
                newNumberNode.setNext(tmp);
                break;
            }
            node = node.getNext();
        }
        size++;
    }

    public void deleteAtPos(int pos) {
        if (pos == 1) {
            head = head.getNext();
            size--;
            return;
        }
        if (pos == size) {
            Node s = head;
            Node t = head;
            while (s != tail) {
                t = s;
                s = s.getNext();
            }
            tail = t;
            tail.setNext(null);
            size--;
            return;
        }
        Node<T> node = head;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                Node<T> tmp = node.getNext();
                tmp = tmp.getNext();
                node.setNext(tmp);
                break;
            }
            node = node.getNext();
        }
        size--;
    }

    public String display() {
        StringBuilder builder = new StringBuilder();

        builder.append("\nSingly Linked List = ");
        if (size == 0) {
            builder.append("empty\n");
            return builder.toString();
        }

        if (head.getNext() == null) {
            builder.append(head.getData());
            return builder.toString();
        }
        Node Node;
        builder.append(head.getData()).append("->");
        Node = head.getNext();
        while (Node.getNext() != null) {
            builder.append(Node.getData()).append("->");
            Node = Node.getNext();
        }
        builder.append(Node.getData()).append("\n");
        return builder.toString();
    }
}
