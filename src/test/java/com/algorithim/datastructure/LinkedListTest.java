package com.algorithim.datastructure;

import com.algorithim.datastructure.basic.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LinkedListTest {

    private LinkedList linkedList;

    @Before
    public void setUp() {
        linkedList = new LinkedList();
    }

    @Test
    public void testAddFront(){
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.delete(1);
        Assert.assertEquals(2,linkedList.getLast());
        Assert.assertEquals(3,linkedList.getFirst());
    }

    @Test
    public void testAddBack(){
        linkedList = new LinkedList();
        linkedList.addFront(1);
        linkedList.addBack(2);
        linkedList.addBack(3);
    }

    @Test
    public void testRemoveDuplicate(){
        linkedList = new LinkedList();
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.addFront(4);
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.display();
        linkedList.removeDuplicate();
        Assert.assertEquals(4,linkedList.size());
    }

    @Test
    public void testKthToLast(){
        linkedList = new LinkedList();
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.addFront(4);
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        Assert.assertEquals(2,linkedList.kthToLast());
    }

    @Test
    public void testSumLinkedList(){
        linkedList = new LinkedList();
        linkedList.addFront(6);
        linkedList.addFront(1);
        linkedList.addFront(7);
        LinkedList linkedListTwo= new LinkedList();
        linkedListTwo.addFront(2);
        linkedListTwo.addFront(9);
        linkedListTwo.addFront(5);
        //linkedListTwo.reverse();
        System.out.println(linkedList.sumLinkedListBruteForce(linkedList.getFirstNode(),linkedListTwo.getFirstNode()));
    }

    @Test
    public void testHasCycle(){
        linkedList = new LinkedList();
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.addFront(4);
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        Assert.assertEquals(2,linkedList.kthToLast());
    }


    @Test
    public void testReverseInBetween(){
        linkedList = new LinkedList();
        // 1->2->3->4->5
        linkedList.addFront(5);
        linkedList.addFront(3);

        linkedList.reverseInBetween(1,2);
    }

    @Test
    public void testReverseOperationEvenNumbers(){
        linkedList = new LinkedList();
        linkedList.addFront(16);
        linkedList.addFront(12);
        linkedList.addFront(9);
        linkedList.addFront(8);
        linkedList.addFront(2);
        linkedList.addFront(1);

        linkedList.reverseOperationEvenNumbers();
    }
}