package com.algorithim.datastructure.string;

public class StepQuestion {
    public static void main(String[] args) {
        StepQuestion stepQuestion = new StepQuestion();
        stepQuestion.steps2DArray(10);
        // stepQuestion.stepsRecursion(4);
    }

    private void step(int number) {
        for (int row = 1; row <= number; row++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int col = 1; col <= row; col++) {
                stringBuilder.append(getSteps(col, row));
            }
            System.out.println(stringBuilder.toString());
        }

    }

    private String getSteps(int n, int numberOfStep) {
        StringBuilder stringBuilder = new StringBuilder();
        if (numberOfStep == n) {
            stringBuilder.append("'");
            for (int i = 1; i <= n; i++) {
                stringBuilder.append("#");
            }
            stringBuilder.append("'\n");
        } else {
            stringBuilder.append("'");
            for (int i = 1; i <= n; i++) {
                stringBuilder.append("#");
            }
            int numberOfSpaces = numberOfStep - n;
            for (int i = 1; i <= numberOfSpaces; i++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("'\n");
        }
        return stringBuilder.toString();
    }

//    private void stepsRecursion(int number){
//        if(number == 0){
//            return;
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("'");
//        for(int col = 0; col<number; col++){
//            if(number >=col){
//                stringBuilder.append("#");
//            }else{
//                stringBuilder.append(" ");
//            }
//        }
//        stringBuilder.append("'\n");
//        System.out.println(stringBuilder.toString());
//        stepsRecursion(number - 1);
//    }


    private void steps2DArray(int number){
        StringBuilder stringBuilder = new StringBuilder();
        for(int row=0;row<number;row++){
            stringBuilder.append("'");
            for(int col = 0; col<number; col++){
                if(row >=col){
                    stringBuilder.append("#");
                }else{
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("'\n");
        }
        System.out.println(stringBuilder.toString());
    }



}
