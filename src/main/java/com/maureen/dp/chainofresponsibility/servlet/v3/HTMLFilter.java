package com.maureen.dp.chainofresponsibility.servlet.v3;

public class HTMLFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        //request.str = request.str.replaceAll("<", "[").replaceAll(">","]");
        request.str += "--HTMLFilter";
        chain.doFilter(request, response, chain); //如果不加这句，就不会执行下一个filter
        response.str += "--HTMLFilter";
        return true;
    }
}
