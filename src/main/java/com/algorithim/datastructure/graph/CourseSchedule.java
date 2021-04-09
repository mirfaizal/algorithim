package com.algorithim.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule {

//            9 8
//            0 5
//            6 3
//            3 7
//            5 1
//            5 4
//            6 2
//            6 8
//            7 6


    //Input: n = 4, a = [1, 1, 3], b = [0, 2, 1]

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(3);
        List<Integer> b = new ArrayList<>();
        b.add(0);
        b.add(2);
        b.add(1);
        System.out.println(can_be_completed(4,a,b));
    }

    private static List<Integer>[] adjList;
    private static Set<Integer> visited = new LinkedHashSet<>();
    private static int [] arrivalTime;
    private static int [] departureTime;
    private static int count = 0;
    private static int [] parent;
    private static Deque<Integer> topologicalSort = new ArrayDeque<>();
    public static boolean can_be_completed(int n, List<Integer> a, List<Integer> b) {
        adjList = new LinkedList[n];
        arrivalTime = new int[n];
        departureTime = new int[n];
        parent = new int[n];
        Arrays.fill(parent,-1);
        Arrays.fill(departureTime,-1);
        Arrays.fill(arrivalTime,-1);
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        for(int i=0;i<a.size();i++){
            adjList[a.get(i)].add(b.get(i));
        }
        for(int i=0;i<n;i++) {
            if(!visited.contains(i)){
                if(dfs(i)) return false;
            }
        }
        while(!topologicalSort.isEmpty())
            System.out.println(topologicalSort.pop());
        return true;
    }
    private static boolean dfs(int node){
        arrivalTime[node] = count++;
        visited.add(node);
        for(int neighbour : adjList[node]){
            if(!visited.contains(neighbour)){
                parent[neighbour] = node;
                if(dfs(neighbour)) return true;
            } else if(departureTime[neighbour] == -1) return true;
        }
        topologicalSort.push(node);
        departureTime[node] = count++;
        return false;
    }

}
