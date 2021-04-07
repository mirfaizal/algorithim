package com.algorithim.datastructure.graph;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GraphCycleDetection {

    public static void main(String arg[]) {
//        7 6
//        0 1
//        0 2
//        0 3
//        3 4
//        3 5
//        6 6
        List<Integer> edge_start = new ArrayList<>();
        edge_start.add(0);
        edge_start.add(0);
        edge_start.add(0);
//        edge_start.add(3);
//        edge_start.add(3);
//        edge_start.add(6);
        List<Integer> edge_end = new ArrayList<>();
        edge_end.add(1);
        edge_end.add(2);
        edge_end.add(3);
//        edge_end.add(4);
//        edge_end.add(5);
//        edge_end.add(6);
        System.out.println(is_it_a_tree(4,edge_start,edge_end));
    }

    static List<List<Integer>> adjList = new ArrayList<>();
    static Set<Integer> visited = new LinkedHashSet<>();
    static Map<Integer, Integer> parent = new LinkedHashMap<>();
    public static boolean is_it_a_tree(int node_count, List<Integer> edge_start, List<Integer> edge_end) {
        parent.put(0,-1);
        for(int i=0;i<node_count;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edge_start.size();i++){
            adjList.get(edge_start.get(i)).add(edge_end.get(i));
            adjList.get(edge_end.get(i)).add(edge_start.get(i));
        }
        if(dfs(0)) return false;
        return visited.size() == node_count;
    }
    private static boolean dfs(int node){
        visited.add(node);
        for(int neighbour : adjList.get(node)) {
            if(!visited.contains(neighbour)) {
                parent.put(neighbour,node);
                if(dfs(neighbour)) return true;
            } else if(parent.get(node) != neighbour) {
                return true;
            }
        }
        return false;
    }
}
