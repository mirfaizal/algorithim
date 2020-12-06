package com.algorithim.datastructure.sorting;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SortingTest {

    private BubbleSort bubbleSort;

    private MergeSort mergeSort;

    @Before
    public void before(){
        bubbleSort = new BubbleSort();
        mergeSort = new MergeSort();
    }

    @Test
    public void testBubbleSort() {
        int [] array = bubbleSort.bubbleSort(new int [] {5,4,3,2,1});
        for(int i=0;i<array.length;i++)
        System.out.println(array[i]);
    }

    @Test
    public void testMergeSort(){
        int [] array = mergeSort.mergeSort(new int [] {38,27,43,3,9,82,10});
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]);
    }
}