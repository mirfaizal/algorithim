package com.algorithim.datastructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.

 For examples, if arr = [2,3,4], the median is 3.
 For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.

 Example 1:

 Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
 Explanation:
 Window position                Median
 ---------------                -----
 [1  3  -1] -3  5  3  6  7        1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7        3
 1  3  -1  -3 [5  3  6] 7        5
 1  3  -1  -3  5 [3  6  7]       6
 Example 2:

 Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
 Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]


 Constraints:

 1 <= k <= nums.length <= 105
 -231 <= nums[i] <= 231 - 1


 */
public class SlidingWindowMedian {
    public static double[] medianSlidingWindow(int[] stream, int k) {
        double [] medianArray = new double[stream.length - k + 1];
        int arrayIndex = 0;

        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        for(int i = 0; i <= stream.length - k; i++){
            int slidingWindow = 0;
            while(!minHeap.isEmpty()){
                minHeap.poll();
            }
            while(!maxHeap.isEmpty()){
                maxHeap.poll();
            }
            while(slidingWindow < k) {
                int index = slidingWindow + i;
                maxHeap.offer(stream[index]);
                // Maintain heap property
                if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                    if(maxHeap.peek() > minHeap.peek()){
                        int item = maxHeap.poll();
                        minHeap.offer(item);
                    }
                }
                // Balance Heaps
                if(minHeap.size() > maxHeap.size() + 1){
                    int item = minHeap.poll();
                    maxHeap.offer(item);
                }
                if(maxHeap.size() > minHeap.size() + 1){
                    int item = maxHeap.poll();
                    minHeap.offer(item);
                }
                // Calculate Median if size of both queue is k
                int size = getSize(minHeap,maxHeap);
                if(size == k) {
                    if (minHeap.size() == maxHeap.size()) {
                        double median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
                        medianArray[arrayIndex++] = median;
                    } else if (minHeap.size() > maxHeap.size()) {
                        double median = minHeap.peek();
                        medianArray[arrayIndex++] = median;
                    } else {
                        double median =  maxHeap.peek();
                        medianArray[arrayIndex++] = median;
                    }
                }
                slidingWindow++;
            }
        }
        return medianArray;
    }

    private static int getSize(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
        if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            return minHeap.size() + maxHeap.size();
        } else if(!minHeap.isEmpty()){
            return minHeap.size();
        } else {
            return maxHeap.size();
        }
    }

    public static void main(String[] args) {
        double [] result = medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        System.out.println(Arrays.toString(result));
        result = medianSlidingWindow(new int[]{1,2,3,4,2,3,1,4,2},3);
        System.out.println(Arrays.toString(result));
    }
}
