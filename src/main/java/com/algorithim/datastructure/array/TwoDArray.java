package com.algorithim.datastructure.array;

public class TwoDArray {
    public static void main(String[] args) {
        int [][] array = {{1,2,3},{4,0,6},{7,8,9}};
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        // 1st Column
        for(int i=0;i<3;i++){
            System.out.print(array[i][0]);
        }
        System.out.println();
        // 1st Row
        for(int i=0;i<3;i++){
            System.out.print(array[0][i]);
        }
        System.out.println();
        // 2nd Column
        for(int i=0;i<3;i++){
            System.out.print(array[i][1]);
        }
        System.out.println();
        // 2nd Row
        for(int i=0;i<3;i++){
            System.out.print(array[1][i]);
        }

        System.out.println(array.length);
        System.out.println(array[0].length);
        System.out.println(array[1].length);
        System.out.println(array[2].length);
    }
}
