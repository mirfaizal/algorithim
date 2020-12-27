package com.algorithim.datastructure.misc;

public class SpiralArray {
    public static void main(String[] args) {
        int [][] arr = spiralArray(4);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }

    }

    private static int [][] spiralArray(int number) {
        int [][] array = new int[number][number];
        int top = 0 , left = 0, right = number - 1, bottom = number - 1, direction = 0, index = 0;
        while(top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    array[top][i] = ++index;
                }
                direction = 1;
                top++;
            }
            if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    array[i][right] = ++index;
                }
                direction = 2;
                right--;
            }
            if(direction == 2){
                for(int i=right; i>=left; i--){
                    array[bottom][i] = ++index;
                }
                direction = 3;
                bottom--;
            }
            if(direction == 3){
                for(int i=bottom; i>=top; i--){
                    array[i][left] = ++index;
                }
                direction = 0;
                left++;
            }
        }
        return array;
    }
}
