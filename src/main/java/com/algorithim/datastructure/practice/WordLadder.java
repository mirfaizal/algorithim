package com.algorithim.datastructure.practice;
/**

    127. Word Ladder
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of
    words beginWord -> s1 -> s2 -> ... -> sk such that:
    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation
    sequence from beginWord to endWord, or 0 if no such sequence exists.
    Example 1:
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    Output: 5
    Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
    Example 2:
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: 0
    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 1;
        // ["hot","dot","dog","lot","log","cog"]
        Set<String> set = new HashSet<>(wordList);
        // hit
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size;i++){
                // "hit"
                String node = queue.poll();
                // ['h','i','t']
                char [] nodeArray = node.toCharArray();
                for(int j = 0; j < nodeArray.length; j++){
                    // 'h'
                    char temp = nodeArray[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        // 'a' --> //ait , bit , cit ...
                        nodeArray[j] = c;
                        String tempString = new String(nodeArray);
                        if(set.contains(tempString)){
                            if(tempString.equals(endWord)) return count + 1;
                            queue.add(tempString);
                            set.remove(tempString);
                        }
                    }
                    nodeArray[j] = temp;
                }
            }
            count++;
        }

        return 0;
    }
    public static void main(String[] args) {
        System.out.println(ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}
