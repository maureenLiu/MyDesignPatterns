package com.maureen.dp.chainofresponsibility.basic;

public class SensitiveFilter implements Filter { //关键词过滤
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll("996", "955");
        msg.setMsg(r);
        return true;
    }
}
