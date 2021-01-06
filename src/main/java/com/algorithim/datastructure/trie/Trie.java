package com.algorithim.datastructure.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    class Node {
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
                current.children.put(word.charAt(i), node);
            }
            current = node;
        }
        current.endOfWord = true;
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
        trie.insert("are");
        trie.insert("area");
        trie.insert("base");
        trie.insert("cat");
        trie.insert("cater");
        trie.insert("children");
        trie.insert("basement");
        System.out.println(trie.search("cater"));
        trie.delete("cater");
        System.out.println(trie.search("cater"));
        System.out.println(trie.longestPrefixMatching("caterer"));
        System.out.println(trie.longestPrefixMatching("basemexy"));
        System.out.println(trie.longestPrefixMatching("child"));
    }
}
