package com.basicjava;

public class UserInput {

    public static class TextInput {
        StringBuilder sb = new StringBuilder();
        void add(char c){
            sb.append(c);
        }
        String getValue(){
            return sb.toString();
        }
    }

    public static class NumericInput extends TextInput{
        void add(char c){
            if(Character.isDigit(c)) sb.append(c);
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
