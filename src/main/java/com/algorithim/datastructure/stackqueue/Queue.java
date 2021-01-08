package com.algorithim.datastructure.stackqueue;

public class Queue<T> {
    private final class Node<T> {
        private final T data;
        private Node next;
        public Node(T data) {
            this.data = data;
        }
    }
    private Node<T> head , tail;
    private boolean isEmpty(){ return head == null && tail == null;}
    private void add(T data){
        Node<T> newNode = new Node<>(data);
        if(tail != null) tail.next = newNode;
        tail = newNode;
        if(head == null) head = newNode;
    }
    private T remove(){
        if(head == null) {
            System.out.println("Empty Queue");
            return null;
        }
        T item = head.data;
        head = head.next;
        if(head == null) tail = null;
        return item;
    }
    private T peek(){
        if(head == null) {
            System.out.println("Empty Queue");
            return null;
        }
        return head.data;
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add("Faizal");
        queue.add("Mir");
        queue.add("Ali");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
    }
}
