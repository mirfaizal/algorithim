package com.algorithim.datastructure.graph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ValidTree {


    public static void main(String[] args) {
        int[][] edge = new int[][]{{1, 0},{2,0}};
        int vertices = 3;
        System.out.println(validTree(vertices, edge));
    }

    static int[] captured;
    static Map<Integer, Integer> parent = new HashMap<>();
    static Set<Integer> visited;
    static List<Integer>[] adjList;

    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        visited = new LinkedHashSet<>();
        captured = new int[n];
        parent.put(0, -1);
        adjList = new LinkedList[n];
        for (int i = 0; i < n; i++) adjList[i] = new LinkedList<>();
        // Create adjacency list
        for (int i = 0; i < edges.length; i++) {
            // Add edges to the graph
            int[] edge = edges[i];
            adjList[edge[0]].add(edge[1]);
        }
        // Find the graph is connected
        int connected = 0;
        for (int i = 0; i < n; i++) {
            if (captured[i] == 0 && visited.size() !=0) connected++;
            //captured[i] = connected;
            if (connected > 1) return false; // Tree is not connected
            //visited.add(i);
            if (bfsHasCycle(i, connected)) return false; // Has cycle
            if(visited.size() == n) return true;
        }
        return true;
    }

    private static boolean bfsHasCycle(int source, int connected) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int neighbour : adjList[node]) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    captured[neighbour] = connected;
                    parent.put(neighbour, node);
                    queue.add(neighbour);
                } else {
                    // Neighbor has been visited before
                    if (parent.containsKey(neighbour) && parent.get(neighbour) != -1) {
                        System.out.print(neighbour + " " + parent.get(neighbour));
                        return true; // There must be a cycle.
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(int source, int connected) {
        for (int neighbour : adjList[source]) {
            if (!visited.contains(neighbour)) {
                visited.add(neighbour);
                captured[neighbour] = connected;
                parent.put(neighbour, source);
                if (dfs(neighbour, connected)) return true;
            } else {
                // Neighbor has been visited before
                if (parent.get(neighbour) != source) {
                    System.out.print(neighbour + " " + parent.get(neighbour));
                    return true; // There must be a cycle.
                }
            }
        }
        return false;
    }

}
