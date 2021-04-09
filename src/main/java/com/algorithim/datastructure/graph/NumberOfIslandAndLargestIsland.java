package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NumberOfIslandAndLargestIsland {

    static int[][] matrix = new int[][]{

//
//                    {1,1,1,1,0},
//                    {1,1,0,1,0},
//                    {1,1,0,0,0},
//                    {0,0,0,0,0}



            {1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0},
            {0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0},
            {1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0}
    };
    static int maxRow = matrix.length;
    static int maxCol = matrix[0].length;
    static boolean [][] visited = new boolean [maxRow][maxCol];
    public static void main(String[] args) {
        int count = 0, island =0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if ( !visited[row][col] && matrix[row][col] == 1) {
                    count = Math.max(bfs(row,col),count);
                    island++;
                }
            }
        }
        System.out.println("Island count " +island);
        System.out.println("Largest Island " +count);
    }

    static class Node {
        int row;
        int col;
        Node(int row, int col){
            this.col = col;
            this.row = row;
        }
    }

    private static int bfs(int row , int col) {
        int count = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row,col));
        visited[row][col] = true;
        //matrix[row][col] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node neighbour : getNeighbours(node.row,node.col)) {
                if (!visited[neighbour.row][neighbour.col]) {
                    visited[neighbour.row][neighbour.col] = true;
                    //matrix[neighbour.row][neighbour.col] = 0;
                    queue.add(neighbour);
                    count++;
                }
            }
        }
        return count;
    }

    private static List<Node> getNeighbours(int row, int col) {
        List<Node> list = new ArrayList<>();
        if (row - 1 >= 0 && matrix[row - 1][col] == 1) list.add(new Node(row - 1, col));
        if (col - 1 >= 0 && matrix[row][col - 1] == 1) list.add(new Node(row, col - 1));
        if (col + 1 < maxCol && matrix[row][col + 1] == 1) list.add(new Node(row, col + 1));
        if (row + 1 < maxRow && matrix[row + 1][col] == 1) list.add(new Node(row + 1, col));
        return list;
    }

}