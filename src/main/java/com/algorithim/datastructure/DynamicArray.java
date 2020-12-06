package com.algorithim.datastructure;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicArray {

    private int capacity;
    private Object array[];
    private int size;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public Object get(int index) {
        return array[index];
    }

    public void set(int index, Object value) {
        if(index < capacity){
            array[index] = value;
        }else{
            throw new IndexOutOfBoundsException("Index Too big");
        }

    }

    public void add(Object value) {
        // Check Size if array full , double the array
        if (size == capacity) {
            resize();
        }
        // Insert Value and increment size of the array
        array[size++] = value;
    }

    private void resize() {
        int doubleCapacity = capacity * 2;
        Object doubleArray[] = new Object[doubleCapacity];
        for (int i = 0; i < capacity; i++) {
            doubleArray[i] = array[i];
        }
        capacity = doubleCapacity;
        array = doubleArray;
    }

    public void insert(int index, Object value) {
        // Check Size if array full , double the array
        if (size == capacity) {
            resize();
        }
        // Copy array and create a space
        for (int i = size; i > index; i--) {
            array[i] = array[i-1];
        }

        // Insert
        array[index] = value;
        size++;
    }

    public void delete(int index){

        for(int i=index; i<size-1; i++){
            array[i] = array[i+1];
        }

        array[ size - 1 ] = null;
        size--;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Object value){
        for(int i=0;i<size;i++){
            Object obj = get(i);
            if(value.equals(obj)){
                return true;
            }
        }
        return false;
    }
}

