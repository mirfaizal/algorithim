package com.algorithim.datastructure.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule2 {

    /**
     *  5
     *   \
     *    0 - 1 - 2 - 3 - 4
     *   /
     * 6
     * 1. create a graph , adjList , directed graph
     * 2. Traverse graph using dfs
     *      2.1 if graph has a back edge, use a callStack to detect cycle
     *      2.2 Add nodes are good, not having back edge
     *
     */

    static List<Integer> [] adjList;
    static Set<Integer> visited = new HashSet<>();
    static Set<Integer> callStack = new HashSet<>();
    static List<Integer> result;
    public static boolean canFinish(int n , int [][] edgeArray){
        visited = new HashSet<>();
        callStack = new HashSet<>();
        result = new ArrayList<>();
        // Build the graph
        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++ ) adjList[i] = new ArrayList<>();
        for(int [] pre : edgeArray){
            adjList[pre[0]].add(pre[1]);
        }
        // Traverse the graph
        for(int i = 0; i < n; i++ ) {
            if(!visited.contains(i)){
                if(!dfs(i)) {
                    return false;
                }
            }
        }
        System.out.println(result);
        return true;
    }
    private static boolean dfs(int node){
        visited.add(node);
        callStack.add(node);
        for(int neighbour : adjList[node]){
            if(!visited.contains(neighbour)){ // Tree Edge
                if(!dfs(neighbour)) return false;
            } else if(callStack.contains(neighbour)) return false; // Back Edge
        }
        callStack.remove(node);
        result.add(node);
        return true;
    }


    public static void main(String[] args) {
        System.out.println(canFinish(7,new int[][]{{5,0},{6,0},{0,1},{1,2},{2,3},{3,4}}));
        System.out.println(canFinish(2,new int[][]{{0,1},{1,0}}));
        System.out.println(canFinish(2,new int[][]{{0,1}}));
    }

}
