package com.algorithim.datastructure.sorting;

import java.util.Arrays;

public class HeapSort {
    private int capacity = 5;
    private int [] array = new int[capacity];
    private int size = 0;
    private int getParentIndex(int index) { return ( index - 1 ) / 2;}
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }
    private int getParent(int index) { return array[getParentIndex(index)];}
    private int getLeftChildIndex(int index) { return (index * 2) + 1;}
    private int getLeftChild(int index) { return array[getLeftChildIndex(index)];}
    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size;}
    private int getRightChildIndex(int index) { return (index * 2) + 2;}
    private int getRightChild(int index) { return array[getRightChildIndex(index)];}
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size;}
    private void ensureCapacity(){
        if(capacity == size){
            array = Arrays.copyOf(array,capacity*2);
            capacity = capacity * 2;
        }
    }
    private void swap(int one, int two){
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
    public void insert(int item){
        ensureCapacity();
        array[size] = item;
        size++;
        heapifyUp();
    }
    private void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && getParent(index) < array[index]) {
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }
    public int extract(){
        int item = array[0];
        array[0] = array[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)){
            int biggestChild = getLeftChildIndex(index);
            if(hasRightChild(index) && getLeftChild(index) < getRightChild(index)){
                biggestChild = getRightChildIndex(index);
            }
            if(array[biggestChild] > array[index]){
                swap(biggestChild,index);
            } else {
                break;
            }
            index = biggestChild;
        }
    }
    public void printArray(){
        for(int i=0;i<size ;i++){
            System.out.println("array["+i+"] : "+array[i]);
        }
        System.out.println("----------------------");
    }
}
