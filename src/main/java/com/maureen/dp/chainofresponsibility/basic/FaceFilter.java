package com.maureen.dp.chainofresponsibility.basic;

public class FaceFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace(":)", "^V^");
        msg.setMsg(r);
        return true;
    }
}