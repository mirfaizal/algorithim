package com.algorithim.datastructure.array;

public class RotateLeft {

    public static void main(String[] args) {
        int [] array = rotLeft(new int [] {1,2,3,4,5}, 4);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        array = rotRight(new int [] {1,2,3,4,5}, 4);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    static int [] rotRight(int [] a, int d){
        int length = a.length;
        int [] b = new int [length];
        for(int i=0; i<length; i++){
            int position = i + d;
            if(position >= length){
                position = position - length;
            }
            b[position] = a[i];
        }
        return b;
    }

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int length = a.length;
        int [] b = new int[length];
        for(int i=0;i<length;i++){
            int position = i - d;
            if(position < 0){
                position += length;
            }
            b[position] = a[i];
        }
        return b;
    }
}
