package com.algorithim.datastructure.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralArray {
    public static void main(String[] args) {

        int[][] arr = spiralArray(3, 4);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        spiralOrder(new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                }
        ).stream().forEach(e->System.out.print(e.intValue()+" "));
        System.out.println();


    }

    private static int[][] spiralArray(int row, int col) {
        int[][] array = new int[row][col];
        int top = 0, left = 0, right = col - 1, bottom = row - 1, index = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                array[top][i] = ++index;
            }
            top++;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                array[i][right] = ++index;
            }
            right--;
            for (int i = right; i >= left; i--) {
                array[bottom][i] = ++index;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                array[i][left] = ++index;
            }
            left++;
        }
        return array;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, bottom = row - 1, left = 0, right = col - 1;
        while (left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
