package com.algorithim.datastructure.string;

public class Permutation {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.isPermutation("abc1", "ab1c"));
        System.out.println(permutation.isPermutation("abc1", "a1cb"));
        System.out.println(permutation.isPermutation("abc1", "1cba"));
    }

    private boolean isPermutation(String stringOne, String stringTwo) {
        if (stringOne.length() != stringTwo.length()) return false;
        for (int index = 0; index < stringOne.length(); index++) {
            if(!isPresent(stringOne.charAt(index), stringTwo)){
                return false;
            }
        }
        return true;
    }

    private boolean isPresent(char character, String stringTwo) {
        boolean present = false;
        for (int index = 0; index < stringTwo.length(); index++) {
            if(stringTwo.charAt(index) == character){
                present = true;
            }
        }
        return present;
    }
}