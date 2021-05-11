package com.algorithim.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BipartiteTree {
    public static void main(String[] args) {
        // [[1,3],[0,2],[1,3],[0,2]]
        System.out.println(isBipartite(new int[][] {{1,3},{0,2},{1,3},{0,2}}));
    }
    // Contains distance as value
    static Set<Integer> visited = new LinkedHashSet<>();
    static int [] parent;
    static int [] distance;
    static int [] color;
    public static boolean isBipartite(int[][] graph) {
        int numberOfVertices = graph.length;
        parent = new int[numberOfVertices];
        color = new int[numberOfVertices];
        distance = new int[numberOfVertices];
        Arrays.fill(parent,-1);
        for(int i=0;i<numberOfVertices;i++){
            if(!visited.contains(i)) {
                if(!dfs(i,graph)) return false;
            }
        }
        return true;
    }
    private static boolean bfs(int source, int[][] graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        distance[source] = 0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            for(int i=0;i<graph[node].length;i++){
                int neighbour = graph[node][i];
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    parent[neighbour] = node;
                    distance[neighbour] = 1 + distance[node]; // Calculating distance
                    queue.add(neighbour);
                } else if (neighbour != parent[node]) {  // Must be a cross edge
                    // Check if they are same level, then there is a length of odd cycle
                    if(distance[neighbour] == distance[node]) return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int node, int [][] graph){
        visited.add(node);
        for(int i=0;i<graph[node].length;i++){
            int neighbour = graph[node][i];
            if(!visited.contains(neighbour)){
                parent[neighbour] = node;
                color[neighbour] = 1 - color[node];
                if(!dfs(neighbour,graph)) return false;
            } else if (neighbour != parent[node]) { // Back Edge
                // Check if there is any same color node in same level
                if(color[node] == color[neighbour]) return false;
            }
        }
        return true;
    }
}
