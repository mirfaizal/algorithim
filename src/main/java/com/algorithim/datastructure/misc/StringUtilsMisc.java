package com.algorithim.datastructure.misc;

public class StringUtilsMisc {

    public static void main(String[] args) {
        System.out.println(isSubString("erbottlewat","waterbottlewaterbottle"));
    }

    static boolean isSubString(String s1, String s2){
        return s2.contains(s1+s1);
    }
}
