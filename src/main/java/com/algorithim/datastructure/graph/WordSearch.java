package com.algorithim.datastructure.graph;

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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return x + " " + y;
        }
    }
    public static void main(String[] args) {
        char[][] grid =
                {
                    { 'c', 'r', 'c', 'a', 'r', 's' },
                    { 'a', 'b', 'i', 't', 'n', 'b' },
                    { 't', 'f', 'n', 'n', 't', 'i' },
                    { 'x', 's', 'i', 'i', 'p', 't' }
                };
        String word = "cat";
        findWord(word , grid);
    }
    static Set<List<Pair>> answer = new HashSet<>();
    static boolean[][] visited;
    static void findWord(String word, char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j]){
                    dfs(grid, i, j, 0, word, new ArrayList<>());
                }
            }
        }
        System.out.println("None");
    }

    static void dfs(char[][] grid, int x, int y, int index, String word, List<Pair> slate) {
        // Base Case
        if (index == word.length()) {
            answer.add(new ArrayList<>(slate));
            return;
        }
        // Boundary Condition
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length  || visited[x][y] || grid[x][y] != word.charAt(index)) {
            return;
        }

        slate.add(new Pair(x, y));
        visited[x][y] = true;
        dfs(grid, x + 1, y, index + 1, word, slate);
        dfs(grid, x, y + 1, index + 1, word, slate);
        dfs(grid, x - 1, y, index + 1, word, slate);
        dfs(grid, x, y - 1, index + 1, word, slate);

        slate.remove(slate.size() - 1);

    }

}




