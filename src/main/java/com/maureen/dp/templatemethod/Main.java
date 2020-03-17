package com.maureen.dp.templatemethod;

public class Main {
    public static void main(String[] args) {
        F f = new C1();
        f.m();
    }
}

abstract class F {
    void m() {
        op1();
        op2();
    }

    abstract void op2();

    abstract void op1();
}

class C1 extends F {
    @Override
    void op2() {
        System.out.println("op2");
    }

    @Override
    void op1() {
        System.out.println("op1");
    }
}