package com.algorithim.datastructure.misc;

public class OneAway {
    public static void main(String[] args) {
        OneAway oneAway = new OneAway();
        System.out.println(oneAway.oneAway("pale", "ple"));
        System.out.println(oneAway.oneAway("pales", "pale"));
        System.out.println(oneAway.oneAway("pale", "bale"));
        System.out.println(oneAway.oneAway("pale", "bake"));
    }

    private boolean oneAway(String s1, String s2) {
        if (s1.length() - s2.length() > 1 || s2.length() - s1.length() > 1) {
            return false;
        } else if (s1.length() == s2.length()) {
            return oneAwayEqual(s1, s2);
        } else if (s1.length() > s2.length()) {
            return omeAwayNotEqual(s1, s2);
        } else if (s2.length() > s1.length()) {
            return omeAwayNotEqual(s2, s1);
        }
        return false;
    }

    private boolean omeAwayNotEqual(String s1, String s2) {
        int count = 0;
        int i = 0;
        while (i < s2.length()) {
            if (s1.charAt(count + i) == s2.charAt(i))
                i++;
            else
                count++;
            if (count > 1) return false;
        }
        return true;
    }

    private boolean oneAwayEqual(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
