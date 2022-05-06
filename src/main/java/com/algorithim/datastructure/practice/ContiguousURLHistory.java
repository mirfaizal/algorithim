package com.algorithim.datastructure.practice;

/**
Find Contiguous URL History:

Write a function that takes two users' browsing histories as input and  returns the longest contiguous sequence of URLs that appears in both.

Sample input:
user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange","/one/two"]
user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
user2 = ["a", "/one", "/two"]
user3 = ["/pink", "/orange", "/yellow","/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue","/LightGoldenRodYellow", "/BritishRacingGreen"]
user4 = ["/pink", "/orange","/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red","/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
user5 = ["a"]
user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red","/amber"]

Sample output:
findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
findContiguousHistory(user0, user2) => [] (empty)
findContiguousHistory(user0, user0) => ["/start", "/green", "/blue", "/pink","/register", "/orange", "/one/two"]
findContiguousHistory(user2, user1) =>["a"]
findContiguousHistory(user5, user2) => ["a"]
findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]
n: length of the first user's browsing history m: length of the second user's browsing history

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
    user0 = ["/a", "/b", "/c", "/d", "/e","/f"] 6
    user1 = ["/d", "/e", "/f", "/g", "/h"] 5
    Time nlogn , Space n

 */

public class ContiguousURLHistory {

    public static List<String> findContiguousHistory(List<String> user1, List<String> user2) {
        int [][] dp = new int[user1.size() + 1][user2.size() + 1];
        int index = 0;
        int max = Integer.MIN_VALUE;
        for(int i = user1.size() - 1; i >= 0 ; i--){
            for(int j = user2.size() - 1; j >= 0 ; j--){
                if(user1.get(i).equalsIgnoreCase(user2.get(j))){
                    dp[i][j] += dp[i + 1][j + 1] + 1;
                    if(dp[i][j] > max){
                        max = dp[i][j];
                        index = j;
                    }
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(int i = index; i < index + max; i++){
            result.add(user2.get(i));
        }
        return result;
    }

    public static List<String> intersection(List<String> user1, List<String> user2){
        List<String> user1Sorted = new ArrayList<>(user1);
        List<String> user2Sorted = new ArrayList<>(user2);
        Collections.sort(user1Sorted);
        Collections.sort(user2Sorted);
        int i = 0, j = 0;
        List<String> intersect = new ArrayList<>();
        while(i < user1Sorted.size() && j < user2Sorted.size()){
            if(user1Sorted.get(i).compareTo(user2Sorted.get(j)) == 0) {
                intersect.add(user1Sorted.get(i));
                i++;
                j++;
            } else if (user1Sorted.get(i).compareTo(user2Sorted.get(j)) > 0){
                j++;
            } else {
                i++;
            }
        }
        boolean existUser1 = user1.containsAll(intersect);
        boolean existUser2 = user1.containsAll(intersect);
        return (existUser1 && existUser2) ? intersect : new ArrayList<>();
    }
    public static void main(String[] args) {
        List<String> result = intersection(Arrays.asList("/start", "/green", "/blue", "/pink", "/register", "/orange","/one/two"),
                Arrays.asList("/start", "/pink", "/register", "/orange", "/red", "a"));
        System.out.println(result);

        result = findContiguousHistory(Arrays.asList("/start", "/green", "/blue", "/pink", "/register", "/orange","/one/two"),
                Arrays.asList("/start", "/pink", "/register", "/orange", "/red", "a"));
        System.out.println(result);

        List<String> user0 = Arrays.asList("/start", "/green", "/blue", "/pink", "/register", "/orange","/one/two");
        List<String> user1 = Arrays.asList("/start", "/pink", "/register", "/orange", "/red", "a");
        List<String> user2 = Arrays.asList("a", "/one", "/two");
        List<String> user3 = Arrays.asList("/pink", "/orange", "/yellow","/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue","/LightGoldenRodYellow", "/BritishRacingGreen");
        List<String> user4 = Arrays.asList("/pink", "/orange","/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red","/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow");
        List<String> user5 = List.of("a");
        List<String> user6 = Arrays.asList("/pink","/orange","/six","/plum","/seven","/tan","/red","/amber");

        System.out.println(findContiguousHistory(user0, user1));
        System.out.println(findContiguousHistory(user0, user2));
        System.out.println(findContiguousHistory(user0, user0));
        System.out.println(findContiguousHistory(user2, user1));
        System.out.println(findContiguousHistory(user5, user2));
        System.out.println(findContiguousHistory(user3, user4));
        System.out.println(findContiguousHistory(user4, user3));
        System.out.println(findContiguousHistory(user3, user6));



    }

}
