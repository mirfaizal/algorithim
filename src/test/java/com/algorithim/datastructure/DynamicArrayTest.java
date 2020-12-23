package com.algorithim.datastructure;

import com.algorithim.datastructure.misc.DynamicArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DynamicArrayTest  {

    private DynamicArray dynamicArray;

    @Before
    public void setUp() throws Exception {
        dynamicArray = new DynamicArray(4);
    }

    @Test
    public void testGetSet(){
        dynamicArray.set(0,"A");
        Assert.assertEquals("A",dynamicArray.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSetIndexOutOfBoundsException(){
        dynamicArray.set(5,"A1");
    }

    @Test
    public void testAddGet(){
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("D");
        dynamicArray.add("E");
        Assert.assertEquals("A",dynamicArray.get(0));
        Assert.assertEquals("B",dynamicArray.get(1));
        Assert.assertEquals("C",dynamicArray.get(2));
        Assert.assertEquals("D",dynamicArray.get(3));
        Assert.assertEquals("E",dynamicArray.get(4));
    }

    @Test
    public void testInsert(){
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("D");
        dynamicArray.add("E");
        dynamicArray.add("F");
        dynamicArray.add("G");
        dynamicArray.add("H");
        dynamicArray.insert(2,"123");
        Assert.assertEquals("A",dynamicArray.get(0));
        Assert.assertEquals("B",dynamicArray.get(1));
        Assert.assertEquals("123",dynamicArray.get(2));
        Assert.assertEquals("C",dynamicArray.get(3));
        Assert.assertEquals("D",dynamicArray.get(4));
        Assert.assertEquals("E",dynamicArray.get(5));

    }

    @Test
    public void testDelete(){
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("D");
        dynamicArray.delete(2);
        Assert.assertNotEquals("C",dynamicArray.get(2));
        Assert.assertEquals("D",dynamicArray.get(2));
    }

    @Test
    public void testIsEmpty(){
        Assert.assertTrue(dynamicArray.isEmpty());
        dynamicArray.add("A");
        Assert.assertFalse(dynamicArray.isEmpty());
    }

    @Test
    public void testContains(){
        Assert.assertFalse(dynamicArray.contains("D"));
        dynamicArray.add("D");
        Assert.assertTrue(dynamicArray.contains("D"));
    }

}