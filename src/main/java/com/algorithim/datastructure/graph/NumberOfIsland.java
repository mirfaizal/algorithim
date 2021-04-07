package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NumberOfIsland {

    static int[][] matrix = new int[][]{
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
    static Map<String, Integer> indexMap = new LinkedHashMap<>();
    static Set<Integer> visited = new LinkedHashSet<>();
    static Map<Integer, List<Integer>> adjList = new LinkedHashMap<>();

    public static void main(String[] args) {
        int mapIndex = 0, index = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                StringBuilder sb = new StringBuilder();
                sb.append(row).append(col);
                indexMap.put(sb.toString(), mapIndex++);
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 1) {
                    List<Integer> list = getListOfIndexes(row, col);

                    adjList.put(index, list);
                }
                if(index == 228){
                    System.out.println();
                }
                index++;
            }
        }
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                if(entry.getKey() == 228){
                    System.out.println();
                }
                bfs(entry.getKey());
                count++;
            }
        }
        System.out.println(count);
    }

    private static void bfs(Integer node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);
        while (!queue.isEmpty()) {
            int item = queue.poll();
            if(adjList.get(item) != null){
                for (int neighbour : adjList.get(item)) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.add(neighbour);
                    }
                }
            }else {
                System.out.println();
            }

        }
    }

    private static List<Integer> getListOfIndexes(int row, int col) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (row - 1 >= 0 && matrix[row - 1][col] == 1) addToList(row - 1, col, list, sb);
        if (col - 1 >= 0 && matrix[row][col - 1] == 1) addToList(row, col - 1, list, sb);
        if (col + 1 < maxCol && matrix[row][col + 1] == 1) addToList(row, col + 1, list, sb);
        if (row + 1 < maxRow && matrix[row + 1][col] == 1) addToList(row + 1, col, list, sb);

//        if(row - 1 >= 0 && col - 1 >= 0 && matrix.get(row-1).get(col-1) !=0) addToList(row-1, col-1, list, sb);
//        if(row - 1 >= 0 && matrix.get(row-1).get(col) !=0) addToList(row-1, col, list, sb);
//        if(row - 1 >= 0 && col + 1 < maxCol && matrix.get(row-1).get(col+1) !=0) addToList(row-1, col+1, list, sb);
//        if(col - 1 >= 0 && matrix.get(row).get(col-1) !=0) addToList(row, col-1, list, sb);
//        if(col + 1 < maxCol && matrix.get(row).get(col+1) !=0) addToList(row, col+1, list, sb);
//        if(row + 1 < maxRow && col - 1 >= 0 && matrix.get(row+1).get(col-1) !=0)addToList(row+1, col-1, list, sb);
//        if(row + 1 < maxRow && matrix.get(row+1).get(col) !=0) addToList(row+1, col, list, sb);
//        if(row + 1 < maxRow && col + 1 < maxCol && matrix.get(row+1).get(col+1) !=0) addToList(row+1, col+1, list, sb);
//
        return list;
    }

    private static void addToList(int row, int col, List<Integer> list, StringBuilder sb) {
        sb = new StringBuilder();
        sb.append(row).append(col);
        list.add(indexMap.get(sb.toString()));
    }

}
