package com.algorithim.datastructure.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCutting {
    public static void main(String[] args) {
        get_maximum_profit(new ArrayList<>(Arrays.asList(1,5,8,9)));
    }
    static int get_maximum_profit(List<Integer> price) {
        int [] dp = new int[price.size() + 1];
        dp[0] = 1;
        for(int i=1;i<=dp.length;i++){
            for(int p : price){
                if(i-p>=0)
                dp[i] = p + Math.max(dp[i],dp[i-p]);
            }
        }
        return dp[price.size()];
    }
}
