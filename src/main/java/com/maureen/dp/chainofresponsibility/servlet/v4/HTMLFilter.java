package com.maureen.dp.chainofresponsibility.servlet.v4;

public class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //request.str = request.str.replaceAll("<", "[").replaceAll(">","]");
        request.str += "--HTMLFilter";
        chain.doFilter(request, response); //如果不加这句，就不会执行下一个filter
        response.str += "--HTMLFilter";
    }
}
