package com.algorithim.datastructure.dynamic;

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

import java.util.Arrays;

public class FindContiguousHistory {

    public static void main(String[] argv) {
        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] user2 = {"a", "/one", "/two"};
        String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5 = {"a"};
        String[] user6 = {"/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"};

        FindContiguousHistory solution = new FindContiguousHistory();
        String [] str = solution.findContiguousHistory(user0,user1);
//        for(String s : str){
//            System.out.println(s);
//        }


    }

    private String[] findContiguousHistory(String [] arrayOne, String [] arrayTwo){
        String [] contiguousArray;
        String [] temporaryArray = new String[10];
        int index1 =0;
        int max =0;
        int [][] tempArray = new int[arrayOne.length + 1][arrayTwo.length + 1];
        int [] arrayOnePosition = new int[arrayOne.length];
        int [] arrayTwoPosition = new int[arrayOne.length];
        int index = 0;
        for(int i=1; i< arrayOne.length + 1; i++){
            for(int j=1; j< arrayTwo.length + 1; j++){
                if(arrayOne[i-1] == arrayTwo[j-1]){
                    tempArray[i][j] = tempArray[i-1][j-1] + 1;
                    temporaryArray[index1++] = arrayOne[i-1];
                } else {
                    tempArray[i][j] = Math.max(tempArray[i][j-1] , tempArray[i-1][j]);
                }
                if(max < tempArray[i][j]){
                    max = tempArray[i][j];
                    arrayOnePosition[index] = i;
                    arrayTwoPosition[index++] = j;
                }
            }
        }
        contiguousArray = new String[max];
        if(max == 1){
            contiguousArray[0] = arrayOne[arrayOnePosition[1]];
        }else {
            for (int i = 0; i < max; i++) {
                if(arrayOnePosition[i] == arrayOnePosition[i+1] - 1){
                    contiguousArray[i] = arrayOne[arrayOnePosition[i] - 1];
                }
                System.out.println(arrayOnePosition[i] + " : " + arrayTwoPosition[i]);
                System.out.println(arrayOne[arrayOnePosition[i] - 1] + " : " + arrayTwo[arrayTwoPosition[i] - 1]);

            }
        }
        return contiguousArray;
    }

}
