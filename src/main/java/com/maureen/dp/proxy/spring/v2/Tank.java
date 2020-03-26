package com.maureen.dp.proxy.spring.v2;

public class Tank {
    public void move() {
        System.out.println("Tank moving claclacla....");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
