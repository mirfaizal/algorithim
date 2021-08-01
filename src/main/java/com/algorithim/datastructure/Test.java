package com.algorithim.datastructure;

public class Test {
    public static void main(String[] args) {
        //solution(new int[]{1,2,3,4},new int[]{2,3,1,4},4);
        // solution1("world");
        minCost("abccbd", new int[]{0, 1, 2, 3, 4, 5});
    }

    public static int solution(int[] A, int[] B, int N) {
        int roads_num = A.length;
        int[] cities = new int[N + 1];
        for (int i = 0; i < roads_num; ++i) {
            cities[A[i]]++;
            cities[B[i]]++;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < roads_num; ++i) {
            result = Math.max(result, cities[A[i]] + cities[B[i]] - 1);
        }
        return result;
    }

    public static int solution1(String s) {
        int res = 0, s_size = s.length();
        for (int i = 0; i < s_size; ) {
            int next = i + 1;
            // if we meet sequence of the same letters
            // scan the string to find length of this sequence
            while ((next < s_size) && (s.charAt(i) == s.charAt(next))) {
                next++;
            }
            // Here "next - i" is length of the sequence
            // Each third letter should be changed to remove
            // too long sequences
            res += (next - i) / 3;
            i = next; // skip processed letters
        }
        return res;
    }

    public static int minCost(String S, int[] C) {
        int i = 0, j = 1;
        int size = S.length();
        int min_cost = 0;
        while (j < size) {
            if (S.charAt(j) == S.charAt(i)) {
                if (C[j] < C[i]) {
                    min_cost += C[j];
                } else {
                    min_cost += C[i];
                    i = j;
                }
            } else {
                i = j;
            }
            j++;
        }
        return min_cost;
    }

    static final int MAX_CHARACTERS = 26;

    public int solution(String S) {
        int n = S.length();
        if (n > MAX_CHARACTERS)
            return -1;
        int dist_count = 0;
        int count[] = new int[MAX_CHARACTERS];
        for (int i = 0; i < MAX_CHARACTERS; i++)
            count[i] = 0;

        for (int i = 0; i < n; i++) {
            if (count[S.charAt(i) - 'a'] == 0)
                dist_count++;
            count[S.charAt(i) - 'a']++;
        }

        return (n - dist_count + 1);
    }


}
