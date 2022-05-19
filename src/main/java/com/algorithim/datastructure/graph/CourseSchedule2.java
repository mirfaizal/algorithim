package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule2 {
    static List<Integer>[] adjList;
    static Set<Integer> visited;
    static Set<Integer> callStack;
    static int count = 0;
    static List<Integer> output;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new HashSet<>();
        callStack = new HashSet<>();
        output = new ArrayList<>();
        adjList = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) adjList[i] = new ArrayList<>();
        for(int [] pre : prerequisites){
            adjList[pre[0]].add(pre[1]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!visited.contains(i)) {
                if (!dfs(i)) return false;
            }
        }
        System.out.print(output);
        return true;
    }

    // We know that in a DAG, no back-edge is present.
    // So if we order the vertices in order of their decreasing departure time,
    // we will get the topological order of the graph (every edge going from left to right).

    private static boolean dfs(int node) {
        visited.add(node);
        callStack.add(node);
        for(int neighbour : adjList[node]){
            if(!visited.contains(neighbour)){ // Tree Edge
                if(!dfs(neighbour)) return false;
            } else if(callStack.contains(neighbour)) return false; // Back Edge
        }
        callStack.remove(node);
        output.add(node);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(7,new int[][]{{5,0},{6,0},{0,1},{1,2},{2,3},{3,4}}));
        System.out.println(canFinish(2,new int[][]{{0,1},{1,0}}));
        System.out.println(canFinish(2,new int[][]{{0,1}}));
    }

}
