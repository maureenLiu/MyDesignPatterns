package com.maureen.dp.iterator.v7;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
//底层使用链表实现
public class LinkedList_<E> implements Collection_<E> {
    Node head = null;
    Node tail = null;

    private int size = 0;

    @Override
    public void add(E o) {
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
        private E o;
        Node next;

        public Node(E o) {
            this.o = o;
        }
    }

    private class LinkedListIterator<E> implements Iterator_<E> {
        private int currentIndex = 0;
        Node temp = head;

        @Override
        public boolean hasNext() {
            if (currentIndex >= size) return false;
            return true;
        }

        @Override
        public E next() {
            if (temp != null) {
                E o = (E) temp.o;
                temp = temp.next;
                currentIndex++;
                return o;
            }
            return null;
        }
    }
}
