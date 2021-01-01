package com.algorithim.datastructure.array;

public class MedianArray {

    //TODO Still not solved
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1,3},new int[] {2,7}));
    }

    public static double findMedianSortedArrays(int[] leftArray, int[] rightArray) {
        int left = 0, right = 0, sum = 0, result = 0;
        int [] resultArray = new int [leftArray.length + rightArray.length];
        while(left < leftArray.length || right < rightArray.length){
            if(left < leftArray.length && right < rightArray.length){
                if(leftArray[left] < rightArray[right]){
                    resultArray[result++] = leftArray[left];
                    sum += leftArray[left++];
                } else {
                    resultArray[result++] = rightArray[right];
                    sum += rightArray[right++];
                }
            }
            else if(left < leftArray.length){
                resultArray[result++] = leftArray[left];
                sum += leftArray[left++];
            } else if(right < rightArray.length){
                resultArray[result++] = rightArray[right];
                sum += rightArray[right++];
            }
        }
        left = 0;
        right = resultArray.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(resultArray[mid] < resultArray[mid+1]){
                left = mid + 1;
                System.out.println("Left"+left);
            } else{
                right = mid;
                System.out.println("Right"+right);
            }
            System.out.println(mid);
        }

        return  (double) sum/(leftArray.length + rightArray.length);
    }
}
