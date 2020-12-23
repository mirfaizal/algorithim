package com.algorithim.datastructure;

import com.algorithim.datastructure.dynamic.FibonacciSeries;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FibonacciSeriesTest {

    FibonacciSeries fs;

    @Before
    public void setup(){
        fs = new FibonacciSeries();
    }

    @Test
    public void testFib() {
        fs.fib(5);
    }

    @Test
    public void testFibMemoize() {
        fs.fibMemoize(5);
    }

    @Test
    public void trimLeadingZero(){
        System.out.println(fs.trimLeadingZero("00000E0XXXX123EEE000"));
    }
}