package com.algorithim.datastructure.graph;


import java.util.*;

public class ZombieCluster {
    public static void main(String[] args) {
        System.out.println(zombieCluster(Arrays.asList("110000","110000","001100","001100","000011","000011")));
    }
    static List<Integer> [] adjList;
    static Set<Integer> visited = new LinkedHashSet<>();
    public static int zombieCluster(List<String> zombies){
        if(zombies.isEmpty()) return -1;
        if(zombies.size() != zombies.get(0).length()) return -1;
        int rows = zombies.size();
        int cols = zombies.get(0).length();
        int totalNumberOfItems = rows * cols;
        adjList = new LinkedList[totalNumberOfItems];
        for(int i=0;i<totalNumberOfItems;i++) adjList[i] = new LinkedList<>();
        int index = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++) {
                if( zombies.get(i).charAt(j) == '1'){
                    getNeighbour(adjList[index],zombies,i,j,rows,cols);
                }
                index++;
            }
        }
        int count = 0;
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                if( !visited.contains(getIndex(i,j,cols)) && zombies.get(i).charAt(j) == '1'){
                    bfs(getIndex(i,j,cols));
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : adjList[node]){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    private static void getNeighbour(List<Integer> adjList, List<String> zombies, int row, int col, int rows, int cols) {
        if(row - 1 >=0 && zombies.get(row - 1).charAt(col) == '1') adjList.add(getIndex(row - 1,col,cols));
        if(row + 1 <rows && zombies.get(row + 1).charAt(col) == '1') adjList.add(getIndex(row + 1,col,cols));
        if(col - 1 >=0 && zombies.get(row).charAt(col - 1) == '1') adjList.add(getIndex(row,col - 1,cols));
        if(col + 1 <cols && zombies.get(row).charAt(col + 1) == '1') adjList.add(getIndex(row,col + 1,cols));
    }

    private static int getIndex(int row, int col, int cols) {
        return row * cols + col;
    }

}
