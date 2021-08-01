package com.algorithim.datastructure.companies.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Array {
    public static void main(String[] args) {
        //System.out.println(isPalindrome("race a car"));
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(isPalindrome(".,"));
        setZeroes(new int[][]{{0,1,2,0},{5,6,7,8},{9,10,3,12}});
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i =0, j=s.length()-1;
        while(i<j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(i < j && s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    static class Pair {
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static List<Pair> pairs = new ArrayList<>();
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == 0){
                    pairs.add(new Pair(i,j));
                }
            }
        }
        for(Pair pair: pairs){
            int row = pair.row;
            int col = pair.col;
            for(int i=0;i<cols;i++) matrix[row][i] = 0;
            for(int i=0;i<rows;i++) matrix[i][col] = 0;
        }
    }
}
