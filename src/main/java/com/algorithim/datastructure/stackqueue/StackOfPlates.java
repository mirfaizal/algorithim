package com.algorithim.datastructure.stackqueue;

import java.util.ArrayList;

public class StackOfPlates {
    static class Node {
        private int data;
        private Node next;
        Node (int data){
            this.data = data;
        }
    }
    private int capacity;
    private ArrayList<Node> stackOfPlates;
    private int currentStackTopIndex;
    private int currentStackIndex;
    StackOfPlates(int stackCapacity){
        this.capacity = stackCapacity;
        this.stackOfPlates = new ArrayList<>();
        this.currentStackTopIndex = 0;
        this.currentStackIndex = 0;
    }
    private boolean isEmpty(){
        return stackOfPlates.size() == 0;
    }
    private void push(int data){
        Node head;
        Node newNode  = new Node(data);
        // Stack is empty
        if(stackOfPlates.size() == 0){
            head = newNode;
        }else{
            Node current = stackOfPlates.get(currentStackIndex);
            if(currentStackTopIndex == capacity){
                // If capacity reached add new Stack and Push
                currentStackIndex++;
                currentStackTopIndex = 0;
                head = newNode;
            } else {
                newNode.next = current;
                head = newNode;
                stackOfPlates.remove(currentStackIndex);
            }
        }
        stackOfPlates.add(currentStackIndex,head);
        currentStackTopIndex++;
    }

    private String pop(){
        if(isEmpty()) return "Empty Stack";
        Node node = stackOfPlates.get(currentStackIndex);
        int data = node.data;
        if(node.next !=null){
            node = node.next;
            stackOfPlates.remove(currentStackIndex);
            stackOfPlates.add(currentStackIndex,node);
            currentStackTopIndex--;
        }else{
            stackOfPlates.remove(currentStackIndex);
            currentStackIndex--;
            currentStackTopIndex = capacity;
        }
        return String.valueOf(data);
    }
    private String peek(){
        if(isEmpty()) return "Empty Stack";
        return String.valueOf(stackOfPlates.get(currentStackIndex).data);
    }
    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        stackOfPlates.push(55);
        stackOfPlates.push(54);
        stackOfPlates.push(53);
        stackOfPlates.push(52);
        stackOfPlates.push(51);
        stackOfPlates.push(50);
        stackOfPlates.push(49);
        stackOfPlates.push(48);
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
    }
}
