package com.algorithim.datastructure.misc;

public class StringUtilsMisc {

    public static void main(String[] args) {
        System.out.println(isSubString("erbottlewat","waterbottlewaterbottle"));

        System.out.println((double)13/4);
    }

    static boolean isSubString(String s1, String s2){
        return s2.contains(s1+s1);
    }
}
