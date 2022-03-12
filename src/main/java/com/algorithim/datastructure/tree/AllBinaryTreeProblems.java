package com.algorithim.datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class AllBinaryTreeProblems {

    static final class Node {
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

    private static List<Integer> list = new ArrayList<>();

    public static String serialize(Node root) {
        if(root == null) return null;
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node node = queue.remove();
                if(node == null) {sb.append("x,");continue;}
                sb.append(node.key+",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sb.toString();
    }

    public static Node deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String [] chars = data.split(",");
        int index = 0;
        Node root = new Node(Integer.parseInt(chars[index]), chars[index++]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty() && index < chars.length){
            Node node = queue.remove();
            if(!chars[index].equals("x")){
                Node left = new Node(Integer.parseInt(chars[index]), chars[index]);
                node.left = left;
                queue.add(left);
            }
            index++;
            if(!chars[index].equals("x")){
                Node right = new Node(Integer.parseInt(chars[index]), chars[index]);
                node.right = right;
                queue.add(right);
            }
            index++;
        }
        return root;
    }

    private static void treeIterator(Node node){
        if(node == null) return;
        treeIterator(node.left);
        list.add(node.key);
        treeIterator(node.right);
    }



    private static Node merge(Node t1, Node t2){
        if(t1 == null && t2 == null) return null;
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        Queue<Node> queueOne = new LinkedList<>();
        queueOne.add(t1);
        Queue<Node> queueTwo = new LinkedList<>();
        queueTwo.add(t2);
        while(!queueOne.isEmpty() || !queueTwo.isEmpty()) {
            List<Integer> innerOne = new ArrayList<>();
            List<Integer> innerTwo = new ArrayList<>();
            if(!queueOne.isEmpty()){
                int size = queueOne.size();
                for(int i=0;i<size;i++){
                    Node node = queueOne.remove();
                    innerOne.add(node.key);
                    if(node.left != null) queueOne.add(node.left);
                    if(node.right != null) queueOne.add(node.right);
                }
            }
            if(!queueTwo.isEmpty()){
                int size = queueTwo.size();
                for(int i=0;i<size;i++){
                    Node node = queueTwo.remove();
                    innerTwo.add(node.key);
                    if(node.left != null) queueTwo.add(node.left);
                    if(node.right != null) queueTwo.add(node.right);
                }
            }
        }

        return null;
    }

    private static Node deepCopy(Node node){
        if(node == null) return null;
        Node deep = new Node(node.key,node.value);
        deep.left = deepCopy(node.left);
        deep.right = deepCopy(node.right);
        return deep;
    }

    private static Node mergeIterative(Node t1, Node t2){
        if(t1 == null && t2 == null) return null;
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        Node finalNode = new Node(t1.key, String.valueOf(t1.key + t2.key));
        finalNode.left = merge(t1.left,t2.left);
        finalNode.right = merge(t1.right,t2.right);
        return finalNode;
    }

    private int depth(){
        return depth(root);
    }

    private int depth(Node root) {
        if(root == null) return 0;
        if(root.left == null  && root.right == null) return 1;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }

    private void mirror(){
        mirror(root);
    }

    private void mirror(Node root) {
        if(root == null) return;
        mirror(root.left);
        mirror(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    private int countTree(int n){
        if(n <=1) return 1;
        int sum =0;
        for(int i=1;i<=n;i++){
            int countLeft = countTree(i-1);
            int countRight = countTree(n-i);
            sum += (countLeft * countRight);
        }
        return sum;
    }

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
        }else {
            return find(root.left, key);
        }
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
            return null;
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


    private void postOrderTraversal(Node root) {
        if(root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
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
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
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
        if(root == null) return false;
        if(root.left == null && root.right == null && sum - root.key == 0) return true;
        return pts(root.left, sum - root.key) || pts(root.right, sum - root.key);
    }

    private List<Integer> leftView() {
        return leftView(root);
    }

    private List<Integer> leftView(Node root) {
        List<Integer> leftView = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node node = queue.remove();
                if(i == size - 1) leftView.add(node.key);
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
            }
        }
        getLeftView(root);
        return leftView;

    }

    private List<Integer> getLeftView(Node root){

        List<Integer> left = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node child = queue.remove();
                if(i == 0) left.add(child.key);
                if(child.left != null) queue.add(child.left);
                if(child.right != null) queue.add(child.right);
            }
        }
        return left;
    }

    private List<Integer> rightView() {
        return rightView(root);
    }

    private List<Integer> rightView(Node root) {
        List<Integer> rightView = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node node = queue.remove();
                if(i == size - 1) rightView.add(node.key);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return rightView;
    }

    private int size(){
        return size(root);
    }

    private int size(Node root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1;
    }

    private Map<Integer, List<Integer>> levelOrderTraversal(Node root){
        Map<Integer, List<Integer>> levelOrderMap = new HashMap<>();
        if(root == null) return levelOrderMap;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> innerList = new LinkedList<>();
            for(int i=0;i<size;i++){
                Node node = queue.remove();
                innerList.add(node.key);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            levelOrderMap.put(level++,innerList);
        }
        return  levelOrderMap;
    }

    List<Integer> checkBST(Node node, List<Integer> array){
        if(node != null){
            checkBST(node.left,array);
            array.add(node.key);
            checkBST(node.right,array);
        }
        return array;
    }

    boolean checkBST() {
        List<Integer> array = new ArrayList<>();
        checkBST(root, array);
        int index = 1;
        for(int i : array){
            if(index == array.size()) break;
            if(i > array.get(index++)) return false;
        }
        return true;
    }


    public static void main(String[] args) {



        Stack<List<Integer>> stack = new Stack<>();
        stack.push(new ArrayList<>(Arrays.asList(1,2,3)));
        stack.push(new ArrayList<>(Arrays.asList(4,5)));
        stack.push(new ArrayList<>(Arrays.asList(6)));
        List<List<Integer>> res = new ArrayList<>();


        while(!stack.isEmpty()){
            res.add(stack.pop());
        }


        AllBinaryTreeProblems left = new AllBinaryTreeProblems();
        left.insert(1, "Faizal");
        left.insert(2, "Claudia");

        AllBinaryTreeProblems right = new AllBinaryTreeProblems();
        right.insert(10, "Faizal");
        right.insert(2, "Claudia");
        right.insert(1, "Love");
        right.insert(3, "Sami");
        right.insert(13, "Far");
        right.insert(14, "Mir");

        String data = serialize(right.root);

        String [] chars = data.split(",");
        deserialize(data);
        Node root = merge(left.root,right.root);


        AllBinaryTreeProblems binaryTree = new AllBinaryTreeProblems();
        binaryTree.insert(1, "Faizal");
        binaryTree.insert(2, "Claudia");




//        binaryTree.insert(14, "Jenne");
//        binaryTree.insert(4, "Marsha");
//        binaryTree.insert(6, "Daniel");
//        binaryTree.insert(18, "Anna");
//        binaryTree.insert(19, "Nora");
//        binaryTree.insert(8, "Ping Ping");
//        binaryTree.insert(1, "Kate");
//        binaryTree.insert(3, "Rachel");
//        binaryTree.insert(5, "Carme");
//        binaryTree.insert(12, "Jamie");
        binaryTree.print(Order.IN_ORDER);
//        System.out.println();
//        binaryTree.print(Order.PRE_ORDER);
//        System.out.println();
//        binaryTree.print(Order.POST_ORDER);
//        System.out.println(binaryTree.lowestCommonAncestor(5,8));
//        System.out.println(binaryTree.lowestCommonAncestor(18,8));
        System.out.print(binaryTree.pathToSum(3));
//        binaryTree.leftView();
//        System.out.println();
//        System.out.println(binaryTree.depth());
//        binaryTree.mirror();
//        binaryTree.inOrderTraversal(binaryTree.root);
//        System.out.print(binaryTree.countTree(3));
//          System.out.println("Size is : "+binaryTree.size());
//        System.out.println("Left View");
//        List<Integer> leftView = binaryTree.leftView();
//        for(int i=0;i<leftView.size();i++){
//            System.out.print(leftView.get(i)+" ");
//        }
//        System.out.println("\nRight View");
//        List<Integer> rightView = binaryTree.rightView();
//        for(int i=0;i<rightView.size();i++){
//            System.out.print(rightView.get(i)+" ");
//        }
//
//        Map<Integer, List<Integer>> map = binaryTree.levelOrderTraversal(binaryTree.root);
//        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
//            System.out.print(entry.getValue().get(entry.getValue().size() - 1)+" ");
//        }

        //System.out.println(binaryTree.checkBST());

    }




}
