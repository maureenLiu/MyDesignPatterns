package com.maureen.dp.factorymethod;

public class Main {
    public static void main(String[] args) {
        //Movable m = new CarFactory().create();
        Movable m = new PlaneFactory().create();
        m.go();
    }
}
