package com.maureen.dp.chainofresponsibility.servlet.v1;

public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:)，<script>, 欢迎访问maureen.com, 大家都是996";

        Response response = new Response();
        response.str = "";

        FilterChain chain = new FilterChain();
        chain.add(new HTMLFilter())
                .add(new SensitiveFilter());
        chain.doFilter(request, response);

        System.out.println(request.str);
    }
}
