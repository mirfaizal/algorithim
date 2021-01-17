package com.algorithim.datastructure.tree;

public class AllBinaryTreeProblems {

    final class Node {
        Node left , right;
        int key;
        String value;
        Node(int key, String value){
            this.key = key;
            this.value = value;
        }
    }
    enum Order {
        PRE_ORDER, IN_ORDER, POST_ORDER, LEVEL_ORDER, VERTICAL_ORDER
    }
    private Node root;
    private void insert(int key, String value){
        root = insert(root, key, value);
    }

    private Node insert(Node root, int key, String value) {
        if(root == null) {
            root = new Node(key,value);
            return root;
        } else if(root.key < key){
            root.right = insert(root.right,key,value);
        } else if(root.key > key){
            root.left = insert(root.left,key,value);
        }
        return root;
    }

    private String find(int key){
        Node node = find(root,key);
        return node == null? "Key is not present" : node.value;
    }

    private Node find(Node root, int key) {
        if(root == null || key == root.key){
            return root;
        }else if(root.key < key){
            return find(root.right, key);
        }else if(root.key > key){
            return find(root.left, key);
        }
        return root;
    }

    private void delete(int key){
        root = delete(root, key);
    }

    private Node findMin(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    private Node delete(Node node, int key) {
        if(node == null){
            return node;
        } else if(node.key < key){
            node.right = delete(node.right,key);
        } else if(node.key > key){
            node.left = delete(node.left,key);
        } else {
            if(node.left == null && node.right == null){
                node = null;
            } else if (node.left == null){
                node = node.right;
            } else if (node.right == null){
                node = node.left;
            } else {
                // Find min
                Node min = findMin(node.right);
                node.key = min.key;
                node.value = min.value;
                node.right = delete(node.right,node.key);
            }
        }
        return node;
    }

    private void print(Order order){
        switch (order){
            case PRE_ORDER:  preOrderTraversal(root); break;
            case IN_ORDER : inOrderTraversal(root); break;
            case POST_ORDER : postOrderTraversal(root); break;
            case LEVEL_ORDER : levelOrderTraversal(root); break;
            case VERTICAL_ORDER : verticalOrderTraversal(root); break;
        }
    }

    private void verticalOrderTraversal(Node root) {

    }

    private void levelOrderTraversal(Node root) {
    }

    private void postOrderTraversal(Node root) {
        if(root != null){
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
            System.out.println(root.key+" : "+root.value);
        }
    }

    private void inOrderTraversal(Node root) {
        if(root != null){
            inOrderTraversal(root.left);
            System.out.println(root.key+" : "+root.value);
            inOrderTraversal(root.right);
        }
    }

    private void preOrderTraversal(Node root) {
        if(root != null){
            System.out.println(root.key+" : "+root.value);
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
        }
    }

    private int lowestCommonAncestor(int v1, int v2) {
        return lca(root,v1,v2);
    }

    private int lca(Node root, int v1, int v2) {
        if(v1 > root.key && v2 > root.key){
            return lca(root.right, v1, v2);
        } else if(v1 < root.key && v2 < root.key){
            return lca(root.left, v1, v2);
        }
        return root.key;
    }

    private boolean pathToSum(int sum) {
        return pts(root,sum);
    }

    private boolean pts(Node root, int sum) {
        if(root == null) return sum == 0;
        return pts(root.left, sum - root.key) || pts(root.right, sum - root.key);
    }

    private void leftView() {

    }

    public static void main(String[] args) {
        AllBinaryTreeProblems binaryTree = new AllBinaryTreeProblems();
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
        binaryTree.print(Order.IN_ORDER);
        System.out.println();
        binaryTree.print(Order.PRE_ORDER);
        System.out.println();
        binaryTree.print(Order.POST_ORDER);
//        System.out.println(binaryTree.lowestCommonAncestor(5,8));
//        System.out.println(binaryTree.lowestCommonAncestor(18,8));
//        System.out.print(binaryTree.pathToSum(32));
        binaryTree.leftView();

    }




}
