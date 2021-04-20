package com.basicjava;

import java.util.HashSet;
import java.util.Set;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        Character.isDigit('d');
        if(names1.length == 0 && names2.length == 0) return new String[] {};
        Set<String> set = new HashSet<>();
        if(names1.length != 0)
            for(String s : names1)
                set.add(s);
        if(names2.length != 0)
            for(String s : names2)
                set.add(s);
        String [] array = new String[set.size()];
        int index = 0;
        for(String s : set){
            array[index++] = s;
        }
        return array;

    }


    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
