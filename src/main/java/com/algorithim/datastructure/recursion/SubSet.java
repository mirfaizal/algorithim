package com.algorithim.datastructure.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
//    Given an integer array nums of unique elements, return all possible subsets (the power set).
//    The solution set must not contain duplicate subsets. Return the solution in any order.
//    Example 1:
//    Input: nums = [1,2,3]
//    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//    Example 2:
//    Input: nums = [0]
//    Output: [[],[0]]

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1,2,3});
        for(List<Integer> list : subsets) {
            for (Integer i : list) System.out.print(i + " ");
            System.out.println();
        }
    }
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0 , new ArrayList<>());
        return result;
    }
    private static void subsets(int[] problemDef, int index, List<Integer> slate) {
        // Base Case
        if(index == problemDef.length) {
            result.add(new ArrayList<>(slate));
            return;
        }
        // Recursive Case
        // Exclude Case
        subsets(problemDef,index + 1, slate);
        // Include Case
        slate.add(problemDef[index]);
        subsets(problemDef,index + 1, slate);
        slate.remove(slate.size() - 1);
    }
}
