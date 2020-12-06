package com.algorithim.datastructure.sorting;

public class BinaryMinHeap {
    private int capacity = 10;
    private int size = 0;
    private int [] array = new int[capacity];
    private int getParentIndex(int childIndex){ return (childIndex - 1 )/ 2; }
    private int getLeftChildIndex(int childIndex){ return (childIndex * 2 ) + 1; }
    private int getRightChildIndex(int childIndex){ return (childIndex * 2 ) + 2; }
    private boolean hasParent(int childIndex){ return getParentIndex(childIndex) >= 0; }
    private boolean hasLeftChild(int parentIndex){ return getLeftChildIndex(parentIndex) < size; }
    private boolean hasRightChild(int parentIndex){ return getRightChildIndex(parentIndex) < size; }
    private int parent(int childIndex) { return array[getParentIndex(childIndex)];}
    private int leftChild(int parentIndex) { return array[getLeftChildIndex(parentIndex)];}
    private int rightChild(int parentIndex) { return array[getRightChildIndex(parentIndex)];}
    private void ensureCapacity(){
        if(size == capacity){
            capacity = capacity * 2;
            // array = Arrays.copyOf(array,capacity);
            int[] newArray = new int[capacity];
            for(int i = 0; i < array.length ; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }
    private void swap(int indexOne, int indexTwo){
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    public void insertItem(int value){
        ensureCapacity();
        array[size] = value;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && parent(index) >  array[index]){
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }

    public int poll(){
        if(size == 0){
            throw new IllegalArgumentException();
        }
        int item = array[0];
        array[0] = array[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)){
            int smallestChild = getLeftChildIndex(index);
            if(hasRightChild(index) && leftChild(index) > rightChild(index)){
                smallestChild = getRightChildIndex(index);
            }
            if(array[index] < array[smallestChild]){
                break;
            }else{
                swap(smallestChild, index);
                index = smallestChild;
            }
        }
    }

    public void printArray(){
        for(int i=0;i<size ;i++){
            System.out.println("array["+i+"] : "+array[i]);
        }
        System.out.println("----------------------");
    }
}
