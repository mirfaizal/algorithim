package com.algorithim.datastructure.recursion;

import java.util.ArrayList;
import java.util.List;

public class Factor {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {
        List<Integer> input = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                input.add(i);
            }
        }
        helper(input, 0, n, 1, new ArrayList<>());
        return result;
    }

    private void helper(List<Integer> input, int index, int target, int sum, List<Integer> slate) {
        // Base Case
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(slate));
            return;
        }
        if (index == input.size()) {
            return;
        }
        for (int i = index; i < input.size(); i++) {
            slate.add(input.get(i));
            helper(input, index + 1, target, sum * input.get(i), slate);
            slate.remove(slate.size() - 1);
        }
    }

    public static void main(String[] args) {
        Factor t = new Factor();
        System.out.println(t.getFactors(12));
    }
}
