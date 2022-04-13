package com.algorithim.datastructure.array;

public class Prime {
    public static void main(String[] args) {
        checkPrime(17);
       // checkPrime(1,2,3,4,5,6,7,8,9,11,12,13,14);
    }
    static void checkPrime( int ...array){
        for(int i: array){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
    static boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i =2; i<n/2;i++)
            if(n%i == 0) return false;
        return true;
    }
}
