package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneAGraph {
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
        Node clone = cloneAGraph(node);
        System.out.println();
    }

    private static Node cloneAGraph(Node node) {
        Map<Integer, Node> clonedMap = new LinkedHashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        clonedMap.put(node.val, new Node(node.val));
        while(!queue.isEmpty()){
            Node nodeInQueue = queue.remove();
            Node cloneNode = clonedMap.getOrDefault(nodeInQueue.val, new Node(nodeInQueue.val));
            clonedMap.put(nodeInQueue.val, cloneNode);
            for(Node neighbour : nodeInQueue.neighbours){
                Node neighbourClone = clonedMap.getOrDefault(neighbour.val,new Node(neighbour.val));
                cloneNode.neighbours.add(neighbourClone);
                if(!clonedMap.containsKey(neighbour.val)){
                    queue.add(neighbour);
                }
                clonedMap.put(neighbour.val, neighbourClone);
            }
        }
        return clonedMap.get(node.val);
    }

}
