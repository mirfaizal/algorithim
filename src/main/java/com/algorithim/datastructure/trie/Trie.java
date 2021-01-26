package com.algorithim.datastructure.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Trie {
    class Node {
        char character;
        Map<Character, Node> children;
        boolean endOfWord;
        Node(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }
    private final Node root;
    public Trie() {
        root = new Node();
    }
    private void insert(String word){
        Node current = root;
        for(int i=0;i<word.length();i++){
            Node node = current.children.get(word.charAt(i));
            if(node == null){
                node = new Node();
                current.character = word.charAt(i);
                current.children.put(word.charAt(i), node);
            }
            current = node;
        }
        current.endOfWord = true;
    }



    private void delete(String word){
        delete(root,word,0);
    }

    private boolean delete(Node current, String word, int index) {
        // Base case
        if(index == word.length()){
            if(!current.endOfWord){
                return false;
            }
            current.endOfWord = false;
            // Returns true for empty map, to be deleted
            return current.children.size() == 0;
        }
        Node node = current.children.get(word.charAt(index));
        if(node == null){
            return false;
        }
        boolean shouldDeleteNode = delete(node,word,index+1);
        if(shouldDeleteNode){
            node.children.remove(word.charAt(index));
            return node.children.size() == 0;
        }
        return false;
    }

    private String longestPrefixMatching(String word){
        Node current = root;
        int previousMatch = 0;
        for(int i=0;i<word.length();i++){
            Node node = current.children.get(word.charAt(i));
            if(previousMatch == 0 && node == null){
                return "";
            }
            if(node == null) break;
            if(node.endOfWord){
                previousMatch = i;
            }
            current = node;
        }
        return previousMatch == 0? "No Match for "+word  : "Match for "+word+" is "+word.substring(0,previousMatch+1);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String [] arr = {"mobile","mouse","moneypot","monitor","mousepad"};
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++){
            trie.insert(arr[i]);
        }
        trie.dfs('m');
        String searchWord = "mouse";
        List<List<String>>  suggestedProduct = trie.suggestedProduct(searchWord);
        for(List<String> inner : suggestedProduct){
            for(String string : inner){
                System.out.print(string+" ");
            }
            System.out.println();
        }

    }

    private boolean search(String word) {
        Node current = root;
        for(int i=0;i<word.length();i++){
            Node node = current.children.get(word.charAt(i));
            if(node == null){
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }

    private List<List<String>> suggestedProduct(String searchWord) {
        List<List<String>> output = new ArrayList<>();
        Node current = null;




        for(int i=0;i<searchWord.length();i++){
            current = root;
            String wordToSearch = searchWord.substring(0,i+1);
            for(char character: wordToSearch.toCharArray()){
                Node node = current.children.get(character);
                if(node == null) return new ArrayList<>();
                System.out.print(current.character+" ");
                current = node;
            }
        }


        return new ArrayList<>();
    }


    private List<String> dfs(char character){
        List<String> inner = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if (node == null) break;
            if (!inner.contains(node.character)) {
                inner.add(String.valueOf(node.character));
                for(Character kids : node.children.keySet()){
                    stack.push(node.children.get(kids));
                }

            }

        }
        return inner;
    }



}
