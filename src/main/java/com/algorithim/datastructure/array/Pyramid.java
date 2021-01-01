package com.algorithim.datastructure.array;

public class Pyramid {
    public static void main(String[] args) {
        Pyramid pyramid = new Pyramid();
        pyramid.pyramid(10);
    }

    private String[][] pyramid(int number) {
        String [][] array = new String[number][];
        int columns = (number * 2) - 1;
        int mid = (int) Math.floor(columns / 2);
        for(int row = 0 ; row < number; row++){
            array[row] = new String[columns];
            for(int col = 0 ; col < columns; col++){
                array[row][col] = " ";
                if(col>= mid - row && col<= mid + row){
                    array[row][col] = "#";
                }
            }
        }
        return array;
    }
}
