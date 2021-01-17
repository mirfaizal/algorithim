package com.algorithim.datastructure.graph;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GraphCycle {
    private int vertices;
    private List<Integer> [] adjacencyList;
    GraphCycle(int vertices){
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];
        for(int i=0;i<vertices;i++){
            this.adjacencyList[i] = new LinkedList<>();
        }
    }
    // Directed graph
    private void addEdge(int vertexA, int vertexB){
        this.adjacencyList[vertexA].add(vertexB);
        //this.adjacencyList[vertexB].add(vertexA);
    }

    public static void main(String[] args) {
        GraphCycle gc = new GraphCycle(5);
        gc.addEdge(0,1);
        gc.addEdge(1,2);
        gc.addEdge(2,3);
        gc.addEdge(3,4);
        gc.addEdge(4,2);
        System.out.print(gc.hasCycle(4));

    }

    private boolean hasCycleIterative(int root) {
        Set<Integer> visited = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            if(!visited.contains(vertex)){
                visited.add(vertex);
                for(int edge : adjacencyList[vertex]){
                    if(!stack.contains(edge)) stack.push(edge);
                }
            }
            else return true;
        }
        return false;
    }

    private boolean hasCycle(int root) {
        Set<Integer> visited = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            if(!visited.contains(vertex)){
                visited.add(vertex);
                for(int edge : adjacencyList[vertex]){
                    if(!stack.contains(edge)) stack.push(edge);
                }
            }
            else return true;
        }
        return false;
    }
}
