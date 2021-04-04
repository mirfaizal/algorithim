package com.algorithim.datastructure;

import com.algorithim.datastructure.sorting.HeapSort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class HeapTest {

    private HeapSort heap;

    @Before
    public void setUp() throws Exception {
        heap = new HeapSort();
    }

    @Test
    public void testInsertItem() throws IllegalAccessException {
        heap.insert(42);
        heap.printArray();
        heap.insert(35);
        heap.printArray();
        heap.insert(18);
        heap.printArray();
        heap.insert(29);
        heap.printArray();
        heap.insert(14);
        heap.printArray();
        heap.insert(7);
        heap.printArray();
        heap.insert(12);
        heap.printArray();
        heap.insert(1);
        heap.printArray();
        heap.insert(100);
        heap.printArray();
        heap.insert(10);
        heap.printArray();
        heap.insert(20);
        heap.printArray();
        heap.insert(30);
        heap.printArray();

        System.out.println("Extracted : "+heap.extract());
        System.out.println("Extracted : "+heap.extract());
        System.out.println("Extracted : "+heap.extract());
        System.out.println("Extracted : "+heap.extract());
        System.out.println("Extracted : "+heap.extract());
        System.out.println("Extracted : "+heap.extract());
        System.out.println("Extracted : "+heap.extract());
        System.out.println("Extracted : "+heap.extract());
        System.out.println("Extracted : "+heap.extract());
        System.out.println("Extracted : "+heap.extract());
        System.out.println("Extracted : "+heap.extract());
        System.out.println("Extracted : "+heap.extract());


    }

    public void testPoll() {
    }
}