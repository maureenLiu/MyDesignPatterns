package com.maureen.dp.chainofresponsibility.servlet.v1;

public class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replaceAll("996", "955");
        return true;
    }
}
