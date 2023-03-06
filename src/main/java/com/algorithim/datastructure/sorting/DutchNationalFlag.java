package com.algorithim.datastructure.sorting;


public class DutchNationalFlag {
//    Dutch National Flag
//    Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.
//    Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.
//    This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra.
//    Dutch national flag has three colors (albeit different from ones used in this problem).
//    Example
//    Input: [G, B, G, G, R, B, R, G]
//    Output: [R, R, G, G, G, G, B, B]
//    There are a total of 2 red, 4 green and 2 blue balls. In this order they appear in the correct output.
//    Notes
//    Input Parameters: An array of characters named balls, consisting of letters from {‘R’, ‘G’, ‘B’}.
//    Output: Return type is void. Modify the input character array by rearranging the characters in-place.

    public static void main(String[] args) {

//        dutch_flag_sort(new char[] {'G','B','G','G','R','B','R','G'});
//        dutch_flag_sort(new char[] {'B','R'});
//        dutch_flag_sort(new char[] {'G','B'});
//        dutch_flag_sort(new char[] {'G','R','G'});
        dutch_flag_sort1(new char[] {'R','R','G','B','B','B','B','R','G','G','G','G'});



    }

    private static void dutch_flag_sort1(char[] balls) {
        int left = 0;
        int i = 0;
        int right = balls.length - 1;
        while(i <= right){
            if(balls[i] == 'R'){
                swap(balls,i,left);
                i++;left++;
            } else if(balls[i] == 'G'){
                i++;
            } else {
                swap(balls,i,right);
                right--;
            }
        }
    }

    private static void dutch_flag_sort(char[] balls) {
        int r = 0;
        int b = balls.length - 1;
        int i = 0;
        int j = balls.length - 1;
        while (i < j ){
            if(balls[r] != 'R' && r < balls.length - 1) r++;
            else if(balls[i] != 'R' && balls[r] == 'R'){
                swap(balls,i,r);
                i++;
            }
            else if(balls[b] != 'B' && b > 0) b--;
            else if(balls[j] != 'B' && balls[b] == 'B'){
                swap(balls,j,b);
                j--;b--;
            } else {
                i++;j--;
            }
        }
        for(char c: balls)
        System.out.print(c+" ");

        System.out.println();
    }

    private static void swap(char [] balls , int i , int j){
        char temp = balls[i];
        balls[i] = balls[j];
        balls[j] = temp;
    }
}
