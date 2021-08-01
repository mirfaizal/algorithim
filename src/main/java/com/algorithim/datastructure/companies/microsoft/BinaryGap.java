package com.algorithim.datastructure.companies.microsoft;

public class BinaryGap {
//    A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is
//    surrounded by ones at both ends in the binary representation of N.
//
//    For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
//    The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
//    The number 20 has binary representation 10100 and contains one binary gap of length 1.
//    The number 15 has binary representation 1111 and has no binary gaps.
//    The number 32 has binary representation 100000 and has no binary gaps.
//
//    Write a function:
//
//    class Solution { public int solution(int N); }
//
//    that, given a positive integer N, returns the length of its longest binary gap.
//    The function should return 0 if N doesn't contain a binary gap.
//
//    For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and
//    so its longest binary gap is of length 5. Given N = 32 the function should return 0,
//    because N has binary representation '100000' and thus no binary gaps.
//
//    Write an efficient algorithm for the following assumptions:
//
//    N is an integer within the range [1..2,147,483,647].

    // 15 - 15/2 - 7/2 - 3/2 - 1/2

    public static void main(String[] args) {
        System.out.println(binaryGap(1041));
        System.out.println(binaryGap(32));
        System.out.println(binaryGap(20));
        System.out.println(binaryGap(529));
        System.out.println(binaryGap(9));

    }
    public static int binaryGap(int number) {
        StringBuilder sb = new StringBuilder();
        String binaryString = Integer.toBinaryString(number);
        while(number >= 2){
            int quotient = number / 2;
            int rem = number % 2;
            number = quotient;
            sb.append(rem);
        }
        if(number > 0){
            sb.append(number);
        }
        sb.reverse();
        if(sb.charAt(0) == '0') return 0;
        char [] arr = sb.toString().toCharArray();
        int max =0;
        int countGap = 0;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] == '0') {
                countGap++;
            } else {
                max = Math.max(countGap,max);
                countGap = 0;
            }
        }
        return max;
    }

}
