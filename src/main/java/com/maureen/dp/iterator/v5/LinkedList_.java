package com.maureen.dp.iterator.v5;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
//底层使用链表实现
public class LinkedList_ implements Collection_ {
    Node head = null;
    Node tail = null;

    private int size = 0;

    @Override
    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;

        if (head == null) {
            head = n;
            tail = n;
        }
        tail.next = n;
        tail = n;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator();
    }

    private class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    private class LinkedListIterator implements Iterator_ {
        private int currentIndex = 0;
        Node temp = head;

        @Override
        public boolean hasNext() {
            if (currentIndex >= size) return false;
            return true;
        }

        @Override
        public Object next() {
            if (temp != null) {
                Object o = temp.o;
                temp = temp.next;
                currentIndex++;
                return o;
            }
            return null;
        }
    }
}
