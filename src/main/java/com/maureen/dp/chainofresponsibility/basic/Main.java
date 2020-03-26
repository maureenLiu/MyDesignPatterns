package com.maureen.dp.chainofresponsibility.basic;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>, 欢迎访问maureen.com, 大家都是996");

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter())
                .add(new SensitiveFilter());

        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter())
                .add(new URLFilter());

        fc.add(fc2);
        fc.doFilter(msg);

        System.out.println(msg);
    }
}
