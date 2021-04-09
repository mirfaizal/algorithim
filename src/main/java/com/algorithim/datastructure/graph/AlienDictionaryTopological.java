package com.algorithim.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienDictionaryTopological {
    public static void main(String[] args) {
        System.out.println(find_order(new String[] {"eeeeeeeeeeee"}));
    }
    static Map<Character, List<Character>> adjMap = new HashMap<>();
    static Deque<Character> stack = new ArrayDeque<>();
    static Set<Character> visited = new LinkedHashSet<>();
    static int [] departure;
    static int count = 0;
    static String find_order(String[] words) {
        if(words.length == 1) {
            return String.valueOf(words[0].charAt(0));
        }
        boolean flag = false;
        for(int i= 0; i< words.length - 1; i++){
            String previous = words[i];
            String current = words[i+1];
            int minLength = Math.min(previous.length(), current.length());
            for(int j=0;j<minLength;j++){
                char prevC = previous.charAt(j);
                char currC = current.charAt(j);
                if(prevC != currC) {
                    flag = true;
                    adjMap.computeIfAbsent(prevC, k -> new ArrayList<>());
                    adjMap.get(prevC).add(currC);
                    break;
                }
            }
        }
        if(!flag && adjMap.size() ==0) return words[0];
        departure = new int[200];
        Arrays.fill(departure,-1);
        for(Map.Entry<Character,List<Character>> entry : adjMap.entrySet()){
            char key = entry.getKey();
            if(!visited.contains(key)){
                dfs(key);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }


    private static boolean dfs(char node){
        visited.add(node);
        if(adjMap.get(node) !=null)
        for(char neighbour :  adjMap.get(node)){
            if(!visited.contains(neighbour)){
               if(dfs(neighbour)) return true;
            } else if(departure[neighbour] == -1) return true;
        }
        stack.push(node);
        departure[node] = count++;
        return false;
    }
}
