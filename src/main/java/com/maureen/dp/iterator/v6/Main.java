package com.maureen.dp.iterator.v6;

import com.maureen.dp.iterator.v4.ArrayList_;
import com.maureen.dp.iterator.v5.Iterator_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 构建一个容器，可以添加对象
 * v1:用数组来实现一个容器
 * v2:用链表来实现一个容器
 * v3:添加容器的共同接口，实现容器的替换
 * v4:如何实现对容器遍历呢？
 * v5:用一种统一的遍历方式，要求每个容器提供Iterator的实现类
 * v6:JDK的容器的Iterator
 */
public class Main {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        for (int i = 0; i < 15; i++) {
            c.add(new String("s" + i));
        }

        Iterator it = c.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
