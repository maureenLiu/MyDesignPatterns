package com.maureen.dp.chainofresponsibility.servlet.v1;

public interface Filter {
    boolean doFilter(Request request, Response response);
}
