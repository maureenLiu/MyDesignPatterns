package com.maureen.dp.singleton;

/**
 * Lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来多线程安全问题
 * 可以通过synchronized解决，但也带来效率下降
 */

public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {
    }

    //static synchronized 锁定的是Mgr04.class对象
    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            //testMultiThread();
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    private static void testMultiThread() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
