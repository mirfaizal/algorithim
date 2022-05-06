package com.algorithim.datastructure.basic;

public class ArrayImplementationOfQueue<T> {
    static class QueueNode<T> {
        T value;
        QueueNode(T value){
            this.value = value;
        }
    }
    private QueueNode<T> [] queue;
    private int capacity;
    private int last;
    private int first;
    ArrayImplementationOfQueue(int capacity){
        queue = new QueueNode[capacity];
        first = 0;
        last = 0;
    }

    public void add(T item){
        if(capacity == queue.length){
            System.out.println("Queue Full");
            return;
        }
        queue[last++] = (QueueNode<T>) item;
        capacity++;
    }

    public T peek(){
        if(queue.length == 0){
            System.out.println("Queue Empty");
            return null;
        }
        QueueNode<T> item = queue[first];
        return item.value;
    }

    public T pool(){
        return null;
    }


}
