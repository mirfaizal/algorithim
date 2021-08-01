package com.basicjava;

import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static volatile int foo;

    Test(){
        foo =100;
    }
    List<Integer> modPlusOneFilter(List<Integer> input, Integer mod) {
        mod ++;
        Integer finalMod = mod;
        return input.stream().filter(element -> element % finalMod == 0).collect(Collectors.toList());
    }
    public static void main(String[] args) {

    }

}
