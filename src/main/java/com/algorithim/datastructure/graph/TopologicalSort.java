package com.algorithim.datastructure.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Given a directed acyclic graph, do a topological sort on this graph.
 * <p>
 * Do DFS by keeping visited. Put the vertex which are completely explored into a stack.
 * Pop from stack to get sorted order.
 * <p>
 * Space and time complexity is O(n).
 */
public class TopologicalSort {
    int vertices;
    List<Integer>[] adjList;
    Set<Integer> allVertices;

    TopologicalSort(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        allVertices = new HashSet<>();
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    private void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);
        allVertices.add(source);
        allVertices.add(destination);
    }

    /**
     * Main method to be invoked to do topological sorting.
     */
    public Stack<Integer> topSort() {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        for (Integer vertex : allVertices) {
            if (visited.contains(vertex)) {
                continue;
            }
            topSortUtil(vertex, stack, visited);
        }
        return stack;
    }

    private void topSortUtil(Integer vertex, Stack<Integer> stack, Set<Integer> visited) {
        visited.add(vertex);
        for (Integer childVertex : adjList[vertex]) {
            if (visited.contains(childVertex)) {
                continue;
            }
            topSortUtil(childVertex, stack, visited);
        }
        stack.push(vertex);
    }

    public static void main(String args[]) {
        TopologicalSort graph = new TopologicalSort(12);
        graph.addEdge(1, 0);
        graph.addEdge(2, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);

        Stack<Integer> result = graph.topSort();
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }
}
