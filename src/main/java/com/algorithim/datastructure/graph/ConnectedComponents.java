package com.algorithim.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;


public class ConnectedComponents {
    static class Graph {
        int vertices;
        List<Integer>[] adjList;
        int[] capturedArray;

        Graph(int vertices) {
            this.vertices = vertices;
            this.adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                this.adjList[i] = new LinkedList<>();
            }
        }

        private void addEdge(int source, int destination) {
            addEdge(source, destination, false);
        }

        private void addEdge(int source, int destination, boolean isDirected) {
            if (isDirected) this.adjList[destination].add(source);
            this.adjList[source].add(destination);
        }

        private int connectedComponent() {
            int componentCount = 0;
            this.capturedArray = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                if (this.capturedArray[i] == 0) componentCount++;
                dfs_recursive(i, componentCount);
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < vertices; i++) {
                max = Math.max(max, this.capturedArray[i]);
            }
            return max;
        }


        private void dfs_recursive(int source, int connected){
            Set<Integer> visited = new LinkedHashSet<>();
            visited.add(source);
            this.capturedArray[source] = connected;
            dfs_helper(source,visited, connected);
        }

        private void dfs_helper(int source, Set<Integer> visited, int connected) {
            for(int edge : this.adjList[source]){
                if(!visited.contains(edge)){
                    visited.add(edge);
                    this.capturedArray[edge] = connected;
                    dfs_helper(edge,visited,connected);
                }
            }
        }

        private void dfs(int source, int connected) {
            Set<Integer> visited = new LinkedHashSet<>();
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(source);
            visited.add(source);
            this.capturedArray[source] = connected;
            while (!stack.isEmpty()) {
                int item = stack.pop();
                for (int edge : this.adjList[item]) {
                    if (!visited.contains(edge)) {
                        this.capturedArray[edge] = connected;
                        visited.add(edge);
                        stack.push(edge);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int [][] edge = new int[][] {{0,1},{1,2},{2,3},{3,4}};
        int vertices = 5;
        Graph newGraph = new Graph(vertices);
        for(int i=0;i<edge.length;i++){
            int [] edges = edge[i];
            newGraph.addEdge(edges[0], edges[1]);
        }
        System.out.println(newGraph.connectedComponent());
    }
}
