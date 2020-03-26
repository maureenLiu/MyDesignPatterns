package com.maureen.dp.chainofresponsibility.servlet.v2;

public class HTMLFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        //request.str = request.str.replaceAll("<", "[").replaceAll(">","]");
        request.str += "--HTMLFilter";
        response.str += "--HTMLFilter";
        return true;
    }
}
