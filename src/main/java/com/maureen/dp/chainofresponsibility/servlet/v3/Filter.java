package com.maureen.dp.chainofresponsibility.servlet.v3;

public interface Filter {
    boolean doFilter(Request request, Response response, FilterChain chain);
}
