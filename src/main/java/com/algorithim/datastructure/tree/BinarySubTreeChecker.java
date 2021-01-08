package com.algorithim.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 Given two non-empty binary trees s and t, check whether tree t has exactly the same structure
 and node values with a subtree of s.
 A subtree of s is a tree consists of a node in s and all of this node's descendants.
 The tree s could also be considered as a subtree of itself.
 */

public class BinarySubTreeChecker {
    static class Node {
        String data;
        int key;
        Node left;
        Node right;
        Node(int key, String data){
            this.data = data;
            this.key = key;
        }
    }
    private Node root = null;
    private void insert(int key, String data){
        root = insert(root, data, key);
    }

    private Node insert(Node root, String data, int key) {
        Node newNode = new Node(key, data);
        if(root == null){
            root = newNode;
            return root;
        }
        if(key > root.key){
            root.right = insert(root.right,data, key);
        } else if (key < root.key) {
            root.left = insert(root.left, data, key);
        }
        return root;
    }

    private Node find(int key){
        return find(root, key);
    }

    private Node find(Node root, int key) {
        if(root == null || root.key == key) return root;
        else if(key > root.key){
            return find(root.right, key);
        } else {
            return find(root.left, key);
        }
    }
    private boolean subTreeChecker(Node nodeOne, Node nodeTwo){
        if(nodeOne == null || nodeTwo == null) return false;
        List<Node> nodesOne = new ArrayList<>();
        List<Node> nodesTwo = new ArrayList<>();
        preOrder(nodeOne, nodesOne);
        preOrder(nodeTwo, nodesTwo);
        return nodesOne.containsAll(nodesTwo);
    }

    private void preOrder(Node root, List<Node> list) {
        if(root != null) {
            list.add(root);
            //System.out.print(root.key+" : "+root.data+" ");
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    public static void main(String[] args) {
        BinarySubTreeChecker binaryTree = new BinarySubTreeChecker();
        binaryTree.insert(11, "Faizal");
        binaryTree.insert(2, "Claudia");
        binaryTree.insert(14, "Jenne");
        binaryTree.insert(4, "Marsha");
        binaryTree.insert(6, "Daniel");
        binaryTree.insert(18, "Anna");
        binaryTree.insert(19, "Nora");
        binaryTree.insert(8, "Ping Ping");
        binaryTree.insert(1, "Kate");
        binaryTree.insert(3, "Rachel");
        binaryTree.insert(5, "Carme");
        binaryTree.insert(12, "Jamie");
        System.out.println(binaryTree.subTreeChecker(binaryTree.find(11), binaryTree.find(2)));
        System.out.println(binaryTree.subTreeChecker(binaryTree.find(2), binaryTree.find(4)));
        System.out.println(binaryTree.subTreeChecker(binaryTree.find(11), binaryTree.find(6)));
        System.out.println(binaryTree.subTreeChecker(binaryTree.find(11), binaryTree.find(50)));
    }
}
