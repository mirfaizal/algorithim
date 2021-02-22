package com.algorithim.datastructure;

public class RunningSum {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n) {
        int count = 0;
        while (n > 0 && count != 100) {
            String number = String.valueOf(n);
            int runningSum = 0;
            for(char c : number.toCharArray()){
                runningSum += Math.pow(Integer.parseInt(String.valueOf(Character.toChars(c))),2);
            }
            if(runningSum == 1) return true;
            n = runningSum;
            count++;
        }
        return false;
    }
}
