package com.algorithim.datastructure.misc;

public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int [] array = new int[]{4,2,4,0,0,3,0,5,1,0};
        moveZeros.moveZeroEnd(array);
        for (int n : array){
            System.out.print(n);
        }
        System.out.println("-------");
        array = new int[]{4,2,4,0,0,3,0,5,1,0};
        moveZeros.moveZeroBeginning(array);
        for (int n : array){
            System.out.print(n);
        }

    }

    public void moveZeroEnd(int [] num){
        int index = 0;
        for(int i=0; i< num.length; i++){
            if(num[i] != 0){
                num[index++] = num[i];
            }
        }
        for(int i=index; i<num.length; i++){
            num[index++] = 0;
        }
    }

    public void moveZeroBeginning(int [] num){
        int index = num.length - 1;
        for(int i=num.length - 1; i>= 0; i--){
            if(num[i] != 0){
                num[index--] = num[i];
            }
        }
        for(int i=index; i>=0; i--){
            num[index--] = 0;
        }
    }
}
