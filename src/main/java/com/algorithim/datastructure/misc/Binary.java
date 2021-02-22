package com.algorithim.datastructure.misc;

import java.math.BigInteger;
import java.util.Scanner;

public class Binary {

    public static void main(String[] args) {
//        solution("011100");
//        solution("111");
//        solution("1111010101111");

//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<400000;i++){
//            sb.append("1");
//        }
//        solution(sb.toString());
        Scanner scan = new Scanner(System.in);
        BigInteger n1 = scan.nextBigInteger();
        BigInteger n2 = scan.nextBigInteger();
        BigInteger n3 = n1;
        BigInteger n4 = n1;
        n3 = n3.add(n2);
        n4 = n4.multiply(n2);
        System.out.println(n3.toString());
        System.out.println(n4.toString());
    }

    public static int solution(String S) {
        int count = 0;
        if(S != null) {
            // Read the string and convert into number
            Scanner scan = new Scanner(System.in);
            scan.nextBigInteger();
            BigInteger number = new BigInteger("0");

            //long number = 0;
            int index = 0;
            for(int i =S.length() - 1 ;i >= 0; i--){
                long n = Integer.valueOf(String.valueOf(S.charAt(i)));
                BigInteger pow = new BigInteger(String.valueOf(2));
                pow = pow.pow(index);
                if(n == 1) number = number.add(pow);
                index++;
            }
            BigInteger zero = new BigInteger("0");
            while(number.compareTo(zero) > 0){
                if(number.mod(BigInteger.valueOf(2)).compareTo(zero) == 0){
                    number = number.divide(BigInteger.valueOf(2));
                }else{
                    number = number.subtract(BigInteger.valueOf(1));
                }
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
}
