package com.maureen.dp.chainofresponsibility.basic;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        for (Filter f : filters) {
            if (!f.doFilter(msg)) return false; //如果想要终止在某个Filter上，就让该Filter的doFilter方法返回false
        }
        return true;
    }
}
