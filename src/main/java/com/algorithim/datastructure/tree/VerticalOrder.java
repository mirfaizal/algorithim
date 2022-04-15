package com.algorithim.datastructure.tree;


// https://leetcode.com/problems/binary-tree-vertical-order-traversal/
// Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
//
//If two nodes are in the same row and column, the order should be from left to right.
//
//Example 1:
//
//Input: root = [3,9,20,null,null,15,7]
//Output: [[9],[3,15],[20],[7]]
//Example 2:
//
//Input: root = [3,9,8,4,0,1,7]
//Output: [[4],[9],[3,0,1],[8],[7]]
//Example 3:
//
//Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
//Output: [[4],[9,5],[3,0,1],[8,2],[7]]

import java.util.*;

public class VerticalOrder  {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.right.left = new TreeNode(3);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(25);
        treeNode.right.right.right = new TreeNode(50);
        List<List<Integer>> nodes = verticalOrder(treeNode);
        for(List<Integer> inner : nodes){
            for(Integer item : inner){
                System.out.print(item+",");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.add(new Pair(root, 0));
        List<Integer> aList = new ArrayList<>();
        aList.add(root.val);
        map.put(0,aList);
        int maxLevel = 100;
        int minLevel = -100;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair pair = queue.remove();
                TreeNode node = pair.node;
                int verticalLevel = pair.level;
                if(node.left != null){
                    int myVerticalLevel = verticalLevel - 1;
                    queue.add(new Pair(node.left, myVerticalLevel));
                    List<Integer> list;
                    if(map.get(myVerticalLevel) == null){
                        list = new ArrayList<>();
                        list.add(node.left.val);
                    } else {
                        list = map.get(myVerticalLevel);
                        list.add(node.left.val);
                    }
                    map.put(myVerticalLevel,list);
                    minLevel = Math.min(minLevel,myVerticalLevel);
                }
                if(node.right != null){
                    int myVerticalLevel = verticalLevel + 1;
                    queue.add(new Pair(node.right, myVerticalLevel));
                    List<Integer> list;
                    if(map.get(myVerticalLevel) == null){
                        list = new ArrayList<>();
                        list.add(node.right.val);
                    } else {
                        list = map.get(myVerticalLevel);
                        list.add(node.right.val);
                    }
                    map.put(myVerticalLevel,list);
                    maxLevel = Math.max(maxLevel,myVerticalLevel);
                }
            }
        }
        for(int i = minLevel; i<= maxLevel; i++){
            if(map.get(i) != null)
                result.add(map.get(i));
        }
        return result;
    }
    static class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
}
