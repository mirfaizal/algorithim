package com.algorithim.datastructure.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
Objective: Given a number, find out whether its colorful or not.
Colorful Number: When in a given number, product of every digit of a sub-sequence are different. That number is called Colorful Number. See Example

Example:

Given Number : 3245
Output : Colorful
Number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
this number is a colorful number, since product of every digit of a sub-sequence are different.
That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20, (3*2*4)= 24 (2*4*5)= 40

Given Number : 326
Output : Not Colorful.
326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12.
*/

public class ColorfulNumber {

    static String colorfulNumber(int number){
        int [] array = createIntegerArray(number);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i < array.length; i++ ){
            if(map.get(array[i])!=null){
                return "Not Colorful";
            }else map.put(array[i], 1);
            int product = array[i];
            for(int j=i+1;j< array.length;j++){
                product *= array[j];
                if(map.get(product)!=null){
                    return "Not Colorful";
                }else map.put(product, 1);
            }
        }
        return "Colorful";
    }

    private static int[] createIntegerArray(int number) {
        int length = String.valueOf(number).length();
        int index = 0;
        int [] array = new int[length];
        int [] reversedArray = new int[length];
        while (index < length){
            int rem = number % 10;
            number = number / 10;
            array[index] = rem;
            index++;
        }
        index = 0;
        for(int i=length-1;i>=0;i--){
            reversedArray[index++] = array[i];
        }
        return reversedArray;
    }

    public static void main(String[] args) {
        System.out.println(colorfulNumber(13345));
        System.out.println(colorfulNumber(326));
    }
}
