package com.algorithim.datastructure.stackqueue;

public class StackUsingArray {
    private int capacity;
    private int stackCapacity;
    private int numberOfStack;
    private int[] size;
    private int[] stack;

    StackUsingArray(int capacity, int numberOfStack) {
        this.capacity = capacity;
        this.numberOfStack = numberOfStack;
        this.stackCapacity = capacity / numberOfStack;
        this.size = new int[numberOfStack];
        this.stack = new int[capacity];
    }

    private boolean isStackFull(int stackNumber) {
        if (stackCapacity == size[stackNumber - 1]) {
            return true;
        }
        return false;
    }

    private void ensureCapacity(int stackNumber) {
        if(!isStackFull(stackNumber)) return;
        int newCapacity = capacity * 3;
        int newStackCapacity = newCapacity / numberOfStack;
        int[] newStack = new int[newCapacity];
        for (int i = 0; i < size.length; i++) {
            int oldIndexOfTopOfStack = indexOfTopOfStack(i+1);
            int index = (newStackCapacity * (i + 1) - newStackCapacity);
            for (int j = stackCapacity * (i+1) - stackCapacity; j < oldIndexOfTopOfStack; j++) {
                newStack[index++] = stack[j];
            }
        }
        this.capacity = newCapacity;
        this.stackCapacity = newStackCapacity;
        this.stack = newStack;
    }
    private int indexOfTopOfStack(int stackNumber){
        return (stackCapacity * stackNumber) - (stackCapacity - size[stackNumber - 1]);
    }
    private void push(int stackNumber, int item){
        ensureCapacity(stackNumber);
        int index = indexOfTopOfStack(stackNumber);
        stack[index] = item;
        size[stackNumber - 1]++;
    }
    private int peek(int stackNumber){
        int index = indexOfTopOfStack(stackNumber);
        return stack[index - 1];
    }
    private int pop(int stackNumber){
        int index = indexOfTopOfStack(stackNumber);
        int item = stack[index - 1];
        stack[index - 1] = 0;
        size[stackNumber - 1]--;
        return item;
    }

    public static void main(String[] args) {
        StackUsingArray stackUsingArray = new StackUsingArray(9,3);
        stackUsingArray.push(1,10);
        stackUsingArray.push(1,20);
        stackUsingArray.push(1,30);
        stackUsingArray.push(2,100);
        stackUsingArray.push(2,200);
        stackUsingArray.push(2,300);
        stackUsingArray.push(2,400);
        stackUsingArray.push(3,1000);
        stackUsingArray.push(3,2000);
        stackUsingArray.push(3,3000);
        stackUsingArray.push(3,4000);
        stackUsingArray.push(3,5000);
        System.out.println(stackUsingArray.peek(1));
        System.out.println(stackUsingArray.peek(2));
        System.out.println(stackUsingArray.peek(3));
        stackUsingArray.pop(1);
        stackUsingArray.pop(2);
        stackUsingArray.pop(3);
        System.out.println(stackUsingArray.peek(1));
        System.out.println(stackUsingArray.peek(2));
        System.out.println(stackUsingArray.peek(3));
    }
}
