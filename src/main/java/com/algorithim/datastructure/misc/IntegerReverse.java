package com.algorithim.datastructure.misc;

public class IntegerReverse {
    public static void main(String[] args) {
        IntegerReverse integerReverse = new IntegerReverse();
        //System.out.println(integerReverse.reverse(123456));
        permutation("abc");
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
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
