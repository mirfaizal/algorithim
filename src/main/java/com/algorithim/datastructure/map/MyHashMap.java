package com.algorithim.datastructure.map;

class MyHashMap {

    final class Node {
        int key;
        int value;
        Node next = null;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private int initialCapacity = 99;
    private Node [] data;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.data = new Node[initialCapacity];
    }

    private int index(int key){
        return String.valueOf(key).hashCode()  & 0x7fffffff % initialCapacity;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = index(key);
        Node node = new Node(key,value);
        Node nodes = this.data[index];
        if(nodes == null){
            this.data[index] = node;
        } else {
            if(nodes.next == null && nodes.key == key){
               nodes.value = node.value;
               return;
            }
            while(nodes.next != null && nodes.key != key){
                nodes = nodes.next;
            }
            nodes.next = node;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = index(key);
        Node nodes = data[index];
        if(nodes != null) {
            while(nodes.key != key && nodes.next != null) {
                nodes = nodes.next;
            }
            return nodes.key == key ? nodes.value: -1;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = index(key);
        Node nodes = data[index];
        if(nodes != null){
            if(nodes.next == null && nodes.key == key){
                data[index] = null;
                return;
            }
            while(nodes.next != null){
                if(nodes.next.key == key){
                    nodes.next = nodes.next.next;
                    break;
                }
                nodes = nodes.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // returns 1
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.get(2);            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found)
    }
}
