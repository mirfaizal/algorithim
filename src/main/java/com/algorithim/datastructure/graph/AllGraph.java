package com.algorithim.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class AllGraph {
    int vertices;
    List<Integer> [] adjVertices;
    AllGraph(int vertices){
        this.vertices = vertices;
        this.adjVertices = new LinkedList[vertices];
        for(int i=0;i<vertices;i++){
            this.adjVertices[i] = new LinkedList<>();
        }
    }
    private void addEdge(int source, int destination){
        adjVertices[source].add(destination);
    }

    private List<Integer> bfs(int start){
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int item = queue.remove();
            List<Integer> kids = adjVertices[item];
            for(Integer kid : kids){
                if(!visited.contains(kid)){
                    visited.add(kid);
                    queue.add(kid);
                }
            }
        }
        return visited;
    }

    private List<Integer> dfs(int start){
        List<Integer> visited = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        while(!stack.isEmpty()){
            int item = stack.pop();
            List<Integer> kids = adjVertices[item];
            for(Integer kid : kids){
                if(!visited.contains(kid)){
                    visited.add(kid);
                    stack.add(kid);
                }
            }
        }
        return visited;
    }
    static List<Integer> visitedRecursive = new ArrayList<>();
    private void dfs_recursive(int start){
        visitedRecursive.add(start);
        for(Integer kid : adjVertices[start]){
            if(!visitedRecursive.contains(kid)){
                dfs_recursive(kid);
            }
        }
    }



    private List<Integer> shortestPath(int source, int destination) {
        Map<Integer,Integer> parentChildMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        queue.add(source);
        parentChildMap.put(source,null);
        while(!queue.isEmpty()){
            int prev = queue.poll();
            if(prev == destination) break;
            List<Integer> kids = this.adjVertices[prev];
            for(Integer kid : kids){
                if(!parentChildMap.containsKey(kid)){
                    parentChildMap.put(kid,prev);
                    queue.add(kid);
                }
            }
        }
        if(parentChildMap.get(destination) == null) return new ArrayList<>();
        Integer current = destination;
        while(current != null){
            path.add(current);
            current = parentChildMap.get(current);
        }
        return path;
    }
    public static void main(String[] args) {
        AllGraph graph = new AllGraph(15);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(0,5);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,10);
        graph.addEdge(3,1);
        graph.addEdge(5,1);
        graph.addEdge(5,2);
        graph.addEdge(10,11);
        graph.addEdge(10,12);
        graph.addEdge(11,3);
        graph.addEdge(12,13);
        graph.addEdge(13,14);
        graph.addEdge(14,11);

//        List<Integer> path = graph.shortestPath(2,14);
//        path.stream().forEach(i-> System.out.print(i+" "));
//        System.out.println();
//        path = graph.shortestPath(14,2);
//        path.stream().forEach(i-> System.out.print(i+" "));

//        List<Integer> path = graph.bfs(0);
//        path.stream().forEach(item -> System.out.print(item+" "));

        List<Integer> path = graph.dfs(0);

        path.stream().forEach(item -> System.out.print(item+" "));
        System.out.println();
        graph.dfs_recursive(0);
        visitedRecursive.stream().forEach(item -> System.out.print(item+" "));
    }


}
