package com.algorithim.datastructure;

import com.algorithim.datastructure.sorting.BinaryMaxHeap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BinaryHeapTest {

    private BinaryMaxHeap heap;

    @Before
    public void setUp() throws Exception {
        heap = new BinaryMaxHeap();
    }

    @Test
    public void testInsertItem() throws IllegalAccessException {
        heap.insertItem(42);
        heap.printArray();
        heap.insertItem(35);
        heap.printArray();
        heap.insertItem(18);
        heap.printArray();
        heap.insertItem(29);
        heap.printArray();
        heap.insertItem(14);
        heap.printArray();
        heap.insertItem(7);
        heap.printArray();
        heap.insertItem(12);
        heap.printArray();
        heap.insertItem(1);
        heap.printArray();
        heap.insertItem(100);
        heap.printArray();
        heap.insertItem(10);
        heap.printArray();
        heap.insertItem(20);
        heap.printArray();
        heap.insertItem(30);
        heap.printArray();
        System.out.println("Extracted : "+heap.poll());
        heap.printArray();
    }

    public void testPoll() {
    }
}