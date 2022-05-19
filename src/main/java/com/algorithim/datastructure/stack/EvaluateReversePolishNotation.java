package com.algorithim.datastructure.stack;

//150. Evaluate Reverse Polish Notation  (Medium)
//
//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
//
//Note that division between two integers should truncate toward zero.
//
//It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
//
//Example 1:
//
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation {
    static Map<String , BiFunction<Integer,Integer,Integer>> operatorMap = Map.of(  "+", Integer::sum,
                                                                                    "-", (a, b) -> a - b,
                                                                                    "*",(a, b) -> a * b,
                                                                                    "/",(a, b) -> a / b);
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(operatorMap.get(token) == null){
                stack.push(Integer.parseInt(token));
                continue;
            }
            int number2 = stack.pop();
            int number1 = stack.pop();
            BiFunction<Integer,Integer,Integer> function = operatorMap.get(token);
            int result = function.apply(number1,number2);
            stack.push(result);
        }
        return stack.peek();
    }
}
