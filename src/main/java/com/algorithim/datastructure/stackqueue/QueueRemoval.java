package com.algorithim.datastructure.stackqueue;

import java.util.*;
import java.util.Queue;
// Add any extra import statements you may need here


class QueueRemoval {

    // Add any helper functions you may need here


    int[] findPositions(int[] arr, int x) {

        List<Integer> finalArray = new ArrayList<>();
        java.util.Queue<Integer> value = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            value.add(arr[i]);
            index.add(i);
        }
        for(int k=0;k<x;k++){
            int numberOfTimesToPop = x;
            List<Integer> valuePopped = new ArrayList<>();
            List<Integer> indexPopped = new ArrayList<>();
            int lastIndex = 0;
            while(numberOfTimesToPop-- != 0 && !value.isEmpty()){
                if(numberOfTimesToPop == x - 1) lastIndex = index.peek();
                valuePopped.add(value.remove());
                indexPopped.add(index.remove());
            }
            Integer itemToBeRemoved = 0;
            Integer indexToBeRemoved = 0;
            int currentIndex =0;
            boolean allSame = true;
            int itemK = valuePopped.get(0);
            for(int i=0;i<valuePopped.size();i++){
                if(itemToBeRemoved < valuePopped.get(i))   {
                    itemToBeRemoved = valuePopped.get(i);
                    indexToBeRemoved = indexPopped.get(i);
                    currentIndex =i;
                }
                if(itemK != valuePopped.get(i)){
                    allSame = false;
                }
            }
            if(allSame){
                currentIndex = 0;
                indexToBeRemoved = lastIndex;
            }
            finalArray.add(indexToBeRemoved + 1);
            valuePopped.remove(currentIndex);
            indexPopped.remove(indexToBeRemoved);
            for(int j=0;j<valuePopped.size();j++){
                int y = valuePopped.get(j);
                if(y > 0) {
                    y -= 1;
                }
                value.add(y);
                index.add(indexPopped.get(j));
            }
            System.out.println();
        }
        int [] finalArrayItems = new int [finalArray.size()];
        int indexT = 0;
        for(int i : finalArray){
            finalArrayItems[indexT++] = i;
        }
        return finalArrayItems;

    }












    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        int[] expected_1 = {5, 6, 4, 1, 2 };
        int[] output_1 = findPositions(arr_1, x_1);
        check(expected_1, output_1);

        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int[] expected_2 = {2, 5, 10, 13};
        int[] output_2 = findPositions(arr_2, x_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new QueueRemoval().run();
    }
}
