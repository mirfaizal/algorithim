package com.algorithim.datastructure.map;

class MyHashSet {

    final class Node {
        int key;
        Node next = null;
        Node(int key){
            this.key = key;
        }
    }
    private int initialCapacity = 2000;
    private Node [] data;

    public MyHashSet() {
        this.data = new Node[initialCapacity];
    }

    public int index(int key){
        return (String.valueOf(key).hashCode() & 0x7fffffff) % initialCapacity;
    }

    public void add(int key) {
        if(contains(key))  return;
        int index = index(key);
        Node node = new Node(key);
        Node nodes = data[index];
        if(nodes == null) {
            data[index] = node;
        } else{
            while(nodes != null){
                nodes = nodes.next;
            }
            nodes = node;
        }
    }

    public void remove(int key) {
        int index = index(key);
        Node nodes = data[index];
        if(nodes != null){
            // 1st node
            if(nodes.next == null && nodes.key == key){
                data[index] = null;
                return;
            }
            // Rest of the items
            while(nodes.next != null){
                if(nodes.next.key == key){
                    nodes.next = nodes.next.next;
                    break;
                }
                nodes = nodes.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = index(key);
        Node nodes = data[index];
        if(nodes != null){
            while(nodes.key != key && nodes.next != null){
                nodes = nodes.next;
            }
            return nodes.key == key;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);
        myHashSet.add(101);
        myHashSet.add(1001);
        myHashSet.add(102);
        myHashSet.add(1002); // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println( myHashSet.contains(2)); // return False, (already removed)
    }
}
