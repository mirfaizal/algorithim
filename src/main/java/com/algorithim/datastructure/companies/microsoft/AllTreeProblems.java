package com.algorithim.datastructure.companies.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllTreeProblems {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.left.right.right = new TreeNode(55);
        node.left.right.right.left = new TreeNode(53);
        node.left.right.right.right = new TreeNode(66);
        node.left.right.right.right.right = new TreeNode(77);
        node.left.right.right.right.left = new TreeNode(60);

        System.out.println(bstCount(node));
        System.out.println(bstHeight(node));
        printArray(levelOrder(node));
        System.out.println();
        printArray(levelOrderReversed(node));
        System.out.println();
        printArray(levelOrderZigZag(node));
    }

    private static void printArray(List<List<Integer>> array) {
        System.out.println();
        for (List<Integer> inner : array){
            for (int item : inner) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<List<Integer>> outer = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> inner = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode child = queue.poll();
                inner.add(child.val);
                if(child.left != null) queue.add(child.left);
                if(child.right != null) queue.add(child.right);
            }
            outer.add(inner);
        }
        return outer;
    }
    private static List<List<Integer>> levelOrderReversed(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<List<Integer>> outer = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> inner = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode child = queue.poll();
                inner.add(child.val);
                if(child.left != null) queue.add(child.left);
                if(child.right != null) queue.add(child.right);
            }
            Collections.reverse(inner);
            outer.add(inner);
        }
        return outer;
    }

    private static List<List<Integer>> levelOrderZigZag(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<List<Integer>> outer = new ArrayList<>();
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> inner = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode child = queue.poll();
                inner.add(child.val);
                if(child.left != null) queue.add(child.left);
                if(child.right != null) queue.add(child.right);
            }
            if(flag){
                Collections.reverse(inner);
                flag = false;
            } else {
                flag = true;
            }
            outer.add(inner);
        }
        return outer;
    }

    private static int bstHeight(TreeNode node) {
        if(node.left == null && node.right == null) return 1;
        var left = 0;
        var right = 0;
        if(node.left != null) {
            left = bstHeight(node.left);
        }
        if(node.right != null) {
            right = bstHeight(node.right);
        }
        return Math.max(left,right) + 1;
    }

    private static int bstCount(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        var count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode child = queue.poll();
                count++;
                if(child.left != null) queue.add(child.left);
                if(child.right != null) queue.add(child.right);
            }
        }
        return count;
    }
}
