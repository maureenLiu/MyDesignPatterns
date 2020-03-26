package com.maureen.dp.chainofresponsibility.servlet.v3;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        if (index == filters.size())
            return false;
        Filter f = filters.get(index);
        index++;
        return f.doFilter(request, response, chain);
    }
}
