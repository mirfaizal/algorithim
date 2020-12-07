package com.algorithim.misc;

import java.io.InputStream;

public class IntegerReverse {
    public static void main(String[] args) {
        IntegerReverse integerReverse = new IntegerReverse();
        System.out.println(integerReverse.reverse(123456));

    }

    private int reverse(int number) {
        int rem = 0;
        int reverse = 0 ;
        while(number > 0){
            rem = number % 10;
            number = number / 10;
            reverse = reverse * 10 + rem;
        }
        return reverse;
    }
}
