package com.algorithim.datastructure.tree;
//1628. Design an Expression Tree With Evaluate Function

//Given the postfix tokens of an arithmetic expression, build and return the binary expression tree that represents this expression.
//Postfix notation is a notation for writing arithmetic expressions in which the operands (numbers) appear before their operators.
//For example, the postfix tokens of the expression 4*(5-(7+2)) are represented in the array postfix = ["4","5","7","2","+","-","*"].
//The class Node is an interface you should use to implement the binary expression tree.
//The returned tree will be tested using the evaluate function, which is supposed to evaluate the tree's value.
//You should not remove the Node class; however, you can modify it as you wish, and you can define other classes to implement it if needed.
//A binary expression tree is a kind of binary tree used to represent arithmetic expressions.
//Each node of a binary expression tree has either zero or two children.
//Leaf nodes (nodes with 0 children) correspond to operands (numbers),
//and internal nodes (nodes with two children) correspond to the operators '+' (addition), '-' (subtraction), '*' (multiplication), and '/' (division).
//It's guaranteed that no subtree will yield a value that exceeds 109 in absolute value, and all the operations are valid (i.e., no division by zero).
//Follow up: Could you design the expression tree such that it is more modular?
//For example, is your design able to support additional operators without making changes to your existing evaluate implementation?
//
//Example 1:
//Input: s = ["3","4","+","2","*","7","/"]
//Output: 2
//Explanation: this expression evaluates to the above binary tree with expression ((3+4)*2)/7) = 14/7 = 2.

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class ExpressionTree {

    public static void main(String[] args) {
        TreeBuilder treeBuilder = new TreeBuilder();
        Node node = treeBuilder.buildTree(new String[]{"3","4","+","2","*","7","/"});
        System.out.println(node.evaluate());
    }

    /**
     * This is the interface for the expression tree Node.
     * You should not remove it, and you can define some classes to implement it.
     */

    static abstract class Node {
        public abstract int evaluate();
    };

    static  Map<String, BiFunction<Integer, Integer, Integer>> operatorMap = Map.of(
            "+" , Integer::sum,
            "-" , (a , b) -> (a - b),
            "*" , (a , b) -> (a * b),
            "/" , (a , b) -> (a / b)
    );

    static class TreeNode extends Node {
        String value;
        TreeNode left , right;
        TreeNode(String value){
            this.value = value;
        }
        @Override
        public int evaluate(){
            return dfs(this);
        }
        private int dfs(TreeNode node){
            if(node.left == null && node.right == null){
                return Integer.parseInt(node.value);
            }
            int left = 0, right = 0;
            if(node.left != null) left = dfs(node.left);
            if(node.right != null) right = dfs(node.right);
            BiFunction<Integer,Integer,Integer> function = operatorMap.get(node.value);
            return function.apply(left,right);
        }
    }


    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    static class TreeBuilder {
        Stack<TreeNode> stack = new Stack<>();
        Node buildTree(String[] postfix) {
            for(String token : postfix){
                TreeNode node = new TreeNode(token);
                if(operatorMap.containsKey(token)){
                    node.right = stack.pop();
                    node.left = stack.pop();
                }
                stack.push(node);
            }
            return stack.peek();
        }
    };


    /**
     * Your TreeBuilder object will be instantiated and called as such:
     * TreeBuilder obj = new TreeBuilder();
     * Node expTree = obj.buildTree(postfix);
     * int ans = expTree.evaluate();
     */

}
