package com.algorithim.datastructure.sorting;

import java.util.Arrays;

public class BinaryMaxHeap {
    private int capacity = 10;
    private int size = 0;
    private int [] array = new int[capacity];
    private int getLeftChildIndex(int parentIndex) {  return parentIndex * 2 + 1; }
    private int getRightChildIndex(int parentIndex) {  return parentIndex * 2 + 2; }
    private int getParentIndex(int childIndex) {  return (childIndex - 1 ) / 2; }
    private boolean hasLeftChild(int parentIndex){ return getLeftChildIndex(parentIndex) < size; }
    private boolean hasRightChild(int parentIndex){ return getRightChildIndex(parentIndex) < size; }
    private boolean hasParent(int childIndex){ return getParentIndex(childIndex) >= 0; }
    private int leftChild(int parentIndex){ return array[getLeftChildIndex(parentIndex)];}
    private int rightChild(int parentIndex){ return array[getRightChildIndex(parentIndex)];}
    private int parent(int childIndex){ return array[getParentIndex(childIndex)];}
    private void swap(int indexOne, int indexTwo){
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
    private void ensureCapacity() {
        if(size == capacity){
            array = Arrays.copyOf(array, capacity * 2);
//            int newArray [] = new int[capacity * 2];
//            for(int i=0;i<array.length;i++){
//                newArray[i] = array[i];
//            }
            capacity = capacity * 2;
        }
    }
    public int peek() throws IllegalAccessException {
        if(size == 0) {
            throw new IllegalAccessException();
        }
        return array[0];
    }
    public void insertItem(int item){
        ensureCapacity();
        array[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && parent(index) < array[index]){
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }

    public int poll() throws IllegalAccessException {
        if(size == 0) {
            throw new IllegalAccessException();
        }
        int item = array[0];
        array[0] = array[size - 1];
        size --;
        heapifydown();
        return item;
    }

    private void heapifydown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int biggestChild = getLeftChildIndex(index);
            if (hasRightChild(index) && leftChild(index) < rightChild(index)) {
                biggestChild = getRightChildIndex(index);
            }
            if(array[biggestChild] < array[index]){
                break;
            }else {
                swap(biggestChild,index);
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
