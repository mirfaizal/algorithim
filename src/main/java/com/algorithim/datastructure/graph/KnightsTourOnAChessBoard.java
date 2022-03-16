package com.algorithim.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class KnightsTourOnAChessBoard {


    private static List<Integer> getNeighbour(int row, int col, int rows, int cols,List<Integer>  adjacencyList){
        // Conditions for Knights to determine place
        if(row-2 >=0 && col-1 >=0) adjacencyList.add(getGameIndex(row-2,col-1, cols));
        if(row-2 >=0 && col+1 <cols) adjacencyList.add(getGameIndex(row-2,col+1, cols));
        if(row-1 >=0 && col-2 >=0) adjacencyList.add(getGameIndex(row-1,col-2, cols));
        if(row-1 >=0 && col+2 <cols) adjacencyList.add(getGameIndex(row-1,col+2, cols));
        if(row+1 <rows && col-2 >=0) adjacencyList.add(getGameIndex(row+1,col-2, cols));
        if(row+1 <rows && col+2 <cols) adjacencyList.add(getGameIndex(row+1,col+2, cols));
        if(row+2 <rows && col-1 >=0) adjacencyList.add(getGameIndex(row+2,col-1, cols));
        if(row+2 <rows && col+1 <cols) adjacencyList.add(getGameIndex(row+2,col+1, cols));
        return adjacencyList;
    }

    private static int getGameIndex(int row, int col, int cols){
        return row * cols + col;
    }

    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        if(start_row == end_row && start_col == end_col) return 0;
        List<Integer> [] adjacencyList = new LinkedList[rows*cols];
        for(int i=0;i<rows*cols;i++) adjacencyList[i] = new LinkedList<>();
        int index = 0;
        numberOfHops = new int[rows*cols];
        Arrays.fill(numberOfHops,-1);
        for(int i=0; i<rows;i++){
            for(int j=0; j<cols;j++){
                getNeighbour(i,j,rows,cols,adjacencyList[index++]);
            }
        }
        int source = getGameIndex(start_row,start_col,cols);
        int destination = getGameIndex(end_row,end_col,cols);
        bfs(source,adjacencyList);
        if(numberOfHops[destination] == 0 ) return -1;
        return numberOfHops[destination];
    }
    static int [] numberOfHops;
    private static void bfs(int source, List<Integer>[] adjacencyList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> visited = new LinkedHashSet<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            //if(node == destination) break;
            for(int neighbours : adjacencyList[node]){
                if(!visited.contains(neighbours)){
                    visited.add(neighbours);
                    queue.add(neighbours);
                    if(numberOfHops[node] == -1){
                        numberOfHops[neighbours] = 1;
                    } else numberOfHops[neighbours] = numberOfHops[node] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(find_minimum_number_of_moves(3,3,0,0,1,1));
        //    Output: 3
        //    3 moves to reach from (0, 0) to (4, 1):
        //    (0, 0) -> (1, 2) -> (3, 3) -> (4, 1).
    }

}
