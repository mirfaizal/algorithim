package com.algorithim.datastructure.basic;

public class Stack<T> {
    private Node<T> top;
    private boolean isEmpty() { return top == null;}
    private void push(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }
    private T pop() throws Exception {
        if(top == null) throw new Exception("Stack empty");
        T item = top.data;
        top = top.next;
        return item;
    }
    private T peek() throws Exception {
        if(top == null) throw new Exception("Stack empty");
        return top.data;
    }

    public static void main(String[] args) throws Exception{
        Stack queue = new Stack();
        queue.push("Faizal");
        queue.push("Mir");
        queue.push("Ali");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.isEmpty());
    }
}
