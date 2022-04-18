package com.algorithim.datastructure.array;

public class RingBuffer<T> {
    private int capacity = 0;
    private int size = 0;
    private int head = 0;
    private int tail = -1;
    private final T[] array;
    RingBuffer(int capacity)
    {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }
    public void offer(T element) throws Exception
    {
        if (size == capacity) {
            throw new Exception("Buffer Overflow");
        }
        array[(tail + 1) % capacity] = element;
        size++;
        tail++;
    }
    public T peek() throws Exception
    {
        if (isEmpty()) {
            throw new Exception("Empty Buffer");
        }
        return array[head % capacity];
    }
    public T poll() throws Exception{
        if (isEmpty()) {
            throw new Exception("Empty Buffer");
        }
        T nextValue = array[head % capacity];
        head++;
        size--;
        return nextValue;
    }
    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public static void main(String[] args) throws Exception
    {
        RingBuffer<Integer> cb = new RingBuffer<>(10);
        cb.offer(5);
        cb.offer(6);
        cb.offer(7);
        cb.offer(1);
        cb.offer(4);
        System.out.println("The elements are printed in the order :-");
        System.out.println(cb.poll());
        System.out.println(cb.poll());
        System.out.println(cb.poll());
        System.out.println(cb.poll());
        System.out.println(cb.poll());
        System.out.println(cb.poll());
    }
}