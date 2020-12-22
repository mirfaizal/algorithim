package com.algorithim.datastructure.misc;

public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.fizzBuzz(100);
    }

    //Write a short program that prints each number from 1 to 100 on a new line.
    //
    //For each multiple of 3, print "Fizz" instead of the number.
    //
    //For each multiple of 5, print "Buzz" instead of the number.
    //
    //For numbers which are multiples of both 3 and 5, print "FizzBuzz" instead of the number.

    private void fizzBuzz(int number) {
        for(int i =0; i<=number;i++){
            if(i % 3 == 0 && i % 5 == 0 ){
                System.out.println("FizzBuzz");
            }else if(i % 3 == 0 ){
                System.out.println("Fizz");
            }else if(i % 5 == 0 ){
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }
    }
}
