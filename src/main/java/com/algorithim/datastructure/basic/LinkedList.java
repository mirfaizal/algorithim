package com.algorithim.datastructure.basic;

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
        if (head == null) {
            throw new IllegalArgumentException("Empty List");
        }
        Node current = head;
        while (current.next != null) {
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

    public void delete(int data) {
        if (head == null) {
            throw new IllegalArgumentException("Empty List");
        }
        // Node has only head O(1) constant time
        if (head.data == data) {
            head = head.next;
        }
        // Node has many O(n) Linear Time
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                // if match move the pointer to next
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
    }

    public Node insertNodeAtPosition(int data, int position) {
        Node newNode = new Node(data);
        Node current = head, previous = null;
        int i = 0;
        while (current.next != null && i < position) {
            previous = current;
            current = current.next;
            i++;
        }
        previous.next = newNode;
        newNode.next = current;
        return head;
    }

    public boolean hasCycle() {
        Node current = head;
        Node next = head;
        while (next != null && next.next != null) {
            current = current.next;
            next = next.next.next;
            if (current == next) {
                return true;
            }
        }
        return false;
    }

    // O(n^2) times
    public void removeDuplicate() {
        if (head == null) {
            throw new IllegalArgumentException("Empty List");
        }
        if (head.next == null) {
            // List has one item
            return;
        }
        Node current = head;
        Node currentToSearch = head.next;
        while (current.next != null) {
            while (currentToSearch != null && currentToSearch.next != null) {
                if (current.data == currentToSearch.next.data) {
                    currentToSearch.next = currentToSearch.next.next;
                    System.gc();
                }
                currentToSearch = currentToSearch.next;
            }
            current = current.next;
            currentToSearch = current.next;
        }
    }

    public int kthToLast() {
        if (head == null) {
            throw new IllegalArgumentException("Empty List");
        }
        // One item
        if (head.next == null) {
            return head.data;
        }

        Node current = head, currentNext = head.next;
        while (currentNext != null && currentNext.next != null) {
            currentNext = currentNext.next;
            current = current.next;
        }
        return current.data;

    }

    public void reverse() {
        if (head == null) {
            throw new IllegalArgumentException("Empty List");
        }
        if (head.next == null) {
            return;
        }
        Node current = head, next, previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;
        int sum = 0;
        int rem = 0;
        while(l1 != null || l2 != null) {
             int x = (l1 != null)?l1.data:0;
             int y = (l2 != null)?l2.data:0;
             sum = carry + x + y;
             carry = sum / 10;
             rem = sum % 10;
             insert(rem);
             if(l1!=null) l1 = l1.next;
             if(l2 !=null) l2 = l2.next;

        }
        return node;
    }
    Node node = null;
    private void insert(int val){
        Node newNode = new Node(val);
        if(node == null){
            node = newNode;
            return;
        }
        newNode.next = node;
        node = newNode;
    }

    public char[] sumLinkedListBruteForce(Node listOne, Node listTwo) {
        StringBuilder numberOne = new StringBuilder();
        while (listOne != null) {
            numberOne.append(listOne.data);
            listOne = listOne.next;
        }
        //numberOne.reverse();
        StringBuilder numberTwo = new StringBuilder();
        while (listTwo != null) {
            numberTwo.append(listTwo.data);
            listTwo = listTwo.next;
        }
        //numberTwo.reverse();
        Integer numOne = Integer.parseInt(numberOne.toString());
        Integer numTwo = Integer.parseInt(numberTwo.toString());
        Integer sum = numOne + numTwo;
        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        //sb.reverse();
        return sb.toString().toCharArray();
    }

    public void display() {
        if (head == null) {
            throw new IllegalArgumentException("Empty List");
        }
        if (head.next == null) {
            System.out.println(head.data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            System.out.print(current.data);
            current = current.next;
        }
        if (current.next == null) {
            System.out.print(current.data);
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return 1;
        }
        int count = 0;
        Node current = head;
        while (current.next != null) {
            count++;
            current = current.next;
        }
        if (current.next == null) {
            count++;
        }
        return count;
    }

    public Node reverseInBetween(int m, int n) {
        Node current = head;
        Node previous = null;
        int index = 1;
        // Move the pointer to mth position
        while(current != null && index < m){
            previous = current;
            current = current.next;
            index++;
        }
        Node mthCurrent = current;
        Node nthCurrent = mthCurrent;
        // Move the pointer to nth position
        while(nthCurrent != null && index < n){
            nthCurrent = nthCurrent.next;
            index++;
        }
        Node mthPrevious = nthCurrent.next, mthNext;
        index = m;
        while(mthCurrent !=null && index <= n){
            mthNext = mthCurrent.next;
            mthCurrent.next = mthPrevious;
            mthPrevious = mthCurrent;
            mthCurrent = mthNext;
            index++;
        }
        // Point previous pointer to mthPrevious
        if(previous != null)  previous.next = mthPrevious;
        else head = mthPrevious;
        return head;
    }

    public Node reverseOperationEvenNumbers(){
        Node current = head;
        Node headT = head;
        Node first = null;
        while(current!=null) {
            Node previous = null, next = null;
            first = current;
            while (current != null && current.data % 2 != 0) {
                current = current.next;
            }
            while (current != null && current.data % 2 == 0) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            first.next = previous;
            Node newHead = first;
            while(newHead!=null && newHead.next !=null){
                newHead = newHead.next;
            }
            newHead.next = current;
        }
        return head;
    }
}
