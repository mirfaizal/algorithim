package com.algorithim.datastructure.stackqueue;

public class MinStack {
    static class Node {
        private int data;
        private Node next;
        Node(int data){
            this.data = data;
        }
    }    
    private Node head;
    private Node min;
    private void push(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            min = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        Node minNode = new Node(data);
        if(peek(min) > data){
            minNode.next = min;
            min = minNode;
        }
    }

    private String pop(){
        if(head == null) return "Stack is Empty";
        int data = head.data;
        if(min != null && peek(min) == data){
            min = min.next;
        }
        head = head.next;
        return String.valueOf(data);
    }

    private int peek(Node node) {
        if(node == null) return 0;
        return node.data;
    }

    private int min() {
        if(head == null) return 0;
        if(head!= null & head.next == null && min == null){
            return head.data;
        }
        if(min == null) return 0;
        return min.data;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(100);
        minStack.push(7);
        minStack.push(700);
        minStack.push(6);
        minStack.push(3);
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
    }
}
