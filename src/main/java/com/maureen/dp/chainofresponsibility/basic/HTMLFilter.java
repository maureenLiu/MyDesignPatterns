package com.maureen.dp.chainofresponsibility.basic;

public class HTMLFilter implements Filter { //字符替换
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace('<', '[');
        r = r.replace('>', ']');

        msg.setMsg(r);

        return true;
    }
}
