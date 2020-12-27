package com.algorithim.datastructure.misc;

import java.util.List;

public class LinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // O(1) constant time
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

    // O(n) Linear Time
    public void addBack(int data) {
        Node newNode = new Node(data);
        if(head == null){
            throw new IllegalArgumentException("Empty List");
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = newNode;
    }

    public int getFirst() {
        if (head == null) {
            throw new IllegalArgumentException("Empty List");
        }
        return head.data;
    }

    public Node getFirstNode() {
        if (head == null) {
            throw new IllegalArgumentException("Empty List");
        }
        return head;
    }

    // O(n) Linear Time
    public int getLast() {
        if (head == null) {
            throw new IllegalArgumentException("Empty List");
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public void delete(int data){
        if(head == null){
            throw new IllegalArgumentException("Empty List");
        }
        // Node has only head O(1) constant time
        if(head.data == data){
            head = head.next;
        }
        // Node has many O(n) Linear Time
        Node current = head;
        while(current.next != null){
            if(current.next.data == data){
                // if match move the pointer to next
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
    }

    // O(n^2) times
    public void removeDuplicate(){
        if(head == null){
            throw new IllegalArgumentException("Empty List");
        }
        if(head.next == null){
            // List has one item
            return;
        }
        Node current = head;
        Node currentToSearch = head.next;
        while(current.next !=null){
            while(currentToSearch !=null && currentToSearch.next !=null){
                if(current.data == currentToSearch.next.data){
                    currentToSearch.next = currentToSearch.next.next;
                    System.gc();
                }
                currentToSearch = currentToSearch.next;
            }
            current = current.next;
            currentToSearch = current.next;
        }
    }

    public int kthToLast(){
        if(head == null){
            throw new IllegalArgumentException("Empty List");
        }
        // One item
        if(head.next == null){
            return head.data;
        }

        Node current = head, currentNext = head.next;
        while(currentNext != null && currentNext.next != null ){
            currentNext = currentNext.next;
            current = current.next;
        }
        return current.data;

    }

    public void reverse(){
        if(head == null){
            throw new IllegalArgumentException("Empty List");
        }
        if(head.next == null){
            return;
        }
        Node current = head, next , previous = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public char [] sumLinkedListBruteForce(Node listOne, Node listTwo){
        StringBuilder numberOne = new StringBuilder();
        while(listOne.next != null){
            numberOne.append(listOne.data);
            listOne = listOne.next;
        }
        numberOne.append(listOne.data);
        //numberOne.reverse();
        StringBuilder numberTwo = new StringBuilder();
        while(listTwo.next != null){
            numberTwo.append(listTwo.data);
            listTwo = listTwo.next;
        }
        numberTwo.append(listTwo.data);
        //numberTwo.reverse();
        Integer numOne = Integer.parseInt(numberOne.toString());
        Integer numTwo = Integer.parseInt(numberTwo.toString());
        Integer sum = numOne + numTwo;
        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        //sb.reverse();
        return sb.toString().toCharArray();
    }

    public void display(){
        if(head == null){
            throw new IllegalArgumentException("Empty List");
        }
        if(head.next == null){
            System.out.println(head.data);
            return;
        }
        Node current = head;
        while(current.next !=null){
            System.out.print(current.data);
            current = current.next;
        }
        if(current.next == null){
            System.out.print(current.data);
        }
    }

    public int size(){
        if(head == null){
            return 0;
        }
        if(head.next == null){
            return 1;
        }
        int count = 0;
        Node current = head;
        while(current.next !=null){
            count++;
            current = current.next;
        }
        if(current.next == null){
            count++;
        }
        return count;
    }
}
