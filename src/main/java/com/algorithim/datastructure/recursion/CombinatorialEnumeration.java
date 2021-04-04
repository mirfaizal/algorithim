package com.algorithim.datastructure.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class CombinatorialEnumeration {
    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(5,(a,b)->(a-b));


        Map<Integer, String> phoneMap = new HashMap<>();
        phoneMap.put(1,"A");
        System.out.println(phoneMap.get(Integer.valueOf(String.valueOf('1'))));
        String c = "madam";
        c.indexOf("ma");
        char [] str = new char[] {'C'};
        int j = str.length;
        for(int i=0;i<str.length / 2;i++){
            if(str[i] != str[j]) {

            }
        }


        // binaryString(4);
        // decimalString(3);
        // permutationNoRepetition("123");
         // setOfAllSubSets("123");
//        List<String> result =  letterCasePermutation("abc");
//        for(String s : result) System.out.println(s);

//        List<List<Integer>> k = subsets(new int[] {1,2,3});
//        for(List<Integer> list : k) {
//            System.out.println(list.size());
//        }

        get_distinct_subsets("aaaa");
    }



    // Complete the function below.
    public static List<String> get_distinct_subsets(String str) {
        List<String> result = new ArrayList<>();
        if(str == null || str.length() == 0) return result;
        List<String> problemDef = new ArrayList<>();
        for(int i=0; i<str.length();i++) problemDef.add(String.valueOf(str.charAt(i)));
        // Sort items
        Collections.sort(problemDef);
        get_distinct_subsets(0, new Stack() , problemDef, result);
        return result;
    }

    private static void get_distinct_subsets(int index, Stack<String> partialSolution, List<String> problemDef, List<String> result) {
        // Base Case : Leaf node work
        if(index == problemDef.size()){
            StringBuilder sb = new StringBuilder();
            Enumeration enu = partialSolution.elements();
            while (enu.hasMoreElements()) {
                sb.append(enu.nextElement());
            }
            result.add(sb.toString());
            return;
        }
        // Recursive Case : Internal node work
        // Count the repeatitive items
        int count = 0;
        for(int i=index; i<problemDef.size(); i++){
            if(!problemDef.get(index).equals(problemDef.get(i))) break;
            count++;
        }
        // I have a choice to include or exclude combination
        // Exclude
        get_distinct_subsets(index + count, partialSolution, problemDef, result);
        // Multiway Inclusion
        for(int i=0; i<count; i++){
            partialSolution.push(problemDef.get(index));
            get_distinct_subsets(index + count, partialSolution, problemDef, result);
        }
        // Clear the stack
        for(int i=0; i<count; i++){
            partialSolution.pop();
        }
        //partialSolution.setLength(partialSolution.length() - count);
    }



    public static List<List<Integer>> subsets(int[] nums) {
        return subsets(0, nums, new Stack<>(),  new ArrayList<>());
    }
    public  static List<List<Integer>> subsets(int index, int[] nums, Stack<Integer> slate, List<List<Integer>> result) {
        result.add(new ArrayList<>(slate));

        for(int i = index; i< nums.length; i++){
            slate.push(nums[i]);
            subsets(i + 1, nums, slate, result);
            slate.pop();
        }

        return result;
    }

    private static List<String> letterCasePermutation(String str) {
        return letterCasePermutation(new StringBuilder(),str,new ArrayList<>());
    }

    private static List<String> letterCasePermutation(StringBuilder slate, String str, List<String> result) {
        if(str.length() == 0) {
            result.add(slate.toString());
        }
        else {
            if(Character.isDigit(str.charAt(0))){
                letterCasePermutation(slate.append(str.charAt(0)), str.substring(1),result);
            } else {
                letterCasePermutation(slate.append(Character.toLowerCase(str.charAt(0))), str.substring(1),result);
                slate.setLength(slate.length() - 1);
                letterCasePermutation(slate.append(Character.toUpperCase(str.charAt(0))), str.substring(1),result);
            }
            slate.setLength(slate.length() - 1);
        }
        return result;
    }

    private static void setOfAllSubSets(String array) {
        setOfAllSubSets("", array);
    }

    private static void setOfAllSubSets(String slate, String array) {
        int n = array.length();
        if(n == 0) System.out.println(slate);
        else {
            setOfAllSubSets(slate,array.substring(1));
            setOfAllSubSets(slate + array.charAt(0),array.substring(1));
        }
    }


    private static void permutationNoRepetition(String str) {
        permutationNoRepetition("", str);
    }

    private static void permutationNoRepetition(String state, String array) {
        int n = array.length();
        if(n == 0)System.out.println(state);
        else{
            for(int i= 0;i<n  ;i++){
                permutationNoRepetition(state + array.charAt(i), array.substring(0,i) + array.substring(i+1));
            }
        }
    }

    private static void binaryString(int n) {
        binaryStringHelper("", n);
    }

    // Using DFS, Time : O(2^n), Space : O(n)
    private static void binaryStringHelper(String state, int n) {
        if (n == 0) System.out.println(state);
        else {
            binaryStringHelper(state + "0", n - 1);
            binaryStringHelper(state + "1", n - 1);
        }
    }

    private static void decimalString(int n) {
        decimalStringHelper("", n);
    }

    // Using DFS, Time : O(10^n), Space : O(n)
    private static void decimalStringHelper(String state, int n) {
        if (n == 0) System.out.println(state);
        else {
            for (int i = 0; i < 10; i++)
                decimalStringHelper(state + i, n - 1);
        }
    }
}
