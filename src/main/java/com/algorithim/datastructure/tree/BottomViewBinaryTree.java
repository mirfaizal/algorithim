package com.algorithim.datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BottomViewBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left , right;
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
        node.left.right.right.right = new TreeNode(66);
        node.left.right.right.right.right = new TreeNode(77);
        List<Integer> bottomView = bottomView(node);
        for(Integer bottomNode : bottomView){
            System.out.print(bottomNode+" ");
        }
    }

    private static List<Integer> bottomView(TreeNode node) {
        class TreeNodeWithPair {
            TreeNode node;
            int col;
            int row;
            TreeNodeWithPair(TreeNode node, int col, int row){
                this.node = node;
                this.col = col;
                this.row = row;
            }
        }
        Queue<TreeNodeWithPair> queue = new LinkedList<>();
        queue.add(new TreeNodeWithPair(node,0,0));
        Map<Integer, List<TreeNodeWithPair>> map = new HashMap<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNodeWithPair nodeWithPair = queue.poll();
                assert nodeWithPair != null;
                TreeNode childNode = nodeWithPair.node;
                if(childNode.left != null) {
                    queue.add(new TreeNodeWithPair(childNode.left,nodeWithPair.col - 1, nodeWithPair.row + 1));
                }
                if(childNode.right != null) {
                    queue.add(new TreeNodeWithPair(childNode.right,nodeWithPair.col + 1, nodeWithPair.row + 1));
                }
                if(!map.containsKey(nodeWithPair.col)) {
                    List<TreeNodeWithPair> list = new ArrayList<>();
                    list.add(nodeWithPair);
                    map.put(nodeWithPair.col, list);
                } else {
                    map.get(nodeWithPair.col).add(nodeWithPair);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, List<TreeNodeWithPair>> entry : map.entrySet()) {
            List<TreeNodeWithPair> list = entry.getValue();
            for(int i=0;i< list.size();i++) {
                if(i == list.size() - 1)
                    result.add(list.get(i).node.val);
            }
        }
        return result;
    }
}
