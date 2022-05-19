package com.algorithim.datastructure.stackqueue;

public class CircularQueueArrayImpl {
    int capacity;
    int [] queue;
    int front;
    int rear;
    int size = 0;
    CircularQueueArrayImpl(int capacity){
        this.capacity = capacity;
        this.queue = new int[this.capacity];
        front = -1;
        rear = -1;
    }
    public void offer(int item){
        if(front == -1 && rear == -1){
            front = 0;
            rear = 0;
            queue[rear] = item;
            size++;
        }
        else if((rear + 1) % capacity == front){
            System.out.println("Queue is full");
        }
        else {
            rear = (rear + 1) % capacity;
            queue[rear] = item;
            size++;
        }
    }
    public int remove(){
        int item = -1;
        if(front == -1 && rear == -1){
            System.out.println("Queue is empty");
        } else if(front == rear){
            item = queue[front];
            front = -1 ;
            rear = -1;
        } else {
            item = queue[front];
            queue[front] = 0;
            front = (front + 1) % capacity;
            size--;
        }
        System.out.println("Item removed : "+item);
        return item;
    }
    public int peek(){
        if((front + 1)% capacity == rear){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public int size(){
        System.out.println("Size : "+ size);
        return size;
    }
    public void print(){
        if(front == -1 && rear == -1){
            System.out.println("Queue is empty");
            return;
        }
        int i = front ;
        System.out.print(queue[i]+" ");
        while(i != rear){
            i = (i + 1) % capacity;
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueueArrayImpl circularQueue = new CircularQueueArrayImpl(4);
        circularQueue.print();
        circularQueue.offer(1);
        circularQueue.print();
        circularQueue.offer(2);
        circularQueue.print();
        circularQueue.offer(3);
        circularQueue.print();
        circularQueue.offer(4);
        circularQueue.print();
        circularQueue.offer(5);
        circularQueue.size();
        circularQueue.print();
        circularQueue.remove();
        circularQueue.print();
        circularQueue.offer(5);
        circularQueue.print();
        circularQueue.remove();
        circularQueue.print();
        circularQueue.remove();
        circularQueue.print();
        circularQueue.remove();
        circularQueue.print();
        circularQueue.remove();
        circularQueue.print();
        circularQueue.remove();
        circularQueue.print();
        circularQueue.remove();
        circularQueue.print();

    }
}
