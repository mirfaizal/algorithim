package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneAGraphPartII {

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
        printGraph(cloneAGraph(node));
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

    private static Node cloneAGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node.val, new Node(node.val));
        while(!queue.isEmpty()){
            Node poppedNode = queue.remove();
            Node clonedPoppedNode = map.getOrDefault(poppedNode.val,new Node(poppedNode.val));
            map.put(poppedNode.val, clonedPoppedNode);
            for(Node neighbour : poppedNode.neighbours){
                Node clonedNeighbour = map.getOrDefault(neighbour.val, new Node(neighbour.val));
                clonedPoppedNode.neighbours.add(clonedNeighbour);
                if(!map.containsKey(neighbour.val)){
                    queue.add(neighbour);
                }
                map.put(neighbour.val, clonedNeighbour);
            }
        }
        return map.get(node.val);
    }
}
