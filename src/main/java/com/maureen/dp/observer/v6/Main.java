package com.maureen.dp.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离观察者与被观察者
 */
public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }
}

class Child {
    private boolean cry = false;

    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;

        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed");
        for (Observer o : observers) {
            o.actionOnWakeUp(event);
        }
    }
}

//事件类 fire event
class WakeUpEvent {
    long timestamp;
    String loc;

    public WakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }
}


interface Observer {
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer {

    public void feed() {
        System.out.println("Dad feeding...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }
}


class Mom implements Observer {

    public void hug() {
        System.out.println("Mom hug...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer {
    public void wang() {
        System.out.println("Dog wang...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        wang();
    }
}