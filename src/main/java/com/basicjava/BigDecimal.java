package com.basicjava;


import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class BigDecimal {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BigInteger n1 = scan.nextBigInteger();

//        BigInteger n2 = scan.nextBigInteger();
//        BigInteger n3 = n1;
//        BigInteger n4 = n1;
//        n3 =n3.add(n2);
//        n4 =n4.multiply(n2);
//        System.out.println(n3);
//        System.out.println(n4);
        BigInteger n5 = BigInteger.ZERO;
        for(BigInteger big = BigInteger.ZERO; big.compareTo(n1) <= 0 ; big = big.add(BigInteger.ONE)){
            n5 = n5.add(big);
            //System.out.println(n5);
        }
        for(BigInteger big = n1; big.compareTo(BigInteger.ZERO) >= 0 ; big = big.subtract(BigInteger.ONE)){
            n5 = n5.subtract(big);
           // System.out.println(n5);
        }
        if(isPrime(n1)) System.out.println("Prime");
        else System.out.println("Not Prime");
    }

    private static boolean isPrime(BigInteger n1) {
        boolean flag = true;
        BigInteger n6 = n1.divide(BigInteger.TWO);
        if(n6.compareTo(BigInteger.ZERO) == 0 || n6.compareTo(BigInteger.ONE) == 0){
            flag = false;
        } else {
            for (BigInteger big = BigInteger.TWO; big.compareTo(n6) <= 0; big = big.add(BigInteger.ONE)) {
                if (n1.mod(big).compareTo(BigInteger.ZERO) == 0) {

                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
