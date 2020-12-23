package com.algorithim.datastructure;

import com.algorithim.datastructure.misc.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StackTest {

    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
    }

    @Test
    public void testPushPop(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(true,stack.contains(3));
        Assert.assertEquals(true,stack.contains(1));
        Assert.assertEquals(false,stack.contains(33));
        Assert.assertEquals(3,stack.pop());
        Assert.assertEquals(2,stack.pop());
        Assert.assertEquals(1,stack.pop());
        Assert.assertEquals(-1,stack.pop());
        Assert.assertEquals(false,stack.contains(4000));
    }

}