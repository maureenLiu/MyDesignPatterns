package com.maureen.dp.iterator.v1;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
//底层使用数组实现的
public class ArrayList_ {
    Object[] objects = new Object[10];

    private int index = 0; //objects中下一个空的位置在哪儿，或者说，目前容器中有多少个元素

    public void add(Object o) {
        if (index == objects.length) {
            Object[] newObjects = new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index++;
    }

    public int size() {
        return index;
    }
}
