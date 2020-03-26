package com.maureen.dp.chainofresponsibility.servlet.v4;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index == filters.size())
            return;
        Filter f = filters.get(index);
        index++;
        f.doFilter(request, response, this);
    }
}
