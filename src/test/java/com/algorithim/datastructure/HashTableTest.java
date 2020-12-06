package com.algorithim.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class HashTableTest {

    private HashTable hashTable;

    @Before
    public void setUp() throws Exception {
        hashTable = new HashTable();
    }

    @Test
    public void testPutGet(){
        hashTable.put("Faizal Ali","2B1234098765-211");
        hashTable.put("Faizal Mir","2B1234098765-212");
        hashTable.put("Faizal","2B1234098765-311");
        Assert.assertEquals("2B1234098765-211",hashTable.get("Faizal Ali"));
        Assert.assertEquals("2B1234098765-212",hashTable.get("Faizal Mir"));
    }
}