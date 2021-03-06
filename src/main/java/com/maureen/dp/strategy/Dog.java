package com.maureen.dp.strategy;

public class Dog implements Comparable<Dog> {
    int food;

    @Override
    public int compareTo(Dog d) {
        if (this.food < d.food)
            return -1;
        else if (this.food > d.food)
            return 1;
        return 0;
    }

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
