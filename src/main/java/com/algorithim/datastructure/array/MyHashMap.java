package com.algorithim.datastructure.array;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;



class Node<K, V> {
    @Getter
    private final K key;
    @Setter
    @Getter
    private V value;
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    private final List<Node> entries;
    public Bucket() {
        entries = new LinkedList<>();
    }
    public List<Node> getEntries() {
        return entries;
    }
    public void addEntry(Node entry) {
        this.entries.add(entry);
    }
    public void removeEntry(Node entry) {
        this.entries.remove(entry);
    }
}

public class MyHashMap<K, V> {
    private final int CAPACITY = 10;
    private final Bucket[] bucket;
    private int size = 0;
    public MyHashMap() {
        this.bucket = new Bucket[CAPACITY];
    }
    private int getHash(K key) {
        return (key.hashCode() & 0xfffffff) % CAPACITY;
    }
    private Node getEntry(K key) {
        int hash = getHash(key);
        for (int i = 0; i < bucket[hash].getEntries().size(); i++) {
            Node myKeyValueEntry = bucket[hash].getEntries().get(i);
            if (myKeyValueEntry.getKey().equals(key)) {
                return myKeyValueEntry;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (containsKey(key)) {
            Node entry = getEntry(key);
            entry.setValue(value);
        } else {
            int hash = getHash(key);
            if (bucket[hash] == null) {
                bucket[hash] = new Bucket();
            }
            bucket[hash].addEntry(new Node<>(key, value));
            size++;
        }
    }

    public V get(K key) {
        return containsKey(key) ? (V) getEntry(key).getValue() : null;
    }

    public boolean containsKey(K key) {
        int hash = getHash(key);
        return !(Objects.isNull(bucket[hash]) || Objects.isNull(getEntry(key)));
    }

    public void delete(K key) {
        if (containsKey(key)) {
            int hash = getHash(key);
            bucket[hash].removeEntry(getEntry(key));
            size--;
        }
    }

    public int size() {
        return size;
    }


    public static void main(String[] args) {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        map.put(2, 1);
        System.out.println(map.get(2));
        map.delete(2);
        System.out.println(map.get(2));
    }
}
