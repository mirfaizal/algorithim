package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**

 2192. All Ancestors of a Node in a Directed Acyclic Graph Medium

 You are given a positive integer n representing the number of nodes of a Directed Acyclic Graph (DAG).
 The nodes are numbered from 0 to n - 1 (inclusive).
 You are also given a 2D integer array edges, where edges[i] = [fromi, toi] denotes that there is a unidirectional edge from fromi to toi in the graph.
 Return a list answer, where answer[i] is the list of ancestors of the ith node, sorted in ascending order.
 A node u is an ancestor of another node v if u can reach v via a set of edges.

 Example 1:

 Input: n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
 Output: [[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
 Explanation:
 The above diagram represents the input graph.
 - Nodes 0, 1, and 2 do not have any ancestors.
 - Node 3 has two ancestors 0 and 1.
 - Node 4 has two ancestors 0 and 2.
 - Node 5 has three ancestors 0, 1, and 3.
 - Node 6 has five ancestors 0, 1, 2, 3, and 4.
 - Node 7 has four ancestors 0, 1, 2, and 3.
 Example 2:


 Input: n = 5, edgeList = [[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 Output: [[],[0],[0,1],[0,1,2],[0,1,2,3]]
 Explanation:
 The above diagram represents the input graph.
 - Node 0 does not have any ancestor.
 - Node 1 has one ancestor 0.
 - Node 2 has two ancestors 0 and 1.
 - Node 3 has three ancestors 0, 1, and 2.
 - Node 4 has four ancestors 0, 1, 2, and 3.

 */

public class AncestorsNodeDAG {

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> [] adjList;
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        adjList = new LinkedList[n];
        for(int i = 0; i < n; i++) adjList[i] = new LinkedList<>();
        for(int i = 0; i < edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
        }
        for(int i = 0; i < n; i++){
            result.add(i, new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            boolean [] visited = new boolean [n];
            dfs(i,visited);
            for(int j = 0; j < visited.length; j++){
                if(i == j) continue;
                if(visited[j]){
                    result.get(j).add(i);
                }
            }
        }
        return result;
    }

    private static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        for(int children : adjList[node]){
            if(!visited[children]){
                dfs(children,visited);
            }
        }
    }

    public static void main(String[] args) {
        getAncestors(5, new int[][]{{0,1}, {0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}});
        System.out.println(result);
        result = new ArrayList<>();
        getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}});
        System.out.println(result);
    }
}
