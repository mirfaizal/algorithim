package com.algorithim.datastructure.ik.sorting;

/**
 * Dutch National Flag
 * Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.
 * Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.
 * This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch national flag has three colors (albeit different from ones used in this problem).
 * Example
 * {
 * "balls": ["G", "B", "G", "G", "R", "B", "R", "G"]
 * }
 * Output:
 * ["R", "R", "G", "G", "G", "G", "B", "B"]
 * There are a total of 2 red, 4 green and 2 blue balls. In this order they appear in the correct output.
 *
 * Notes
 * Constraints:
 *
 * 1 <= n <= 100000
 * Do this in ONE pass over the array, NOT TWO passes
 * Solution is only allowed to use constant extra memory
 */
public class DutchNationalFlag {
    // ["G", "B", "G", "G", "R", "B", "R", "G"]

    public static void main(String[] args) {
        dutch_flag_sort(new char[] {'G', 'G', 'G', 'G', 'R', 'B', 'R', 'B'});
    }

    private  static void dutch_flag_sort(char[] balls) {
        int start = 0;
        int end = balls.length - 1;
        int index = 0;
        while(start <= end && index <= end){
            if(balls[index] == 'R') {
               swap(balls,start,index);
               index++;
               start++;
            } else if (balls[index] == 'G'){
                index++;
            } else {
                swap(balls,end,index);
                end--;
            }
        }
        for(char c : balls) System.out.print(c);
    }
    private static void swap(char[] balls, int i, int j){
        char temp = balls[i];
        balls[i] = balls[j];
        balls[j] = temp;
    }
}
