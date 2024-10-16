package com.algorithim.datastructure.stackqueue;

public class StackOld {
    private final class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public void push(int data) {
        Node newNode = new Node(data);
        // If no item on stack
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public int pop(){
        // If no item is on stack
        if(head == null) {
            System.out.println("Empty");
            return -1;
        }
        int data = head.data;
        // Had one element
        if(head == tail){
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        return data;
    }

    public boolean contains(int data){
        if(head == null) {
            System.out.println("Empty");
            return false;
        }
        Node current = head;
        while(current.next != null){
            if(current.data == data){
                return true;
            }
            current = current.next;
        }
        if(current.next == null){
            return current.data == data;
        }


        return false;
    }
}
