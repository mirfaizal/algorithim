package com.algorithim.datastructure.tree;

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
class BSTIteratorInOrder  {
    private Deque<TreeNode> stack;
    public BSTIteratorInOrder(TreeNode node){
        this.stack = new ArrayDeque<>();
        addAllLeftNodes(node,stack);
    }
    private void addAllLeftNodes(TreeNode node, Deque<TreeNode> stack) {
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    public TreeNode next(){
        if(hasMoreElements()){
            TreeNode node = stack.pop();
            addAllLeftNodes(node.right,stack);
            return node;
        }
        return null;
    }
    public boolean hasMoreElements(){
        return !stack.isEmpty();
    }
}

class BSTIteratorPostOrder  {
    private Deque<TreeNode> stack;
    public BSTIteratorPostOrder(TreeNode node){
        this.stack = new ArrayDeque<>();
        addAllLeftNodes(node,stack);
    }
    private void addAllLeftNodes(TreeNode node, Deque<TreeNode> stack) {
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    public TreeNode next(){
        if(hasMoreElements()){
            TreeNode node = stack.pop();
            addAllLeftNodes(node.right,stack);
            return node;
        }
        return null;
    }
    public boolean hasMoreElements(){
        return !stack.isEmpty();
    }
}

public class BSTIterator {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(3);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(25);
        node.right.right.right = new TreeNode(50);
        BSTIteratorInOrder bst = new BSTIteratorInOrder(node);
        while(bst.hasMoreElements()){
            TreeNode treeNode = bst.next();
            System.out.print(treeNode.val+" ");
        }
        postOrderIterative(node);
        preOrderIterative(node);
        inOrderIterative(node);
        find_height(node);
    }

    static int finalHeight = 0;
    static int find_height(TreeNode root)
    {
        dfsHelper(root);
        System.out.println();
        System.out.println(finalHeight);
        return finalHeight;
    }
    static int dfsHelper(TreeNode root){
        // Base Case
        if(root == null) return 0;
        int heightL = dfsHelper(root.left);
        int heightR = dfsHelper(root.right);
        int height = Math.max(heightL,heightR) + 1;
        finalHeight = Math.max(finalHeight, height);
        return height;
    }

    private static void postOrderIterative(TreeNode node) {
        Deque<TreeNode> stackOne = new ArrayDeque<>(), stackTwo = new ArrayDeque<>();
        stackOne.push(node);
        while (!stackOne.isEmpty()){
            TreeNode n1 = stackOne.pop();
            stackTwo.push(n1);
            if(n1.left != null) stackOne.push(n1.left);
            if(n1.right != null) stackOne.push(n1.right);
        }
        System.out.println();
        while(!stackTwo.isEmpty()){
            System.out.print(stackTwo.pop().val+" ");
        }
    }


    private static void preOrderIterative(TreeNode node) {
        Deque<TreeNode> stackOne = new ArrayDeque<>();
        stackOne.push(node);
        System.out.println();
        while (!stackOne.isEmpty()){
            TreeNode n1 = stackOne.pop();
            System.out.print(n1.val+" ");
            if(n1.right != null) stackOne.push(n1.right);
            if(n1.left != null) stackOne.push(n1.left);
        }
    }

    private static void inOrderIterative(TreeNode node) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        System.out.println();
        addAllLeftNode(node, stack);
        while(!stack.isEmpty()){
            TreeNode n1 = stack.pop();
            addAllLeftNode(n1.right,stack);
            System.out.print(n1.val+" ");
        }
    }

    private static void addAllLeftNode(TreeNode node, Deque<TreeNode> stackOne) {
        while( node != null){
            stackOne.push(node);
            node = node.left;
        }
    }
}
