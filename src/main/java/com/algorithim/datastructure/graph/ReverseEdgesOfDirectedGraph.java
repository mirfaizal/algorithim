package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ReverseEdgesOfDirectedGraph {

    static class Node {
        int val;
        List<Node> neighbours;
        Node(int val){
            this.val = val;
            this.neighbours = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.neighbours.add(new Node(2));
        node.neighbours.get(0).neighbours.add(new Node(3));
        node.neighbours.get(0).neighbours.get(0).neighbours.add(new Node(4));
        node.neighbours.get(0).neighbours.get(0).neighbours.get(0).neighbours.add(node);
        printGraph(reverseADirectedGraph(node));
    }

    private static void printGraph(Node clone) {
        Set<Integer> visited = new LinkedHashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(clone);
        visited.add(clone.val);
        while(!queue.isEmpty()){
            Node poppedNode = queue.remove();
            for(Node neighbour : poppedNode.neighbours){
                if(!visited.contains(neighbour.val)){
                    queue.add(neighbour);
                    visited.add(neighbour.val);
                }
            }
        }
        for(int i : visited) System.out.print(i+"->");
    }

    private static Node reverseADirectedGraph(Node node) {
        Map<Integer, Node> reversed = new LinkedHashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        reversed.put(node.val, new Node(node.val));
        while(!queue.isEmpty()){
            Node poppedNode = queue.remove();
            for(Node neighbour : poppedNode.neighbours){
                if(!reversed.containsKey(neighbour.val)){
                    queue.add(neighbour);
                    reversed.put(neighbour.val, new Node(neighbour.val));
                }
                reversed.get(neighbour.val).neighbours.add(reversed.get(poppedNode.val));
            }
        }
        return reversed.get(node.val);
    }
}
