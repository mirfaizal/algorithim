package com.algorithim.datastructure.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 * 720. Longest Word in Dictionary
 * Given a list of strings words representing an English Dictionary,
 * find the longest word in words that can be built one character at a time by other words in words.
 * If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 * If there is no answer, return the empty string.
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2:
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 */

public class LongestWordInDictionary {

    final class Node {
        Map<Character, Node> children = new HashMap<>();
        int index;
        char character;

        Node(char character) {
            this.character = character;
        }
    }

    private Node root;

    LongestWordInDictionary() {
        root = new Node('*');
    }

    private void insert(String word, int index) {
        Node current = root;
        for (char character : word.toCharArray()) {
            Node node = current.children.get(character);
            if (node == null) {
                node = new Node(character);
                current.children.put(character, node);
            }
            current = node;
        }
        current.index = index;
    }

    private boolean search(String word) {
        Node current = root;
        for (char character : word.toCharArray()) {
            Node node = current.children.get(character);
            if (node == null) return false;
            current = node;
        }
        return current.index > 0;
    }

    public String longestWordInDictionary(String[] words) {
        String answer = "";
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node == root || node.index > 0) {
                for (Node kid : node.children.values()) {
                    stack.push(kid);
                }
                if (node != root) {
                    String word = words[node.index - 1];
                    if (word.length() > answer.length() || (word.length() == answer.length() && word.compareTo(answer) < 0)) {
                        answer = word;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        int index = 1;
        for (String word : words) longestWordInDictionary.insert(word, index++);
        System.out.println(longestWordInDictionary.search("apple"));
        String s = longestWordInDictionary.longestWordInDictionary(words);
        System.out.println(s);
    }
}
