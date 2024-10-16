package com.algorithim.datastructure.heap;

// The median is the middle value in an ordered integer list. If the size of the list is even,
// there is no middle value and the median is the mean of the two middle values.
//
// For example, for arr = [2,3,4], the median is 3.
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
// Implement the MedianFinder class:
//
// MedianFinder() initializes the MedianFinder object.
// void addNum(int num) adds the integer num from the data stream to the data structure.
// double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
//
//
// Example 1:
//
// Input
// ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
// [[], [1], [2], [], [3], []]
// Output
// [null, null, null, 1.5, null, 2.0]
//
// Explanation
// MedianFinder medianFinder = new MedianFinder();
// medianFinder.addNum(1);    // arr = [1]
// medianFinder.addNum(2);    // arr = [1, 2]
// medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
// medianFinder.addNum(3);    // arr[1, 2, 3]
// medianFinder.findMedian(); // return 2.0

import java.util.*;

class MedianFinder {

    // Use MaxHeap to store smaller part of array
    private Queue<Integer> minHeap;
    // Use Min Heap to store bigger part of the array
    private Queue<Integer> maxHeap;
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a, b)-> b-a);
    }

    public void addNum(int num) {
        // Always add numbers in mi
        maxHeap.offer(num);
        // Make sure top of Min Heap <= top of Max heap
        if(!maxHeap.isEmpty() && !minHeap.isEmpty()){
            if(maxHeap.peek() >= minHeap.peek()) {
                int item = maxHeap.poll();
                minHeap.offer(item);
            }
        }
        // Balance min heap if the size is more than 1
        if(maxHeap.size() > minHeap.size() + 1){
            int item = maxHeap.poll();
            minHeap.offer(item);
        }
        // Balance max heap if the size is more than 1
        if(minHeap.size() > maxHeap.size() + 1){
            int item = minHeap.poll();
            maxHeap.offer(item);
        }
    }

    public double findMedian() {
        if(minHeap.isEmpty()) return maxHeap.isEmpty() ? -1 : maxHeap.peek();
        if((maxHeap.size() + minHeap.size()) % 2 == 0){
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            if(minHeap.size() > maxHeap.size()) return minHeap.peek();
            else return maxHeap.peek();
        }
    }

    // Complete the function below.
    public ArrayList<Double> online_median(List<Integer> stream) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a );
        ArrayList<Double> result = new ArrayList<>();
        for(int data : stream){
            // Use Max heap to store min items and Min heap to store max items
            // Add items in max heap
            maxHeap.offer(data);
            // If max heap top item is bigger than min heap top, move it to max heap
            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (maxHeap.peek() >= minHeap.peek()) {
                    int item = maxHeap.poll();
                    minHeap.offer(item);
                }
            }
            // If size of both heap grows bigger than 2, then balance
            if(minHeap.size() > maxHeap.size() + 1) {
                int item = minHeap.poll();
                maxHeap.offer(item);
            }
            if(maxHeap.size() > minHeap.size() + 1) {
                int item = maxHeap.poll();
                minHeap.offer(item);
            }
            // Calculate median
            if(maxHeap.size() == minHeap.size()) {
                result.add((double) ((maxHeap.peek() + minHeap.peek()) / 2));
            } else if (maxHeap.size() > minHeap.size()) {
                result.add(Double.valueOf(maxHeap.peek()));
            } else {
                result.add(Double.valueOf(minHeap.peek()));
            }
        }
        return result;
    }

    //    Input: nums = [1,3,-1,-3,5,3,6,7]
    //    Sorted:     = [-3,-1,1,3,3,5,6,7]
    //    Median     => 3 + 3 / 2 => 3
    public List<Double> online_medianII(List<Integer> stream) {
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a-b));  // to store bigger items
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));  // to store smaller items
        List<Double> answer = new ArrayList<>();
        for(Integer number : stream){
            maxHeap.offer(number);
            if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                if(maxHeap.peek() > minHeap.peek()){ // if max heap peek has bigger items than min heap peek, then remove and add it in minHeap
                    minHeap.offer(maxHeap.poll());
                }
            }
            if(minHeap.size() > maxHeap.size() + 1){
                maxHeap.offer(minHeap.poll());
            }
            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.offer(maxHeap.poll());
            }
            if(maxHeap.size() == minHeap.size()){
                double median = (double) (maxHeap.peek() + minHeap.peek() )/ 2;
                answer.add(median);
            } else {
                if(maxHeap.size() > minHeap.size()){
                    answer.add((double) maxHeap.peek());
                } else {
                    answer.add((double) minHeap.peek());
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-100);    // arr = [1]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(4);    // arr[1, 2, 3, 7]
        System.out.println(medianFinder.findMedian()); // return 2.5
        medianFinder.addNum(5);    // arr[1, 2, 3, 4, 7]
        System.out.println(medianFinder.findMedian()); // return 3.0
        medianFinder.addNum(10);    // arr[1, 2, 3, 4, 7]
        System.out.println(medianFinder.findMedian()); // return 3.0
        System.out.println();
        List<Double> result =  medianFinder.online_median(Arrays.asList(3, 8, 5, 2));
        for(double i : result) System.out.println(i+" ");
        System.out.println();
        result =  medianFinder.online_medianII(Arrays.asList(3, 8, 5, 2));
        for(double i : result) System.out.println(i+" ");
        System.out.println();
    }

}
