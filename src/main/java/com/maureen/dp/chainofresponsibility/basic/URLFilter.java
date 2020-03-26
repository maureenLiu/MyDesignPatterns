package com.maureen.dp.chainofresponsibility.basic;

public class URLFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace("maureen.com", "http://maureen.com");
        msg.setMsg(r);
        return true;
    }
}
