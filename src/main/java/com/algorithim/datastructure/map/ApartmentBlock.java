package com.algorithim.datastructure.map;

import java.util.ArrayList;
import java.util.List;

public class ApartmentBlock {

    static final class Block {
        boolean gym;
        boolean school;
        boolean store;
        Block(boolean gym, boolean school, boolean store){
            this.gym = gym;
            this.school = school;
            this.store = store;
        }
    }


    public static void main(String[] args) {
        List<Block> blocks = new ArrayList<>();
        Block block = new Block(true,false,false);
        blocks.add(block);
        block = new Block(false,true,false);
        blocks.add(block);
        block = new Block(false,false,true);
        blocks.add(block);
        block = new Block(false,true,false);
        blocks.add(block);
        block = new Block(true,false,false);
        blocks.add(block);
        block = new Block(false,false,true);
        blocks.add(block);
        block = new Block(true,false,false);
        blocks.add(block);




    }
}
