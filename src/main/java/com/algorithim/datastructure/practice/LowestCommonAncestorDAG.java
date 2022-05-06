package com.algorithim.datastructure.practice;


/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. 
The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.
For example, in this diagram, 6 and 8 have common ancestors of 4 and 14.

             15
             /
         14  13
        /  |
1   2    4   12
 \ /     / | \ /
  3   5  8  9
   \ / \       \
    6   7     11

parentChildPairs1 = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (4, 8), (4, 9), (9, 11), (14, 4), (13, 12),
    (12, 9),(15, 13)
]

Write a function that takes the graph, as well as two of the individuals in our dataset, 
as its inputs and returns true if and only if they share at least one ancestor.

Sample input and output:

hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 9) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 3, 1) => false
hasCommonAncestor(parentChildPairs1, 7, 11) => true
hasCommonAncestor(parentChildPairs1, 6, 5) => true
hasCommonAncestor(parentChildPairs1, 5, 6) => true

Additional example: In this diagram, 4 and 12 have a common ancestor of 11.

        11
       /  \
      10   12
     /  \
1   2    5
 \ /    / \
  3    6   7
   \        \
    4        8

parentChildPairs2 = [
    (1, 3), (11, 10), (11, 12), (2, 3), (10, 2),
    (10, 5), (3, 4), (5, 6), (5, 7), (7, 8),
]

hasCommonAncestor(parentChildPairs2, 4, 12) => true
hasCommonAncestor(parentChildPairs2, 1, 6) => false
hasCommonAncestor(parentChildPairs2, 1, 12) => false

n: number of pairs in the input
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestorDAG {
    
    public static void main(String[] args) {        
        int [][] parentChild = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12},
                {12, 9},{15, 13}
        };
        int numberOfNodes = 16;
        buildAncestorList(numberOfNodes,parentChild);
        System.out.println(parentList);
        System.out.println(hasCommonAncestor(3, 8));
        System.out.println(hasCommonAncestor(5, 8));
        System.out.println(hasCommonAncestor(6, 8));
        System.out.println(hasCommonAncestor(6, 9));
        System.out.println(hasCommonAncestor(1, 3));
        System.out.println(hasCommonAncestor(3, 1));
        System.out.println(hasCommonAncestor(7, 11));
        System.out.println(hasCommonAncestor(6, 5));
        System.out.println(hasCommonAncestor(5, 6));
    }

    static List<List<Integer>> parentList = new ArrayList<>();
    static List<Integer> [] adjList;
    private static void buildAncestorList(int n, int[][] parentChild) {
        adjList = new LinkedList[n];
        for(int i = 0; i < n ; i++) adjList[i] = new LinkedList<>();
        for(int i = 0; i < parentChild.length; i++){
            adjList[parentChild[i][0]].add(parentChild[i][1]);
        }
        for(int i = 0; i < n ; i++){
            parentList.add(i, new ArrayList<>());
        }
        for(int i = 0; i < n ; i++){
            boolean [] visited = new boolean[n];
            dfs(i,visited);
            for(int j = 0; j < visited.length; j++){
                if(i == j) continue;
                if(visited[j]){
                    parentList.get(j).add(i);
                }
            }
        }
    }

    private static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        for(int children : adjList[node]){
            if(!visited[children]) dfs(children,visited);
        }
    }

    private static boolean hasCommonAncestor( int node1, int node2) {
        List<Integer> node1List = parentList.get(node1);
        List<Integer> node2List = parentList.get(node2);
        int i = 0, j = 0;
        while(i < node1List.size() && j < node2List.size()){
            if(node1List.get(i) == node2List.get(j)) return true;
            else if(node1List.get(i) > node2List.get(j)){
                j++;
            } else {
                i++;
            }
        }
        return false;
    }
}
