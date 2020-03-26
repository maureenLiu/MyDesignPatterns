package com.maureen.dp.observer.v4;

/**
 * 加入多个观察者
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

class Mom {
    public void hug() {
        System.out.println("Mom hug......");
    }
}

class Dog {
    public void wang() {
        System.out.println("Dog wang......");
    }
}

class Child {
    private boolean cry = false;
    private Dad d = new Dad();
    private Mom m = new Mom();
    private Dog dog = new Dog();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        d.feed();
        m.hug();
        dog.wang();
    }
}