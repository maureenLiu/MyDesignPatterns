package com.maureen.dp.visitor;

public abstract class ComputerPart {
    abstract void accept(Visitor v);

    //some other operations, eg:getName, getBrand
    abstract double getPrice();
}
