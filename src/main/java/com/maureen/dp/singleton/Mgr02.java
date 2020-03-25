package com.maureen.dp.singleton;

/**
 * 和Mgr01是一个意思，只是将初始化INSTANCE的操作放到了静态代码块中
 */

public class Mgr02 {
    private static final Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02() {

    }

    public static Mgr02 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr02 mgr1 = Mgr02.getInstance();
        Mgr02 mgr2 = Mgr02.getInstance();

        System.out.println(mgr1 == mgr2); //true
    }
}
