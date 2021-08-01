package com.basicjava.java8.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Synchronization {

    static int count = 0;

    static int getCount(){
        return count;
    }

    static  void increment(){
        for(int i=1;i<=1000;i++) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(Synchronization::increment);
        Thread thread2 = new Thread(Synchronization::increment);
        AtomicInteger ai = new AtomicInteger();
        ai.addAndGet(12);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(getCount());
    }
}
