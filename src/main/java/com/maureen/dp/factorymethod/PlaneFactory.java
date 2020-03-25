package com.maureen.dp.factorymethod;

public class PlaneFactory {
    public Movable create() {
        System.out.println("a plane created!");
        return new Plane();
    }
}
