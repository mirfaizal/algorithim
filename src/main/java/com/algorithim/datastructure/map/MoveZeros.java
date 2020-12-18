package com.algorithim.datastructure.map;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int [] array = new int[]{4,2,4,0,0,3,0,5,1,0};
        moveZeros.moveZeroes(array);
        for (int n : array){
            System.out.println(n);
        }
    }

    public void moveZeroes(int[] nums) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for(int i =0; i< nums.length; i++) {
            if(map.containsKey(nums[i])) {
                Integer value = map.get(nums[i]);
                map.put(nums[i], value + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int numberOfZeros = 0;
        int i = 0;
        boolean hasZero = map.containsKey(0);
        if(hasZero) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() == 0) {
                    numberOfZeros = entry.getValue();
                } else {
                    int count = entry.getValue();
                    while (count > 0) {
                        nums[i++] = entry.getKey();
                        count--;
                    }
                }
            }
            while (numberOfZeros > 0) {
                nums[i++] = 0;
                numberOfZeros--;
            }
        }
    }
}
