package com.algorithim.datastructure.string;

import java.util.*;

public class HashCodeAndEquals {
    private final String name;
    private final int age;
    private final String passport;

    public HashCodeAndEquals(String name, int age, String passport) {
        this.name = name;
        this.age = age;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof HashCodeAndEquals)) {
            return false;
        }
        HashCodeAndEquals hashCodeAndEquals = (HashCodeAndEquals) o;
        return age == hashCodeAndEquals.age &&
                Objects.equals(name, hashCodeAndEquals.name) &&
                Objects.equals(passport, hashCodeAndEquals.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main (String[] args)
    {
        HashCodeAndEquals hashCodeAndEquals1 = new HashCodeAndEquals("Faizal", 37,"123456");
        HashCodeAndEquals hashCodeAndEquals2 = new HashCodeAndEquals("Faizal", 37,"123456");

        Map<HashCodeAndEquals, String> map = new HashMap<>();
        map.put(hashCodeAndEquals1, "MCA");
        map.put(hashCodeAndEquals2, "BCA");

        for(Map.Entry<HashCodeAndEquals, String> geek : map.entrySet())
        {
            System.out.println(map.get(geek.getKey()));
        }

    }

}

