package com.algorithim.datastructure.recursion;

import java.util.List;


/**

 Generate All Possible Expressions That Evaluate To The Given Target Value
 Given a string s that consists of digits ("0".."9") and target, a non-negative integer, find all expressions that can be built
 from string s that evaluate to the target.

 When building expressions, you have to insert one of the following operators between each pair of consecutive characters in s: join or * or +.
 For example, by inserting different operators between the two characters of string "12" we can get either 12 (1 joined with 2 or "12") or 2 ("1*2") or 3 ("1+2").

 Other operators such as - or ÷ are NOT supported.

 Expressions that evaluate to the target but only utilize a part of s do not count: entire s has to be consumed.

 Precedence of the operators is conventional: join has the highest precedence, * – medium and + has the lowest precedence.
 For example, 1 + 2 * 34 = (1 + (2 * (34))) = 1 + 68 = 69.

 You have to return ALL expressions that can be built from string s and evaluate to the target.

 Example
 {
 "s": "202",
 "target": 4
 }
 Output:

 ["2+0+2", "2+02", "2*02"]

 */
import java.util.*;

public class ExpressionOperators {
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        List<String> result = generate_all_expressions("222",-20);
        printResult(result);
    }
    static void printResult(List<String> result){
        for(String s : result) System.out.print(s+" , ");
    }

    static List<String> generate_all_expressions(String s, long target) {
        StringBuilder slate = new StringBuilder();
        slate.append(s.charAt(0));
        helper(s,1,slate,target,0,1,Long.parseLong(String.valueOf(s.charAt(0))));
        return result;
    }
    static void helper(String s, int index, StringBuilder slate, long target, long sum, long product,  long previousLastNumber){
        //Base Case
        if(index == s.length()) {
            if((sum + previousLastNumber * product) == target){
                result.add(slate.toString());
            }
            return;
        }

        // Recursion Case

        // Join Case
        long runningNumber = Long.parseLong(String.valueOf(s.charAt(index)));
        slate.append(s.charAt(index));
        helper(s,index+1,slate,target,sum,product,previousLastNumber * 10 + runningNumber);
        slate.setLength(slate.length() - 1);
        // * Case
        slate.append("*");
        slate.append(s.charAt(index));
        helper(s,index+1,slate,target,sum,previousLastNumber * product, runningNumber);
        slate.setLength(slate.length() - 2);
        // + Case
        slate.append("+");
        slate.append(s.charAt(index));
        helper(s,index+1,slate,target,sum + previousLastNumber * product,1, runningNumber);
        slate.setLength(slate.length() - 2);
        // - Case
        slate.append("-");
        slate.append(s.charAt(index));
        helper(s,index+1,slate,target,sum + previousLastNumber * product,1, runningNumber);
        slate.setLength(slate.length() - 2);


    }
}
