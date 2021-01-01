package com.algorithim.datastructure.array;

public class DynamicArray {
    private int capacity;
    private int size;
    private Object [] array;
    DynamicArray(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }
    private Object get(int index){
        if(index < -1 || index >= capacity) throw new ArrayIndexOutOfBoundsException("Item is not present");
        return array[index];
    }

    private void set(int index, Object data){
        if(index < -1 || index >= capacity) throw new ArrayIndexOutOfBoundsException("Position is not present in array");
        array[index] = data;
    }

    private void insert(int index, Object data){
        // Resize
        if(size == capacity){
            resize();
        }
        // Copy Array
        for(int i= size; i>index; i--){
            array[i] = array[i-1];
        }
        // Insert
        array[index] = data;
        size++;
    }

    private Object delete(int index){
        if(index < -1 || index >= capacity) throw new ArrayIndexOutOfBoundsException("Position is not present in array");
        Object data = array[index];
        for(int i=index; i<size; i++){
            array[i] = array[i+1];
        }
        array[size - 1] = null;
        size --;
        return data;

    }

    private void resize() {
        capacity = capacity * 2;
        Object [] newArray = new Object[capacity];
        for(int i=0;i<size;i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(2);
        dynamicArray.insert(0,"Faizal");
        dynamicArray.insert(1,1983);
        dynamicArray.insert(2,1234.56);
        dynamicArray.insert(3,false);
        System.out.println(dynamicArray.get(2));
        System.out.println(dynamicArray.delete(2));
        System.out.println(dynamicArray.get(2));
    }
}
