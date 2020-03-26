package com.maureen.dp.iterator.v5;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
//底层使用数组实现的
public class ArrayList_ implements Collection_ {
    Object[] objects = new Object[10];

    private int index = 0; //objects中下一个空的位置在哪儿，或者说，目前容器中有多少个元素

    @Override
    public void add(Object o) {
        if (index == objects.length) {
            Object[] newObjects = new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator_ {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex >= index) return false;
            return true;
        }

        @Override
        public Object next() {
            Object o = objects[currentIndex];
            currentIndex++;
            return o;
        }
    }
}
