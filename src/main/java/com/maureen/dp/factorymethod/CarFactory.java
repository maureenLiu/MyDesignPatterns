package com.maureen.dp.factorymethod;

public class CarFactory {
    public Movable create() {
        System.out.println("a car created!");
        return new Car();
    }
}
