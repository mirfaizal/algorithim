package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
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
        Node(int val,List<Node> neighbours){
            this.val = val;
            this.neighbours = neighbours;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.neighbours.add(new Node(2));
        node.neighbours.get(0).neighbours.add(new Node(3));
        node.neighbours.get(0).neighbours.get(0).neighbours.add(new Node(4));
        node.neighbours.get(0).neighbours.get(0).neighbours.get(0).neighbours.add(node);
        Node clone = cloneAGraph(node);
        System.out.println(clone.toString());
    }

    private static Node cloneAGraph(Node node) {
        Map<Node,Node> visited = new HashMap<>();
        visited.put(node,new Node(node.val));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            Node n = queue.poll();
            for(Node neighbour : n.neighbours){
                if(!visited.containsKey(neighbour)){
                    queue.offer(neighbour);
                    visited.put(neighbour,new Node(neighbour.val));
                }
                visited.get(n).neighbours.add(visited.get(neighbour));
            }
        }
        return visited.get(node);
    }

}
