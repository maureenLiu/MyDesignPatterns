package com.maureen.dp.iterator.v7;

/**
 * 构建一个容器，可以添加对象
 * v1:用数组来实现一个容器
 * v2:用链表来实现一个容器
 * v3:添加容器的共同接口，实现容器的替换
 * v4:如何实现对容器遍历呢？
 * v5:用一种统一的遍历方式，要求每个容器提供Iterator的实现类
 * v6: JDK容器的Iterator
 * v7:实现泛型版本
 */
public class Main {
    public static void main(String[] args) {
        // Collection_<String> list = new ArrayList_<>();
        Collection_<String> list = new LinkedList_<>();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }

        Iterator_<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
    }
}
