package com.algorithim.datastructure.recursion;

import java.util.*;

public class PermutationSequence  {
    public static void main(String[] args) {

//        System.out.println(getPermutation(3,1));
//        System.out.println(getPermutation(3,2));
//        System.out.println(getPermutation(3,3));
//        System.out.println(getPermutation(3,4));
        System.out.println(getPermutation(3,5));
        System.out.println(getPermutation(3,6));
    }
    static String result;
    static boolean found;
    static int [] count = new int[1];
    public static String getPermutation(int n, int k) {
        count[0] = 0;
        found = false;
        result = null;
        int [] arr = new int[n];
        int index = 0;
        for(int i=1;i<=n;i++) arr[index++] =i;
        helper(arr,0,new StringBuilder(),k);
        return result;
    }
    private static void helper(int [] arr, int index, StringBuilder slate, int k){
        // Backtrack Case
        if(found) return;
        if(k-1 == count[0] && slate.length() == arr.length) {
            result = slate.toString();
            found = true;
            return;
        }
        // Base Case
        if(index == arr.length) {count[0]++;return;}
        // Recursion
        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            slate.append(arr[index]);
            helper(arr,index+1,slate,k);
            slate.setLength(slate.length() - 1);
            swap(arr,i,index);
        }
    }
    private static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

//    The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
//
//    By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//
//    "123"
//    "132"
//    "213"
//    "231"
//    "312"
//    "321"
//    Given n and k, return the kth permutation sequence.
//
//
//
//    Example 1:
//
//    Input: n = 3, k = 3
//    Output: "213"

// n = 3, k = 3
// [1,2,3]
// //                    o
//                  /    |   \
//                1--   2--   3--
//              /  \   / \     / \
//           12_  13_ 21_ 23_  31_  32_
//            |    |   |   |   |     |
//          123   132 213 231 312   321
// Time - O(n!)
// Space - O(n!)