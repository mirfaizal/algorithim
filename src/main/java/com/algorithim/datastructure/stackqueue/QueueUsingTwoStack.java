package com.algorithim.datastructure.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStack {

    static Stack<Integer> one = new Stack<>();
    static Stack<Integer> two = new Stack<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter number of command you want : ");
        int numberOfCommand = in.nextInt();
        System.out.println();
        for(int i=0;i<numberOfCommand;i++){
            System.out.print("1 Add 2 Poll 3 Peek :");
            int command = in.nextInt();
            System.out.println();
            switch(command){
                case 1 : System.out.print("Data to be added: "); add(in.nextInt()); break;
                case 2 : System.out.print("Data polled: "+poll()); break;
                case 3 : peek(); break;
                default: System.out.print("Wrong choice"); break;
            }
        }
    }

    private static void peek() {
        while(!one.isEmpty()){
            two.push(one.pop());
        }
        if(!two.isEmpty()){
            System.out.print("Data at peek :"+two.peek());
        }
    }

    private static String poll() {
        while(!one.isEmpty()){
            two.push(one.pop());
        }
        int data=Integer.MIN_VALUE;
        if(!two.isEmpty()) data = two.pop();
        return String.valueOf(data);
    }

    private static void add(int data) {
        one.push(data);
    }


}
