package com.algorithim.datastructure.tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthClosesElementInBST {
    static class Node
    {
        int key;
        Node  left,  right;
        Node(int key)
        {
            this.key = key;
        }
    }
    static List<Integer> result = new ArrayList<>();
    public static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        result.add(node.key);
        inorder(node.right);
    }

    public static void main(String args[])
    {
        Node  root = new Node(9);
        root.left    = new Node(4);
        root.right   = new Node(17);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(7);
        root.right.right = new Node(22);
        root.right.right.left = new Node(20);
        inorder(root);
        System.out.println(kthClosesElementInBST(4));
        System.out.println(kthClosesElementInBST(18));
        System.out.println(kthClosesElementInBST(12));
    }

    public static int kthClosesElementInBST(int k){
        List<Integer> diff = new ArrayList<>();
        for(int i : result){
            diff.add(Math.abs(k-i));
        }
        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for(int i=0;i<diff.size();i++){
            if(min > diff.get(i)) {
                min = diff.get(i);
                min_index = i;
            }
        }
        return result.get(min_index);
    }
}
