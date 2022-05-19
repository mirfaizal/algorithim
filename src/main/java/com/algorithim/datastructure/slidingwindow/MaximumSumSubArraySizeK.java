package com.algorithim.datastructure.slidingwindow;

/**
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 *
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaximumSumSubArraySizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= arr.length - k; i++){
            int window = 0;
            int windowSum = 0;
            while(window < k){
                windowSum += arr[i + window];
                window++;
            }
            max = Math.max(max, windowSum);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
        System.out.println(findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
    }
}
