package com.algorithim.datastructure.map;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        solution("codility");
        solution("abbabba");
    }

    public static int solution(String S) {
        Map<String, Integer> map = new HashMap<>();
        int index =0;
        for(int i=0;i<S.length();i++){
            String str = S.substring(index,i);
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        index = S.length();
        for(int i=S.length();i>=0;i--){
            String str = S.substring(i,index);
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        int max = 2;
        String maxKey = "";
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(max <= entry.getValue() && maxKey.length() < entry.getKey().length()) {
                max = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println(maxKey.length());
        return maxKey.length();
    }
}
