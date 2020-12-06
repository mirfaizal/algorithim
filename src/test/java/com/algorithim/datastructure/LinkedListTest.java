package com.algorithim.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LinkedListTest {

    private LinkedList linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new LinkedList();
    }

    @Test
    public void testAddFront(){
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        Assert.assertEquals(1,linkedList.getLast());
        Assert.assertEquals(3,linkedList.getFirst());
    }

    @Test
    public void testAddBack(){
        linkedList = new LinkedList();
        linkedList.addFront(1);
        linkedList.addBack(2);
        linkedList.addBack(3);
        //Assert.assertEquals(3,linkedList.getLast());
        //Assert.assertEquals(1,linkedList.getFirst());
        //linkedList.
        //System.out.println(linkedList.toString());
    }

    @Test
    public void testGetFirst(){

    }

    @Test
    public void testGetLast(){

    }

}