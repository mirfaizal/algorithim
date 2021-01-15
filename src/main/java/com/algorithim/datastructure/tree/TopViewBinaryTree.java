package com.algorithim.datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopViewBinaryTree {
    final class Node {
        int key;
        String value;
        Node left, right;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    private void insert(int key, String value) {
        root = insert(root, key, value);
    }

    private Node insert(Node root, int key, String value) {
        Node node = new Node(key, value);
        if (root == null) {
            root = node;
            return root;
        } else if (root.key < key) {
            root.right = insert(root.right, key, value);
        } else if (root.key > key) {
            root.left = insert(root.left, key, value);
        }
        return root;
    }

    private String find(int key) {
        Node node = find(root, key);
        return node == null ? null : node.value;
    }

    private Node find(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        } else if (root.key < key) {
            return find(root.right, key);
        } else if (root.key > key) {
            return find(root.left, key);
        }
        return root;
    }

    private Map<Integer, List<Integer>> vertical() {
        Map<Integer, List<Integer>> horizontalMap = new HashMap<>();
        int horizontalDistance = 0;
        vertical(root, horizontalMap, horizontalDistance);
        return horizontalMap;
    }

    private void vertical(Node root, Map<Integer, List<Integer>> horizontalMap, int horizontalDistance) {
        if(horizontalMap.get(horizontalDistance) == null){
            horizontalMap.put(horizontalDistance,new ArrayList<>());
        }
        horizontalMap.get(horizontalDistance).add(root.key);
        if(root.left != null) vertical(root.left,horizontalMap,horizontalDistance - 1);
        if(root.right != null) vertical(root.right,horizontalMap,horizontalDistance + 1);
    }

    private List<Integer> levelOrderTraversal(){
        List<Integer> visited = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(!visited.contains(node.key)) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                visited.add(node.key);
            }
        }
        return visited;
    }

    private static Integer getItemFromBFSArray(List<Integer> verticalMap, List<Integer> levelOrder) {
        for(int i=0;i<levelOrder.size();i++){
            for(int j=0;j<verticalMap.size(); j++){
                if(levelOrder.get(i) == verticalMap.get(j)){
                    return verticalMap.get(j);
                }
            }
        }
        return null;
    }



    private List<Integer> getTopView(){
        Map<Integer, List<Integer>> map = vertical();
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        List<Integer> bfs = levelOrderTraversal();
        List<Integer> topView = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(map.get(array[i]).size() == 1){
                topView.add(map.get(array[i]).get(0));
            }else if(map.get(array[i]).size() >= 1){
                topView.add(getItemFromBFSArray(map.get(array[i]),bfs));
            }
        }
        return  topView;
    }

    public static void main(String[] args) {
        TopViewBinaryTree binaryTree = new TopViewBinaryTree();
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
        List<Integer> topView = binaryTree.getTopView();
        System.out.println("Top View : ");
        for(int item : topView) System.out.print(item+" ");
        System.out.println();
        System.out.println("Level Order Traversal : ");
        for(int item : binaryTree.levelOrderTraversal()) System.out.print(item+" ");
    }
}
