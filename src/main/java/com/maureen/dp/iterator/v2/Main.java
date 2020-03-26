package com.maureen.dp.iterator.v2;


/**
 * 构建一个容器，可以添加对象
 * v1:用数组来实现一个容器
 * v2:用链表来实现一个容器
 */
public class Main {
    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());
    }
}

