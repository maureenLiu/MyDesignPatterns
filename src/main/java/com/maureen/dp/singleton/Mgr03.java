package com.maureen.dp.singleton;

/**
 * Lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来多线程安全问题
 */

public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {
    }

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            //testMultiThread();
            INSTANCE = new Mgr03();
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
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
