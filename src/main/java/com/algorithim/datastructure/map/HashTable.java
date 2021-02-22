package com.algorithim.datastructure.map;

public class HashTable {

    private final int INITIAL_SIZE = 16;

    final class Node {
        private final String key;
        private final String value;
        private final Node next;
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final Node[] data;

    public HashTable(){
        this.data = new Node[INITIAL_SIZE];
    }

    private int getIndex(String key){
        return key.hashCode() & 0x7fffffff % INITIAL_SIZE;
    }

    public void put(String key , String value){
        int index = getIndex(key);
        Node newNode = new Node(key,value);
        if(data[index] == null){
            data[index] = newNode;
        }else {
            Node nodes = data[index];
            while(nodes.next !=null){
                nodes = nodes.next;
            }
            nodes = newNode;
        }
    }

    public String get(String key){
        int index = getIndex(key);
        Node nodes = data[index];
        if(data[index] != null){
            while(!nodes.key.equalsIgnoreCase(key) && nodes.next !=null){
                nodes = nodes.next;
            }
            return nodes.value;
        }
        return null;
    }
}
