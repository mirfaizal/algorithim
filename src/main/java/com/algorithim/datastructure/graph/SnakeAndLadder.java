package com.algorithim.datastructure.graph;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//Input: board =
// [
//   [-1,-1,-1,-1,-1,-1],
//   [-1,-1,-1,-1,-1,-1],
//   [-1,-1,-1,-1,-1,-1],
//   [-1,35,-1,-1,13,-1],
//   [-1,-1,-1,-1,-1,-1],
//   [-1,15,-1,-1,-1,-1]
// ]
//Output: 4
//Explanation:
//In the beginning, you start at square 1 (at row 5, column 0).
//You decide to move to square 2 and must take the ladder to square 15.
//You then decide to move to square 17 and must take the snake to square 13.
//You then decide to move to square 14 and must take the ladder to square 35.
//You then decide to move to square 36, ending the game.
//This is the lowest possible number of moves to reach the last square, so return 4.
//Example 2:
//
//Input: board = [[-1,-1],[-1,3]]
//Output: 1

public class SnakeAndLadder {
    public static void main(String[] args) {
        int [][] board = new int[][] {
                {-1,1,2,-1},
                {2,13,15,-1},
                {-1,10,-1,-1},
                {-1,6,2,8}
        };

        System.out.println(snakeAndLadder(board));
    }
    static int[] distance;
    static List<Integer>[] adjList;
    private static int snakeAndLadder(int [][] board) {
        Map<Integer, Integer> gameMap = getGameMap(board);
        int numberOfVertices = gameMap.size();
        distance = new int[numberOfVertices + 1];
        adjList = new List[numberOfVertices + 1];
        for(int i=0;i<=numberOfVertices;i++) adjList[i] = new LinkedList<>();
        for(int i=0;i<=numberOfVertices;i++){
            for(int diceNum = 1; diceNum <=6 ; diceNum++){
                if(i+diceNum <= numberOfVertices){
                    adjList[i].add(gameMap.get(i+diceNum));
                }
            }
        }
        // Run BFS to get the shortest path
        bfs(1);
        return distance[numberOfVertices];
    }

    private static void bfs(int source) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new LinkedHashSet<>();
        queue.add(source);
        visited.add(source);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : adjList[node]){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                    if(distance[node] == -1) distance[neighbour] = 1;
                    else distance[neighbour] = distance[node] + 1;
                }
            }
        }
    }

    private static Map<Integer, Integer> getGameMap(int [][] board) {
        Map<Integer,Integer> gameMap = new LinkedHashMap<>();
        int index = 1;
        boolean flag = true;
        for(int i=board.length - 1; i>=0; i--){
            if(flag){
                for(int j=0;j<board[0].length;j++){
                    gameMap.put(index,board[i][j]);
                    if(board[i][j] == -1){
                        gameMap.put(index,index);
                    }
                    index++;
                }
            } else {
                for(int j=board[0].length-1;j>=0;j--){
                    gameMap.put(index,board[i][j]);
                    if(board[i][j] == -1){
                        gameMap.put(index,index);
                    }
                    index++;
                }
            }
            flag = !flag;
        }
        return gameMap;
    }
}
