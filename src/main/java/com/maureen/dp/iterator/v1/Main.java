package com.maureen.dp.iterator.v1;

/**
 * 构建一个容器，可以添加对象
 * v1:用数组来实现一个容器
 */
public class Main {
    public static void main(String[] args) {
        ArrayList_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());
    }
}

