package com.algorithim.datastructure.companies.microsoft;

public class StringProblems {
    public static void main(String[] args) {
        System.out.println(reverseWordsInString("Alice  does  not  even  like  bob"));
        char [] array = "Alice does not even like bob".toCharArray();
        reverseWords(array);
        StringBuilder sb = new StringBuilder();
        sb.append(array);
        System.out.println(sb.toString());
        System.out.println(longestPalindrome("babad"));
    }

    private static int beginIndex = 0, length = 0;
    public static String longestPalindrome(String str) {
        if(str.length() < 2) return str;
        for(int i=0;i<str.length();i++){
            expandRange(str,i,i);
            expandRange(str,i,i+1);
        }
        return str.substring(beginIndex, beginIndex + length);
    }

    private static void expandRange(String str, int start, int end) {
        while(start >= 0 && end < str.length()  && str.charAt(start) == str.charAt(end)){
            start--;
            end++;
        }
        if(length < end - start - 1){
            beginIndex = start + 1;
            length = end - start - 1;
        }
    }

    private static String reverseWordsInString(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+"," ");
        int i1 = 0, j1=str.length()-1;
        char [] charArray = str.toCharArray();
        while(i1<j1) {
            char temp = charArray[i1];
            charArray[i1] = charArray[j1];
            charArray[j1] = temp;
            i1++;
            j1--;
        }
        for(int i=0;i<charArray.length;i++){
            int j = i;
            while(j < charArray.length && charArray[j] != ' ') j++;
            int k=j-1;
            while(i<k){
                char temp = charArray[i];
                charArray[i] = charArray[k];
                charArray[k] = temp;
                i++;
                k--;
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charArray);
        return sb.toString();
    }

    public static void reverseWords(char[] s) {
        int i1 = 0, j1 = s.length - 1;
        // Reverse the string
        while(i1 < j1) {
            char temp = s[i1];
            s[i1] = s[j1];
            s[j1] = temp;
            j1--; i1++;
        }
        // Reverse the words in string
        for(int i = 0; i < s.length; i++) {
            int j = i;
            while(j < s.length && s[j] != ' ') j++;
            int k = j - 1;
            while(i < k){
                char temp = s[i];
                s[i] = s[k];
                s[k] = temp;
                i++;
                k--;
            }
            i = j;
        }
    }
}
