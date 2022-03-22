package com.algorithim.datastructure.stack;

import java.util.*;

public class StockSpanner {

    private Stack<Pair> stack;

    private int day;

    StockSpanner() {
        stack = new Stack();
        day = 0;
    }

    public int next(int price) {
        int span;
        while (!stack.isEmpty() && stack.peek().price < price) stack.pop();
        day += 1;
        if (!stack.isEmpty()) {
            span = day - stack.peek().span;
        } else {
            span = day;
        }
        stack.push(new Pair(price, day));
        System.out.println(span);
        return span;
    }

    public static void main(String[] args) {
        //["StockSpanner","next","next","next","next","next","next","next","next","next","next"]
        //[[],[28],[14],[28],[35],[46],[53],[66],[80],[87],[88]]
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(28);
        stockSpanner.next(14);
        stockSpanner.next(28);
        stockSpanner.next(35);
        stockSpanner.next(46);
        stockSpanner.next(53);
        stockSpanner.next(66);
        stockSpanner.next(80);
        stockSpanner.next(87);
        stockSpanner.next(88);
        //[null,1,1,3,4,5,6,7,8,9,10]
    }

}

class Pair {
    int price;
    int span;

    Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}
