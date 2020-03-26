package com.maureen.dp.observer.v3;

/**
 * 加入观察者
 */
public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }
}

class Dad {
    public void feed() {
        System.out.println("Dad feeding...");
    }
}

class Child {
    private boolean cry = false;
    private Dad d = new Dad();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        d.feed();
    }
}