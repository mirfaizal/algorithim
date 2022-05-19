package com.algorithim.datastructure.practice;

//    After catching your classroom students cheating before, you realize your students are getting craftier and hiding words in 2D grids of letters.
//    The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.
//
//    Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates.
//    If there are multiple matches, return any one.
//
//    grid1 = [
//    ['c', 'c', 'x', 't', 'i', 'b'],
//    ['c', 'c', 'a', 't', 'n', 'i'],
//    ['a', 'c', 'n', 'n', 't', 't'],
//    ['t', 'c', 's', 'i', 'p', 't'],
//    ['a', 'o', 'o', 'o', 'a', 'a'],
//    ['o', 'a', 'a', 'a', 'o', 'o'],
//    ['k', 'a', 'i', 'c', 'k', 'i'],
//    ]
//    catnip -->

//    word1 = "catnip"
//    word2 = "cccc"
//    word3 = "s"
//    word4 = "bit"
//    word5 = "aoi"
//    word6 = "ki"
//    word7 = "aaa"
//    word8 = "ooo"
//
//    grid2 = [['a']]
//    word9 = "a"
//
//    find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
//    find_word_location(grid1, word2) =>
//    [(0, 1), (1, 1), (2, 1), (3, 1)]
//    OR [(0, 0), (1, 0), (1, 1), (2, 1)]
//    OR [(0, 0), (0, 1), (1, 1), (2, 1)]
//    OR [(1, 0), (1, 1), (2, 1), (3, 1)]
//    find_word_location(grid1, word3) => [(3, 2)]
//    find_word_location(grid1, word4) => [(0, 5), (1, 5), (2, 5)]
//    find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
//    find_word_location(grid1, word6) => [(6, 4), (6, 5)]
//    find_word_location(grid1, word7) => [(5, 1), (5, 2), (5, 3)]
//    find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
//    find_word_location(grid2, word9) => [(0, 0)]
//
//    Complexity analysis variables:
//
//    r = number of rows
//    c = number of columns
//    w = length of the word

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    static class Pair {
        int row; int col;
        Pair(int row, int col){
            this.col = col;
            this.row = row;
        }
        @Override
        public String toString(){
            return row + " " +col;
        }
    }

    static int rows;
    static int cols;
    static Set<List<Pair>> result = new HashSet<>();
    static boolean [][]  visited;
    static public Set<List<Pair>> wordSearch(char [][] grid, String word){
        result = new HashSet<>();
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(!visited[i][j]) dfs(i,j,0,new ArrayList<>(),grid,word);
            }
        }
        return result;
    }

    private static void dfs(int i, int j, int index, ArrayList<Pair> slate, char[][] grid, String word) {
        if(index == word.length()){
            result.add(new ArrayList<>(slate));
            return;
        }
        if(i >= rows || i < 0 || j >=cols || j < 0 || word.charAt(index) != grid[i][j] || visited[i][j]){
            return;
        }

        slate.add(new Pair(i,j));
        visited[i][j] = true;
        dfs(i+1,j,index + 1, slate, grid, word);
        dfs(i,j+1,index + 1, slate, grid, word);
        dfs(i-1,j,index + 1, slate, grid, word);
        dfs(i,j-1,index + 1, slate, grid, word);

        slate.remove(slate.size() - 1);
    }

    public static void main(String[] args) {
        char [][] grid = new char[][]{
                {'c', 'c', 'x', 't', 'i', 'b'},
                {'c', 'c', 'a', 't', 'n', 'i'},
                {'a', 'c', 'n', 'n', 't', 't'},
                    {'t', 'c', 's', 'i', 'p', 't'},
                        {'a', 'o', 'o', 'o', 'a', 'a'},
                            {'o', 'a', 'a', 'a', 'o', 'o'},
                                {'k', 'a', 'i', 'c', 'k', 'i'}
        };
        System.out.println(wordSearch(grid,"catnip"));
        System.out.println(wordSearch(grid,"cccc"));
        System.out.println(wordSearch(grid,"s"));
        System.out.println(wordSearch(grid,"bit"));
        System.out.println(wordSearch(grid,"aoi"));
        System.out.println(wordSearch(grid,"ki"));
        System.out.println(wordSearch(grid,"aaa"));

    }


}
