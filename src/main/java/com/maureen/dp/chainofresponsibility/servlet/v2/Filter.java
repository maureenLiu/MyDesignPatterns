package com.maureen.dp.chainofresponsibility.servlet.v2;

public interface Filter {
    boolean doFilter(Request request, Response response);
}
