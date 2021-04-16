package com.algorithim.datastructure.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

    public static void main(String[] args) {
        number_of_ways(new ArrayList<>(Arrays.asList(1,2,3)),3);
    }

    public static int number_of_ways(List<Integer> coins, int amount) {
        int [] dp = new int [amount + 1];
        dp[0] = 1;
        for(int coin : coins){
        for(int i=1;i<=amount;i++){
                if(i - coin >= 0){
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

}
