package com.maureen.dp.singleton;

/**
 * Lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来多线程安全问题
 * 可以通过synchronized解决，但也带来效率下降
 */

public class Mgr06 {
    //必须加入volatile，是因为JIT(Java in-time compiler,指令重排频繁，没有初始化的时候就返回INSTANCE)
    //如果不加volatile，INSTANCE可能会产生半初始化对象
    //volatile：线程间可见；防止指令重排
    private static volatile Mgr06 INSTANCE;

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) { //这个判断也有必要，否则每次进来都会上锁，效率低下
            synchronized (Mgr06.class) {
                //双重检查
                if (INSTANCE == null) {
                    //testMultiThread();
                    INSTANCE = new Mgr06();
                }
            }
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
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
