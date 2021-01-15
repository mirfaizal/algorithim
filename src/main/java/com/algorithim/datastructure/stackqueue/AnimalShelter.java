package com.algorithim.datastructure.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

    enum AnimalType{
        DOG,CAT;
    }
    static class Animal {
        private AnimalType type;
        Animal(AnimalType type){
            this.type = type;
        }
    }
    Queue<Animal> dog , cat, any;
    AnimalShelter(){
        dog = new LinkedList<>();
        cat = new LinkedList<>();
        any = new LinkedList<>();
    }
    private void enqueue(Animal animal){
        if(animal.type == AnimalType.CAT){
            cat.add(animal);
        }else if(animal.type == AnimalType.DOG){
            dog.add(animal);
        }
        any.add(animal);
    }

    private Animal dequeueDog(){
        if(!dog.isEmpty()) return dog.poll();
        return null;
    }
    private Animal dequeueCat(){
        if(!cat.isEmpty()) return cat.poll();
        return null;
    }
    private Animal dequeueAny(){
        Animal animal = null;
        if(!any.isEmpty()) animal = any.poll();
        if(animal.type == AnimalType.CAT && !cat.isEmpty()) return cat.poll();
        if(animal.type == AnimalType.DOG && !dog.isEmpty()) return dog.poll();
        return animal;
    }

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Animal(AnimalType.CAT));
        animalShelter.enqueue(new Animal(AnimalType.DOG));
        animalShelter.enqueue(new Animal(AnimalType.DOG));
        animalShelter.enqueue(new Animal(AnimalType.CAT));
        animalShelter.enqueue(new Animal(AnimalType.CAT));
        animalShelter.enqueue(new Animal(AnimalType.CAT));
        animalShelter.enqueue(new Animal(AnimalType.DOG));
        animalShelter.enqueue(new Animal(AnimalType.DOG));
        animalShelter.enqueue(new Animal(AnimalType.DOG));
        System.out.println();
        animalShelter.dequeueAny();
        animalShelter.dequeueAny();
        animalShelter.dequeueAny();
        animalShelter.dequeueAny();
    }

}
