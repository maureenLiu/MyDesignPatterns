package com.maureen.dp.proxy.v6;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最简单的方法：修改代码，记录时间
 * 问题2：如果无法修改方法源码呢？
 * 用继承？
 * v04:使用代理
 * v05:代理有各种类型
 * 问题：如何实现代理的各种组合？继承？Decorator？
 * v06:代理的对象改成Movable类型-越来越像Decorator了
 * ====v06就是静态代理
 */

public class Tank implements Movable {
    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank t = new Tank();
        TankLogProxy tlp = new TankLogProxy(t);
        TankTimeProxy ttp = new TankTimeProxy(tlp);
        ttp.move();
//        new TankTimeProxy(
//                new TankLogProxy(
//                        new Tank())).move();
    }
}

class TankTimeProxy implements Movable {
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Movable {
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("start moving...");
        m.move();
        System.out.println("stopped!");
    }
}

interface Movable {
    void move();
}