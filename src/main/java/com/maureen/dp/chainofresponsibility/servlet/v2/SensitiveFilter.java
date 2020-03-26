package com.maureen.dp.chainofresponsibility.servlet.v2;

public class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response) {
        //request.str = request.str.replaceAll("996","955");
        request.str += "--SensitiveFilter";
        response.str += "--SensitiveFilter";
        return true;
    }
}
