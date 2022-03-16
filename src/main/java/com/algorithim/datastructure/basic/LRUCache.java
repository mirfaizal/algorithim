package com.algorithim.datastructure.basic;

import java.util.*;

class DList {
    int val;
    int key;
    DList next;
    DList prev;
    DList( int key, int val){
        this.val = val;
        this.key = key;
        this.next = null;
        this.prev = null;
    }
    DList(){

    }
}

public class LRUCache {
    DList head = new DList();
    DList tail = new DList();
    Map<Integer, DList> map_cache;
    int capacity;
    LRUCache(int capacity){
        this.capacity = capacity;
        this.map_cache = new HashMap<>(capacity);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void add(DList node){
        DList temp = head.next;
        temp.prev = node;
        head.next = node;
        node.prev = head;
        node.next = temp;
    }
    public void remove(DList node){
        DList node_next = node.next;
        DList node_prev = node.prev;
        node_next.prev = node_prev;
        if(node_prev != null){
            node_prev.next = node_next;
        }
    }
    public int get(int key) {
        int result = -1;
        DList node = this.map_cache.get(key);
        if(node != null){
            remove(node);
            add(node);
            result =node.val;
        }
        System.out.println(result);
        return result;
    }
    public void put(int key, int value) {
        DList node = this.map_cache.get(key);
        if(node != null){
            // Node exist, and we need to update, since we are updating we need remove and add again to make it recently used
            remove(node);
            node.val = value;
            add(node);
        } else {
            if(capacity == this.map_cache.size()){
                this.map_cache.remove(this.tail.prev.prev.key);
                remove(this.tail.prev.prev);
            }
            DList new_node = new DList(key, value);
            map_cache.put(key, new_node);
            add(new_node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
        System.out.println();
    }

}
