package com.algorithim.datastructure.array;

public class CalculateGameIndex {
    static int [][] board = new int[][] {
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,35,-1,-1,13,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,15,-1,-1,-1,-1}
    };
    public static void main(String[] args) {
        int [] array = new int[(board.length * board[0].length) + 1];
        int index = 1;
        boolean flag = true;
        for(int i=board.length - 1; i>=0; i--){
            if(flag){
                for(int j=0;j<board[0].length;j++){
                    array[index++] = board[i][j];
                }
                flag = false;
            } else {
                for(int j=board[0].length-1;j>=0;j--){
                    array[index++] = board[i][j];
                }
                flag = true;
            }
        }
        for(int i=0; i<array.length; i++){
            System.out.println(+i+" : "+array[i]);
        }

    }
}
