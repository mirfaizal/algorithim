package com.algorithim.datastructure.array;

public class MergeSortedArray {

    public static void main(String[] args) {
        int [] result = merge(new int[]{10,20,30,0,0,0},3,new int[] {2,3,4},3);
        for(int i=0;i<result.length;i++) System.out.print(result[i]+" ");
    }
    public static int [] merge(int[] nums1, int m, int[] nums2, int n) {
        while(m > 0 || n > 0){
            if(m > 0 && n > 0){
                if(nums1[m-1] > nums2[n-1]) {
                    nums1[m+n-1] = nums1[m-1];
                    m--;
                } else  if(nums1[m-1] < nums2[n-1]) {
                    nums1[m+n-1] = nums2[n-1];
                    n--;
                } else {
                    nums1[m+n-1] = nums1[m-1];
                    m--;
                    nums1[m+n-1] = nums2[n-1];
                    n--;
                }
            }
            else if(n > 0) {
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
            else if(m > 0) {
                nums1[m+n-1] = nums1[m-1];
                m--;
            }
        }
        return nums1;
    }
}
