package com.algorithim.datastructure.heap;

import java.util.Collections;

public class BinaryHeap {
    private int capacity;
    private int size = 0;
    private int[] heap;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    private int getLeftChildIndex(int parent) {
        return parent * 2 + 1;
    }

    private int getRightChildIndex(int parent) {
        return parent * 2 + 2;
    }

    private int getParentIndex(int child) {
        return (child - 1) / 2;
    }

    private boolean hasLeftChild(int parent) {
        return getLeftChildIndex(parent) < 0;
    }

    private boolean hasRightChild(int parent) {
        return getRightChildIndex(parent) < 0;
    }

    private boolean hasParent(int child) {
        return getParentIndex(child) >= 0;
    }

    private int parent(int child) {
        return heap[getParentIndex(child)];
    }

    private int leftChild(int parent) {
        return heap[getLeftChildIndex(parent)];
    }

    private int rightChild(int parent) {
        return heap[getRightChildIndex(parent)];
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            int newCapacity = this.capacity * 2;
            int[] newHeap = new int[newCapacity];
            for (int i = 0; i < capacity; i++) {
                newHeap[i] = heap[i];
            }
            this.capacity = newCapacity;
            this.heap = newHeap;
        }
    }

    private void offer(int data) {
        ensureCapacity();
        heap[size] = data;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) < heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private int poll() throws IllegalAccessException {
        if (size == 0) {
            throw new IllegalAccessException();
        }
        int data = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = 0; // mark last node 0 as deleted
        size--;
        heapifyDown();
        return data;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int biggestChild = getLeftChildIndex(index);
            if (hasRightChild(index) && leftChild(index) < rightChild(index)) {
                biggestChild = getRightChildIndex(index);
            }
            if (heap[biggestChild] < heap[index]) {
                break;
            } else {
                swap(biggestChild, index);
            }
            index = biggestChild;
        }
    }

    private void print(){
        for(int i=0;i<size;i++){
            System.out.println(i+" : "+heap[i]);
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        BinaryHeap binaryHeap = new BinaryHeap(10);
        binaryHeap.offer(90);
        binaryHeap.offer(80);
        binaryHeap.offer(10);
        binaryHeap.offer(20);
        binaryHeap.offer(50);
        binaryHeap.offer(100);
        binaryHeap.offer(1000);
        binaryHeap.print();
        binaryHeap.poll();
        binaryHeap.print();
    }
}
