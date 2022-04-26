package com.algorithim.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// 127. Word Ladder
//A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of
//words beginWord -> s1 -> s2 -> ... -> sk such that:
//Every adjacent pair of words differs by a single letter.
//Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//sk == endWord
//Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation
//sequence from beginWord to endWord, or 0 if no such sequence exists.
//Example 1:
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//Output: 5
//Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
//Example 2:
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//Output: 0
//Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList); // ["hot","dot","dog","lot","log","cog"]
        Queue<String> queue = new LinkedList<>();
        set.remove(beginWord); // ["dot","dog","lot","log","cog"] , beginWord = "hot" , endWord = "cog"
        queue.add(beginWord);  // ["hot"]
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String popped = queue.poll(); // "hot"
                char [] poppedArray = popped.toCharArray(); // ['h','o','t']
                for(int j = 0; j < poppedArray.length; j++) {
                    char tempChar = poppedArray[j]; // 'h'
                    for(char k = 'a'; k <= 'z' ; k++ ) {
                        poppedArray[j] = k; // ['a','o','t'] ['b','o','t'] ... ['h','o','t']
                        String newString = new String(poppedArray); // "aot"
                        if(set.contains(newString)) {
                            if(newString.equals(endWord)) return level + 1;
                            queue.add(newString);
                            set.remove(newString);
                        }
                    }
                    poppedArray[j] = tempChar; // 'h' // // ['h','o','t']  fix the array
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        assert(ladderLength("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))) == 5);
        assert(ladderLength("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"))) == 0);
    }
}
