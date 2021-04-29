package com.algorithim.datastructure.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
//    Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//    Example 1:
//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//    Example 2:
//    Input: nums = [0,1]
//    Output: [[0,1],[1,0]]
//    Example 3:
//    Input: nums = [1]
//    Output: [[1]]

    public static void main(String[] args) {
        List<List<Integer>> subsets = permute(new int[]{1,2,3,3});
        for(List<Integer> list : subsets) {
            for (Integer i : list) System.out.print(i + " ");
            System.out.println();
        }
    }
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        permute(nums,0,new ArrayList<>());
        return result;
    }
    private static void permute(int[] problemDef, int index, List<Integer> slate) {
        //Base Case
        if(index == problemDef.length){
            result.add(new ArrayList<>(slate));
            return;
        }
        // Recursive Case
        Set<Integer> set = new HashSet<>();
        for(int i = index; i < problemDef.length; i++){
            if(set.contains(problemDef[i])) continue;
            swap(problemDef, i , index);
            slate.add(problemDef[index]);
            permute(problemDef,index + 1, slate);
            slate.remove(slate.size() - 1);
            swap(problemDef, i , index);
            set.add(problemDef[i]);
        }
    }
    private static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
