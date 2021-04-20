package com.basicjava;

import java.util.concurrent.Callable;

interface Reptile {
    ReptileEgg lay();
}

class FireDragon implements Reptile{

    public FireDragon() {

    }

    @Override
    public ReptileEgg lay() {

        return new ReptileEgg(new Callable<Reptile>() {
            @Override
            public Reptile call() throws Exception {
                return null;
            }
        });
    }

    public static void main(String[] args) throws Exception {
        FireDragon fireDragon = new FireDragon();
        System.out.println(fireDragon instanceof Reptile);
    }
}

class ReptileEgg  {
    public ReptileEgg(Callable<Reptile> createReptile) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public Reptile hatch() throws Exception {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }
}
