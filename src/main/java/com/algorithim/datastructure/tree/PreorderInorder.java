package com.algorithim.datastructure.tree;

import java.util.HashMap;
import java.util.Map;

public class PreorderInorder {
    static Map<Integer, Integer> inorderMap = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private static TreeNode helper(int[] preorder, int startP, int endP, int[] inorder, int startI, int endI){
        if(startP > endP) return null;
        if(startP == endP) return new TreeNode(preorder[startP]);
        int index = inorderMap.get(preorder[startP]);
        TreeNode node = new TreeNode(preorder[startP]);
        int left = index - startI;
        node.left = helper(preorder, startP + 1, startP + left, inorder, startI, index - 1);
        node.right = helper(preorder, startP + left + 1, endP, inorder, index+1, endI);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println();
    }
}

// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder
// is the inorder traversal of the same tree, construct and return the binary tree.

//       startP          endP
//            v v  v v   v
// Preorder : X LEFT RIGHT
// Inorder  : LEFT X RIGHT
//            ^  ^ ^ ^   ^
//       startI  | index endI
//               |   |
//               |   endI - index
//               index - startI
// left = index - startI
// PreOrder
// startP + 1 , startP + left
// startP + left + 1, endP
