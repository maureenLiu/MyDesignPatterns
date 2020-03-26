package com.maureen.dp.chainofresponsibility.servlet.v1;

public class HTMLFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]");
        return true;
    }
}
