package com.algorithim.datastructure.stack;

import java.util.*;

public class DailyTemperature {
    public static void main(String[] args) {
        dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        // [73,74,75,71,69,72,76,73]
        // Stack = [(73,7)] , HT = [<73,0>]
        Stack<Pair> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        int [] indexMap = new int[temperatures.length];
        for(int i=temperatures.length - 1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek().temperature <= temperatures[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()){
                map.put(temperatures[i],stack.peek().index-i);
                indexMap[i] = stack.peek().index-i;
            } else {
                map.put(temperatures[i],0);
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
