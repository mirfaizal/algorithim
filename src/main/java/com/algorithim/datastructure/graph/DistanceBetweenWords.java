package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DistanceBetweenWords {
    List<String> words;
    DistanceBetweenWords(List<String> words){
        this.words = words;
    }

    public int distance(String wordOne, String wordTwo) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(wordOne);
        visited.add(wordOne);
        int distance = 0;
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for(int i = 0; i < size ; i++) {
                String parent = queue.poll();
                if(parent.equalsIgnoreCase(wordTwo)) break;
                for(String str : words){
                    if(parent.equalsIgnoreCase(str)) continue;
                    if(!visited.contains(str)) {
                        queue.add(str);
                        visited.add(str);
                    }
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) {
        DistanceBetweenWords distanceBetweenWords = new DistanceBetweenWords(new ArrayList<>(Arrays.asList("the", "quick", "brown", "fox", "quick", "quick")));
        System.out.println(distanceBetweenWords.distance("fox","the"));
        System.out.println(distanceBetweenWords.distance("quick","fox"));
    }
}
