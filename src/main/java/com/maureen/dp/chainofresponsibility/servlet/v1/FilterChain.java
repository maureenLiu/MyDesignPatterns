package com.maureen.dp.chainofresponsibility.servlet.v1;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response) {
        for (Filter f : filters) {
            f.doFilter(request, response);
        }
        return true;
    }
}
