package com.algorithim.datastructure.stack;

import java.util.*;

public class DailyTemperature {
    public static void main(String[] args) {
        dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
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
