package com.maureen.dp.chainofresponsibility.servlet.v3;

public class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        //request.str = request.str.replaceAll("996","955");
        request.str += "--SensitiveFilter";
        chain.doFilter(request, response, chain);
        response.str += "--SensitiveFilter";
        return true;
    }
}
