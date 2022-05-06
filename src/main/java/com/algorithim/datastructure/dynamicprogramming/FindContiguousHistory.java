package com.algorithim.datastructure.dynamicprogramming;

/*

We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person.

Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample input:

user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
user2 = ["a", "/one", "/two"]
user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
user5 = ["a"]
user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"]

Sample output:

findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
findContiguousHistory(user0, user2) => [] (empty)
findContiguousHistory(user2, user1) => ["a"]
findContiguousHistory(user5, user2) => ["a"]
findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]

n: length of the first user's browsing history
m: length of the second user's browsing history

*/

import java.util.ArrayList;
import java.util.List;

public class FindContiguousHistory {

    public static void main(String[] argv) {
        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red"};
        String[] user2 = {"a", "/one", "/two"};
        String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5 = {"a"};
        String[] user6 = {"/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"};

        FindContiguousHistory solution = new FindContiguousHistory();
        List str = solution.findContiguousHistory(user1,user0);
        System.out.println(str);

    }

    public static List<String> findContiguousHistory(String[] user1, String[] user2) {
        List<String> result = new ArrayList<>();
        if (user1.length == 0 || user2.length == 0) {
            return result;
        }
        int[][] dp = new int[user1.length + 1][user2.length + 1];
        int max = Integer.MIN_VALUE;
        int endIndex = -1;
        for (int i = user1.length - 1; i >= 0; i--) {
            for (int j = user2.length - 1; j >= 0; j--) {
                if (user1[i].equals(user2[j])) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                        endIndex = j;
                    }
                    break;
                }
            }
        }
        if (max == Integer.MIN_VALUE) {
            return result;
        }
        for (int i = endIndex; i < endIndex + max; i++) {
            result.add(user2[i]);
        }
        return result;
    }
}
