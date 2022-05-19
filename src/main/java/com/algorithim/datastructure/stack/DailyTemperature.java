package com.algorithim.datastructure.stack;

import java.util.*;

/**

 739. Daily Temperatures

 Given an array of integers temperatures represents the daily temperatures,
 return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 If there is no future day for which this is possible, keep answer[i] == 0 instead.

 Example 1:

 Input: temperatures = [73,74,75,71,69,72,76,73]
 Output: [1,1,4,2,1,1,0,0]
 Example 2:

 Input: temperatures = [30,40,50,60]
 Output: [1,1,1,0]
 Example 3:

 Input: temperatures = [30,60,90]
 Output: [1,1,0]

 */

// Input: temperatures = [73,74,75,71,69,72,76,73] , Since I have find next warmer day which is next biggest
// Traverse array R->L and use Monotonic Stack to determine warmer temp
// i = 7, Stack = [(73,7)] , HT = [<73,0>]
// i = 6, Stack = [(76,6)] , HT = [<73,0>, <76,0>]
// i = 5, Stack = [(76,6),(72,5)] , HT = [<72,6-5>] = [<72,1>]
// i = 4, Stack = [(76,6),(72,5)] , HT = [<72,6-5>] = [<72,1>]
// i = 7, Stack = [73] , HT = [<73,0>]
// i = 7, Stack = [73] , HT = [<73,0>]
// i = 7, Stack = [73] , HT = [<73,0>]
// Output: [1,1,4,2,1,1,0,0]

public class DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int [] indexMap = new int[temperatures.length];
        for(int i=temperatures.length - 1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek().temperature <= temperatures[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()){
                indexMap[i] = stack.peek().index-i;
            } else {
                indexMap[i] = 0;
            }
            stack.push(new Pair(temperatures[i],i));
        }
        return indexMap;
    }

    static class Pair {
        int temperature;
        int index;

        Pair(int temperature, int index) {
            this.temperature = temperature;
            this.index = index;
        }
    }

}
