package com.algorithim.datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TopBottomColumnView {

    static class TreeNode {
        int val;
        int colIndex;
        int rowIndex;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    static int minIndex = 0;
    static int maxIndex = 0;
    public static void main(String[] args) {
        TreeNode [] node =  new TreeNode[100];
        for(int i=0;i<100;i++){
            node[i] = new TreeNode(i);
        }
        node[1].left = node[2];
        node[1].right = node[3];
        node[2].left = node[4];
        node[2].right = node[5];
        node[3].left = node[6];
        node[3].right = node[7];
        node[5].right = node[55];
        node[55].right = node[66];
        node[66].right = node[77];
        minMax(node[1]);
        System.out.println(minIndex+" "+maxIndex);
        System.out.println();
        System.out.println("Col View -");
        for(int i=minIndex;i<=maxIndex;i++){
            for(TreeNode node1 : map.get(i)){
                System.out.print(node1.val+" ");
            }
            System.out.println();
        }
        System.out.println("Top View -");
        for(int i=minIndex;i<=maxIndex;i++){
            List<TreeNode> list = map.get(i);
            for(int j=0;j< list.size();j++){
                if(j==0)
                System.out.print(list.get(j).val+" ");
            }
        }
        System.out.println();
        System.out.println("Bottom View -");
        for(int i=minIndex;i<=maxIndex;i++){
            List<TreeNode> list = map.get(i);
            int max = Integer.MIN_VALUE;
            for(int j=0;j< list.size();j++){
                if(j==list.size()-1)
                    System.out.print(list.get(j).val+" ");
            }
        }
    }

    static Map<Integer, List<TreeNode>> map = new HashMap<>();
    private static void  minMax(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                minIndex = Math.min(minIndex, node.colIndex);
                maxIndex = Math.max(maxIndex, node.colIndex);
                if(node.left != null) {
                    node.left.colIndex = node.colIndex - 1;
                    node.left.rowIndex = node.rowIndex + 1;
                    queue.add(node.left);
                }
                if(node.right != null) {
                    node.right.colIndex = node.colIndex + 1;
                    node.right.rowIndex = node.rowIndex + 1;
                    queue.add(node.right);
                }
                if(!map.containsKey(node.colIndex)) {
                    List<TreeNode> list = new ArrayList<>();
                    list.add(node);
                    map.put(node.colIndex,list);
                } else {
                    map.get(node.colIndex).add(node);
                }
            }
        }

    }

}

/*
Return Top View of binary tree.
      0
       1
     /    \
    2        3
  / \      /    \
 4   5,   6      7
      \
       55
        \
         66
          \
            77

                   -2,-1,0,1,2,3  return (-2,3)
                   return Top View[4, 2,1,3,7,77]
                   bottom view [4 2 6 55 66 77]
                   column view[ [4],  [2], [1,5,6], [3,55], [7,66], [77]]
                   {min_column_index, max_column_index)

*/
