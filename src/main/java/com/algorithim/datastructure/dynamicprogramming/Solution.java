package com.algorithim.datastructure.dynamicprogramming;

class Solution {
    public static boolean isInterleave(String s1, String s2, String s3) {
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for(int i=1; i<=s1.length(); i++) dp[i][0] = (s3.charAt(i-1) ==  s1.charAt(i-1));
        for(int j=1; j<=s2.length(); j++) dp[0][j] = (s3.charAt(j-1) ==  s2.charAt(j-1));
        for(int i =1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                dp[i][j] = (s1.charAt(i-1) == s3.charAt(j+i-1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(j+i-1) && dp[i][j-1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Using two pointer approach
        m = m - 1;
        n = n - 1;
        int index = nums1.length - 1;
        while(m >= 0 || n >= 0){
            if(m >= 0 && n >= 0){
                if(nums1[m] > nums2[n]){
                    nums1[index--] = nums1[m--];
                } else {
                    nums1[index--] = nums2[n--];
                }
            } else if(m >= 0) {
                nums1[index--] = nums1[m--];
            } else if(n >= 0) {
                nums1[index--] = nums2[n--];
            }
        }
    }

    public static int pivotIndex(int[] nums) {

            // 2 pointer approach
            int i = 0, j= nums.length - 1;
            int leftSum = nums[0];
            int rightSum = nums[j];
            int count = 2;
            while(i<j){
                if(leftSum == rightSum && !(count < nums.length)) {
                    if(i+1 == j) return -1;
                    else if(i<j) return i + 1;
                } else if(leftSum < rightSum){
                    leftSum += nums[++i];
                } else {
                    rightSum += nums[--j];
                }
                count++;
            }
            return 0;
    }

    public static int fib(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<n+1;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        isInterleave("AAB","AAC","AAABAC");



        //fib(2);
        //pivotIndex(new int[]{-1,-1,-1,-1,-1,-1});
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
}
