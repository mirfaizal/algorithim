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
        adjList[source].add(destination);
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
                    //if(!stack.contains(edge))
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

    private boolean hasCycle(List<Integer> [] adjList, int root){
        Set<Integer> visited = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            if(!visited.contains(vertex)){
                visited.add(vertex);
                for(int edge: adjList[vertex]){
                    if(!stack.contains(edge)) stack.push(edge);
                }
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(2,0);
        graph.addEdge(3,2);
        graph.addEdge(2,1);
        graph.addEdge(1,4);
        //graph.addEdge(4,2);
        graph.display(graph.vertices, graph.adjList);
        graph.dfs(graph.adjList, 3).stream().forEach(e -> System.out.print(e.intValue()));
        System.out.println();
        graph.dfs(graph.adjList, 1).stream().forEach(e -> System.out.print(e.intValue()));
        System.out.println();
        graph.bfs(graph.adjList, 3).stream().forEach(e -> System.out.print(e.intValue()));
        System.out.println();
        System.out.println("hasCycle - "+graph.hasCycle(graph.adjList, 0));
    }

    private void display(int vertices, List<Integer> [] adjList) {
        for(int i=0;i<vertices;i++){
            for(Integer edge : adjList[i]){
                System.out.println("("+i+" , "+edge+")");
            }
        }
    }
}