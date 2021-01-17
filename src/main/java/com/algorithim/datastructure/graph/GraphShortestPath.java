package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
Question: Given a directed graph, find the shortest path between two nodes if one exists.

Graph has 5 Nodes
Edges - (1,2) , (2,3) , (3,4) , (4,5), (4,1), (1,5)

1------2
| \    |
|  5   |
| /    |
4------3
Find shortestPath(2, 3) = 2 -> 5 -> 4 -> 3
*/


public class GraphShortestPath {
    static class Node {
        int data;
        List<Node> children;
        Node(int data){
            this.data = data;
        }
        public void addChild(Node node){
            if(children == null) children = new ArrayList<>();
            this.children.add(node);
        }
    }
    private List<Node> shortestPath(Node a, Node b){
        if(a==null || b==null || a==b) return new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> parentChildMap = new HashMap<>();
        queue.add(a);
        parentChildMap.put(a,null);
        while(!queue.isEmpty()){
            Node prev = queue.poll();
            if (prev == b) break;
            List<Node> c = prev.children;
            for(Node current : c){
                if(!parentChildMap.containsKey(current)){
                    queue.add(current);
                    parentChildMap.put(current,prev);
                }
            }
        }
        List<Node> results = new ArrayList<>();
        if(parentChildMap.get(b) == null) return new ArrayList<>();
        Node current = b;
        while (current != null){
            System.out.print(current.data+" ");
            results.add(current);
            current = parentChildMap.get(current);
        }
        return results;
    }
    public static void main(String[] args) {
        GraphShortestPath graphShortestPath = new GraphShortestPath();
        Node nodeOne = new Node(1);
        Node nodeTwo = new Node(2);
        Node nodeThree = new Node(3);
        Node nodeFour = new Node(4);
        Node nodeFive = new Node(5);
        nodeOne.addChild(nodeTwo);
        nodeOne.addChild(nodeFive);
        nodeTwo.addChild(nodeThree);
        nodeThree.addChild(nodeFour);
        nodeFour.addChild(nodeFive);
        nodeFour.addChild(nodeOne);
        graphShortestPath.shortestPath(nodeTwo,nodeFive);
    }
}
