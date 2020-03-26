package com.maureen.dp.iterator.v2;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
//底层使用链表实现
public class LinkedList_ {
    Node head = null;
    Node tail = null;

    private int size = 0;

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

    public int size() {
        return size;
    }

    private class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }
}
