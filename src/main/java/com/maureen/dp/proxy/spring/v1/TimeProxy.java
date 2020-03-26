package com.maureen.dp.proxy.spring.v1;

//配置文件resources/app.xml中指明了如何切入代码的，也是动态代理
public class TimeProxy {
    public void before() {
        System.out.println("method start..." + System.currentTimeMillis());
    }

    public void after() {
        System.out.println("method stop..." + System.currentTimeMillis());
    }
}
