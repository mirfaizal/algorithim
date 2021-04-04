package com.algorithim.datastructure.sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DutchNationalFlag {

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(5, Comparator.comparingInt(o -> o));
        maxHeap.offer(4);


        //dutch_flag_sort(new char[] {'G','B','G','G','R','B','R','G'});
        dutch_flag_sort(new char[] {'B','R'});
        //dutch_flag_sort(new char[] {'G','B'});
    }

    public static void dutch_flag_sort(char[] balls) {
        int length = balls.length - 1;
        int redIndex = 0, blueIndex = length, i = 0, j = length;
        while(i <= length) {
            if(balls[i] != 'R') i++;
            else if(balls[i] == 'R' && i != redIndex){
                if(balls[i] != balls[redIndex]) swap(balls,i,redIndex);
                i++;
                redIndex++;
            } else if(balls[i] == 'R' && i == redIndex){
                i++;
                redIndex++;
            }
        }
        while(j >= 0){
            if(balls[j] != 'B') j--;
            else if(balls[j] == 'B' && j != blueIndex){
                if(balls[j] != balls[blueIndex]) swap(balls,j,blueIndex);
                j--;
                blueIndex--;
            }
            else if(balls[j] == 'B' && j == blueIndex){
                i++;
                redIndex++;
            }
        }

        for(char c : balls) System.out.print(c+" | ");
    }

    private static void swap(char [] balls , int i , int j){
        char temp = balls[i];
        balls[i] = balls[j];
        balls[j] = temp;
    }

}
