package com.algorithim.datastructure.companies.microsoft;

import java.util.Arrays;

class Solution {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        if(A[A.length - 1] < 0) return 1;
        int i = 1;
        while((A[i-1] != A[i]  || A[i-1] + 1 != A[i]) && i < A.length - 1){
            if(A[i-1] == A[i]) i++;
            if(A[i-1] + 1 == A[i]) i++;
        }
        if(A[i-1] + 1 == A[i]) {
            return A[i] + 1;
        } else {
            return A[i-1] + 1;
        }
    }

    public int solution(int A, int B, int K) {
        return (int) (Math.floor(B/K) - Math.floor((A-1)/K));
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,1,6}));
        System.out.println(solution(new int[]{-1,-2}));
        System.out.println(solution(new int[]{1,2,3,9}));
    }
}
