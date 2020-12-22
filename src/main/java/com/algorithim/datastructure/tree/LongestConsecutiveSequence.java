package com.algorithim.datastructure.tree;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        lcs.insert(50, "Faizal");
        lcs.insert(30, "Ali");
        lcs.insert(20, "Mir");
        lcs.insert(21, "Mir1");
        lcs.insert(22, "Mir2");
        lcs.insert(40, "Samiya");
        lcs.insert(70, "Shaikh");
        lcs.insert(60, "Faris");
        lcs.insert(80, "Jonefa");
        System.out.println(lcs.longestConsecutiveSequence(lcs.root));
        lcs.display();
        lcs.delete(22);
        System.out.println(lcs.longestConsecutiveSequence(lcs.root));
        lcs.display();
    }

    private int longestConsecutiveSequence(Node node) {
        int[] max = new int[1];
        longestConsecutiveSequence(node, 0, 0, max);
        return max[0];
    }

    private void longestConsecutiveSequence(Node node, int value, int target, int[] max) {
        if (node == null) {
            return;
        } else if (node.key == target) {
            value++;
        } else {
            value = 1;
        }
        max[0] = Math.max(max[0], value);
        longestConsecutiveSequence(node.left, value, node.key + 1, max);
        longestConsecutiveSequence(node.right, value, node.key + 1, max);
    }

    class Node {
        Node left;
        Node right;
        int key;
        String value;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    private void insert(int key, String value) {
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
        } else  {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    private String find(int key) {
        Node node = find(root, key);
        return node == null ? null : node.value;
    }

    private Node find(Node node, int key) {
        if (node.key == key) {
            return node;
        } else if (node.key < key) {
            return find(node.left, key);
        } else if (node.key > key) {
            return find(node.right, key);
        }
        return node;
    }

    private void delete(int key) {
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
                node.right = delete(node.right, key);
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

    private void display() {
        display(root);
    }

    private void display(Node root) {
        if (root == null) {
            return;
        }
        if (root != null) {
            display(root.left);
            System.out.print(root.key + " ");
            display(root.right);
        }
    }
}
