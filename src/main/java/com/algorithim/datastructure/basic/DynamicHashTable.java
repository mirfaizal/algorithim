package com.algorithim.datastructure.basic;

import java.util.Objects;

public class DynamicHashTable {

    final class Node {
        private final String key;
        private final Object value;
        private Node next;

        Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size = 0;
    private Node[] hashTable;

    DynamicHashTable(int capacity) {
        this.capacity = capacity;
        this.hashTable = new Node[capacity];
    }

    private void resize() {
        int oldCapacity = capacity;
        this.capacity = capacity * 2;
        Node[] newHashTable = new Node[capacity];
        for (int i = 0; i < oldCapacity; i++) {
            Node nodes = hashTable[i];
            if (nodes != null) {
                while (nodes != null) {
                    resizeInsert(newHashTable, nodes);
                    nodes = nodes.next;
                }
            }
        }
        this.hashTable = newHashTable;
    }

    private void resizeInsert(Node[] newHashTable, Node node) {
        int index = index(node.key);
        Node newNode = new Node(node.key, node.value);
        Node newNodes = newHashTable[index];
        if (newNodes == null) {
            newHashTable[index] = newNode;
            return;
        }
        while (newNodes.next != null) {
            newNodes = newNodes.next;
        }
        newNodes.next = newNode;
    }

    private int index(String key) {
        // I could get it from key.hashCode() as well
        // Sometime has can be negative, so multiplying by 0x7fffffff
        return Objects.hash(key) & 0x7fffffff % capacity;
    }

    private void put(String key, Object value) {
        int index = index(key);
        // This is just to trigger the re-size
        if (size == 2 * capacity) {
            resize();
        }
        Node newNode = new Node(key, value);
        Node nodes = hashTable[index];
        if (nodes == null) {
            hashTable[index] = newNode;
            size++;
            return;
        }
        // Chaining -- If there are already elements at index, then go in Linked List and insert the item at end;
        while (nodes.next != null) {
            nodes = nodes.next;
        }
        nodes.next = newNode;
        size++;
    }

    private Object get(String key) {
        int index = index(key);
        Node nodes = hashTable[index];
        if (nodes == null) {
            return "Item not present";
        }
        while (nodes != null) {
            if(nodes.key.equals(key)){
                return nodes.value;
            }
            nodes = nodes.next;
        }
        return "Item not present";
    }

    private void delete(String key) {
        int index = index(key);
        Node nodes = hashTable[index];
        if(nodes == null){
            System.out.println("Item is not exist");
            return;
        }
        while(nodes !=null && nodes.next !=null){
            if(nodes.next.key.equals(key)){
                nodes.next = nodes.next.next;
                size--;
                return;
            }
            nodes = nodes.next;
        }
    }

    public static void main(String[] args) {
        DynamicHashTable dynamicHashTable = new DynamicHashTable(2);
        dynamicHashTable.put("Self", "Faizal");
        dynamicHashTable.put("Dad", "Afzal");
        dynamicHashTable.put("Mom", "Azmeera");
        dynamicHashTable.put("Wife", "Samiya");
        dynamicHashTable.put("Son", "Faris");
        dynamicHashTable.put("Sister", "Jonefa");
        dynamicHashTable.put("SisterInLaw", "Naziya");
        dynamicHashTable.delete("SisterInLaw");
        System.out.println(dynamicHashTable.get("Self"));
        System.out.println(dynamicHashTable.get("Son"));
        System.out.println(dynamicHashTable.get("Wife"));
        System.out.println(dynamicHashTable.get("Dad"));
        System.out.println(dynamicHashTable.get("Mom"));
        System.out.println(dynamicHashTable.get("Sister"));
        System.out.println(dynamicHashTable.get("SisterInLaw"));
    }
}
