package com.algorithim.datastructure;

import com.algorithim.datastructure.basic.QueueOld;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class QueueTest {

    private QueueOld queue;

    @Before
    public void setUp() throws Exception {
        queue = new QueueOld();
    }

    @Test
    public void testPushPop(){
        queue.push(1);
        queue.push(2);
        queue.push(3);
        Assert.assertEquals(true, queue.contains(3));
        Assert.assertEquals(false, queue.contains(33));
        Assert.assertEquals(1, queue.pop());
        Assert.assertEquals(2, queue.pop());
        Assert.assertEquals(3, queue.pop());
        Assert.assertEquals(-1, queue.pop());
        Assert.assertEquals(false, queue.contains(4000));
    }

}