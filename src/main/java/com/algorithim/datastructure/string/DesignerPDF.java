package com.algorithim.datastructure.string;

public class DesignerPDF {
    public static void main(String[] args) {
        String word = "ABC";
        char [] array = word.toCharArray();
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
            System.out.println(array[i] - 65);
        }
    }
}
