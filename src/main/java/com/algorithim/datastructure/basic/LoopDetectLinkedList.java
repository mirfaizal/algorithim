package com.algorithim.datastructure.basic;

public class LoopDetectLinkedList {
    static class Node<T> {
        T data;
        Node next;
        Node(T data){
            this.data = data;
        }
    }
    private Node head;
    private void addFront(Node newNode){
        if(head == null) {head = newNode; return;};
        Node current = head;
        newNode.next = current;
        head = newNode;
    }
    public static void main(String[] args) {
        LoopDetectLinkedList loopDetectLinkedList = new LoopDetectLinkedList();
        Node nodeOne = new Node(1);
        Node nodeTwo = new Node(2);
        Node nodeThree = new Node(3);
        Node nodeFour = new Node(4);
        Node nodeFive = new Node(5);
        Node nodeSix = new Node(6);
        loopDetectLinkedList.addFront(nodeOne);
        loopDetectLinkedList.addFront(nodeTwo);
        loopDetectLinkedList.addFront(nodeThree);
        loopDetectLinkedList.addFront(nodeFour);
        loopDetectLinkedList.addFront(nodeFive);
        loopDetectLinkedList.addFront(nodeSix);
        loopDetectLinkedList.addFront(nodeTwo);
        System.out.println(loopDetectLinkedList.hasCycle());

    }

    public boolean hasCycle() {
        Node current = head;
        Node next = head;
        while(next != null && next.next != null){
            current = current.next;
            next = next.next.next;
            if(current == next){
                return true;
            }
        }
        return false;
    }
}
