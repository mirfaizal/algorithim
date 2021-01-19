package com.algorithim.datastructure.array;

public class ArrayChunk {
    public static void main(String[] args) {
        ArrayChunk arrayChunk = new ArrayChunk();
        arrayChunk.chunk(new int [] {1,2,3,4,5,6,7,8,9,10,11,12}, 3);
    }

    private int [][] chunk(int[] array, int chunkSize) {
        int numberOfArray = (int) Math.ceil(array.length / chunkSize);
        int [][] chunkedArray = new int[numberOfArray][];
        int start = 0;
        for(int i = 0 ; i < numberOfArray ; ++i){
            start = i * chunkSize;
            int length = Math.min(array.length - start, chunkSize);
            int [] temp = new int[length];
            //System.arraycopy(array,start,temp,0,length);

            for(int index = 0; index<length; index++){
                temp[index] = array[index + start];
            }
            chunkedArray[i] = temp;
        }
        return chunkedArray;
    }
}
