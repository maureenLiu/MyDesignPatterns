package com.maureen.dp.singleton;

public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05() {
    }

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            //妄图通过减小同步代码块的方式提高效率，但是不可行
            synchronized (Mgr05.class) {
                //testMultiThread();
                INSTANCE = new Mgr05();
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
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }
}
