package com.maureen.dp.chainofresponsibility.servlet.v4;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
