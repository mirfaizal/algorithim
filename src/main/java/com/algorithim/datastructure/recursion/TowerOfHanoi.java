package com.algorithim.datastructure.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowerOfHanoi {

    public static void main(String[] args) {
        tower_of_hanoi(2);
    }

    static List<List<Integer>> result = new ArrayList<>();
    private static List<List<Integer>> tower_of_hanoi(Integer n) {
        helper(n,1,3,2);
        return result;
    }

    private static void helper(Integer n, int source,  int destination ,int aux) {
        if(n == 1){
            result.add(new ArrayList<>(Arrays.asList(source,destination)));
            return;
        }
        helper(n-1,source,aux,destination);
        result.add(new ArrayList<>(Arrays.asList(source,destination)));
        helper(n-1,aux,destination,source);
    }
}
