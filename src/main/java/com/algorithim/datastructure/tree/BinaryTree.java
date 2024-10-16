package com.algorithim.datastructure.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    class Node {
        int key;
        String value;
        Node left, right;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public void insert(int key, String value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, int key, String value) {
        Node newNode = new Node(key, value);
        if (node == null) {
            node = newNode;
            return node;
        }
        if (key < node.key) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    private String find(int key) {
        Node node = find(root, key);
        return (node == null) ? null : node.value;
    }

    private Node findNode(int key) {
        return find(root, key);
    }

    private Node find(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        } else if (key < node.key) {
            return find(node.left, key);
        } else {
            return find(node.right, key);
        }
    }


    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return root;
        } else if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // Special case
                Node findMinRight = findMinNode(node.right);
                node.key = findMinRight.key;
                node.value = findMinRight.value;
                node.right = delete(node.right, node.key);
            }
        }
        return node;
    }

    private Node findMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        if (node != null) {
            System.out.println(node.key + " : " + node.value);
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void preOrderTraverse(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.value);
            preOrderTraverse(prefix + (isLeft ? "|   " : "    "), n.left, true);
            preOrderTraverse(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    public void display() {
        preOrderTraverse(root);
        preOrderTraverse("", root, false);
    }

    // Lowest Common Ancestor
    private Node lcaRecursion(Node root, int v1, int v2) {
        if (v1 > root.key && v2 > root.key) {
            return lcaRecursion(root.right, v1, v2);
        } else if (v1 < root.key && v2 < root.key) {
            return lcaRecursion(root.left, v1, v2);
        }
        return root;
    }

    private Node lca(Node root, int v1, int v2) {
        if (v1 == v2) return findNode(v1);
        Stack<Node> pathToV1 = pathTo(root, v1);
        Stack<Node> pathToV2 = pathTo(root, v2);
        if (pathToV1 == null || pathToV2 == null) return null;
        Node curr = null;
        while (!pathToV1.isEmpty() && !pathToV2.isEmpty()) {
            Node one = pathToV1.pop();
            Node two = pathToV2.pop();
            if (one.key == two.key) curr = one;
            else break;
        }
        return curr;
    }

    private Stack<Node> pathTo(Node root, int n) {
        if (root == null) return null;
        if (root.key == n) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            return stack;
        }
        Stack<Node> stackLeft = pathTo(root.left, n);
        Stack<Node> stackRight = pathTo(root.right, n);
        if (stackLeft != null) {
            stackLeft.push(root);
            return stackLeft;
        }
        if (stackRight != null) {
            stackRight.push(root);
            return stackRight;
        }
        return null;
    }

    private boolean isSumFromRootToLeafExist(Node root, int sum) {
        if (root == null) return sum == 0;
        return isSumFromRootToLeafExist(root.left, sum - root.key) || isSumFromRootToLeafExist(root.right, sum - root.key);
    }

    List<List<Integer>> printPaths(Node node) {
        int path[] = new int[1000];
        List<List<Integer>> list = new ArrayList<>();
        printPathsRecur(node, path, 0, list);
        return list;
    }

    void printPathsRecur(Node node, int path[], int pathLen, List<List<Integer>> list) {
        if (node == null) return;
        path[pathLen] = node.key;
        pathLen++;
        if (node.left == null && node.right == null)
            addArray(path, pathLen, list);
        else {
            printPathsRecur(node.left, path, pathLen, list);
            printPathsRecur(node.right, path, pathLen, list);
        }
    }

    private void printAllPathFromRoot(Node root, List<StringBuilder> path, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.key);
        sb.append(",");
        if (root.left == null && root.right == null) {
            sb.append("---");
            path.add(sb);
        } else {
            printAllPathFromRoot(root.left, path, sb);
            printAllPathFromRoot(root.right, path, sb);
        }
    }

    void addArray(int ints[], int len, List<List<Integer>> list) {
        List<Integer> newList = new ArrayList<>();
        int i;
        for (i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
            newList.add(ints[i]);
        }
        System.out.println("");
        list.add(newList);
    }






    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
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
        binaryTree.display();
//        System.out.println(binaryTree.lcaRecursion(binaryTree.root, 12, 19).key);
//        System.out.println(binaryTree.lca(binaryTree.root, 12, 19).key);
//        System.out.println(binaryTree.isSumFromRootToLeafExist(binaryTree.root, 31));

        List<StringBuilder> path = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder();
        binaryTree.printAllPathFromRoot(binaryTree.root, path, sb1);
        List<List<Integer>> list = binaryTree.printPaths(binaryTree.root);
        binaryTree.delete(11);
        System.out.println();

    }
}