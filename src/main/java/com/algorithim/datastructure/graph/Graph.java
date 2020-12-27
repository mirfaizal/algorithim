package com.algorithim.datastructure.graph;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
    int vertices;
    List<Integer> [] adjList;

    Graph(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for(int i=0;i<vertices;i++){
            adjList[i] = new LinkedList<>();
        }
    }
    private void addEdge(int source, int destination){
        //adjList[source].add(destination);
        adjList[destination].add(source);
    }

    private Set<Integer> dfs(List<Integer> [] adjList, int root){
        Set<Integer> visited = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            if(!visited.contains(vertex)) {
                visited.add(vertex);
                for (int edge : adjList[vertex]) {
                    stack.push(edge);
                }
            }
        }
        return visited;
    }

    private Set<Integer> bfs(List<Integer> [] adjList, int root){
        Set<Integer> visited = new LinkedHashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            for(int edge : adjList[vertex]){
                if(!visited.contains(edge)){
                    visited.add(edge);
                    queue.add(edge);
                }
            }
        }
        return visited;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,4);
        graph.addEdge(2,4);
        graph.display(graph.vertices, graph.adjList);
        graph.dfs(graph.adjList, 4).stream().forEach(e -> System.out.print(e.intValue()));
        System.out.println();
        graph.bfs(graph.adjList, 4).stream().forEach(e -> System.out.print(e.intValue()));
    }

    private void display(int vertices, List<Integer> [] adjList) {
        for(int i=0;i<vertices;i++){
            for(Integer edge : adjList[i]){
                System.out.println("("+i+" , "+edge+")");
            }
        }
    }
}