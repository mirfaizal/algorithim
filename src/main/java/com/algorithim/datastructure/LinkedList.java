package com.algorithim.datastructure;

public class LinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addFront(int data) {
        Node newNode = new Node(data);
        // If Head is NULL
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addBack(int data) {
        Node newNode = new Node(data);
    }

    public int getFirst() {
        if (head == null) {
            throw new IllegalArgumentException("Empty List");
        }
        return head.data;
    }

    public int getLast() {
        if (head == null) {
            throw new IllegalArgumentException("Empty List");
        }
        Node current = head;
        while (current.next != null) {
            current = current.next; // O(n)
        }
        return current.data;
    }

}
