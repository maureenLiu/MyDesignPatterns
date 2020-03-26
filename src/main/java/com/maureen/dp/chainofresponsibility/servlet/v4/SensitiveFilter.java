package com.maureen.dp.chainofresponsibility.servlet.v4;

public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //request.str = request.str.replaceAll("996","955");
        request.str += "--SensitiveFilter";
        chain.doFilter(request, response);
        response.str += "--SensitiveFilter";
    }
}
