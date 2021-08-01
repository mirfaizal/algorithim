package com.basicjava.java8;

import java.util.Comparator;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ImperativeVsDeclarative {
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable ");
            }
        };
        new Thread(run).start();

        Runnable runnable = () -> System.out.println("Inside Runnable 1");
        new Thread(runnable).start();
        new Thread(() -> System.out.println("Hello")).start();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(3,2));

        Comparator<Integer> comparatorLambda = ( a,  b) -> a.compareTo(b);
        System.out.println(comparatorLambda.compare(3,2));

        // Consumer Interface
        Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase());
        consumer.accept("Hello");

    }
}
