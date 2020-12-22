package com.algorithim.datastructure.misc;

public class ZeroMatrix {
    public static void main(String[] args) {
        int [][] array = {{1,0,3,4},
                          {5,6,7,8},
                          {9,10,0,12}};
        System.out.println(array.length);
        System.out.println(array[1].length);
        setZeroSpace(array);
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    private static int [][] setZeroSpace(int [][] array){

        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        for(int i = 0 ; i < array[0].length; i++){
            if(array[0][i] == 0){
                isFirstRowZero = true;
                break;
            }
        }

        for(int i = 0 ; i < array.length; i++){
            if(array[i][0] == 0){
                isFirstColZero = true;
                break;
            }
        }

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(array[i][j] == 0){
                    array[i][0] = 0;
                    array[0][j] = 0;
                }
            }
        }

        for(int i = 1; i< array.length;i++){
            if(array[i][0] ==0 ){
                nullifyRow(array,i);
            }
        }

        for(int i = 1; i< array[0].length;i++){
            if(array[0][i] == 0 ){
                nullifyCol(array,i);
            }
        }

        if(isFirstRowZero){
            nullifyRow(array,0);
        }
        if(isFirstColZero){
            nullifyCol(array,0);
        }


        return array;
    }

    private static int[][] setZero(int[][] array) {
        boolean [] row = new boolean[array.length];
        boolean [] col = new boolean[array[0].length];
        for(int i=0;i<array.length;i++){
            for(int j=0; j< array[0].length;j++){
                if(array[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0;i<row.length;i++){
            if(row[i]) nullifyRow(array,i);
        }
        for(int j=0;j<col.length;j++){
            if(col[j]) nullifyCol(array,j);
        }

        return array;
    }

    private static void nullifyCol(int[][] array, int col) {
        for(int i=0;i<array.length;i++){
            array[i][col] = 0;
        }
    }

    private static void nullifyRow(int[][] array, int row) {
        for(int i=0;i<array[0].length;i++){
            array[row][i] = 0;
        }
    }
}
