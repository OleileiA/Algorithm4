package _1_基础.背包;

import java.util.Iterator;

/*
*   背包的特点和概念 ：
*   不支持从中删除元素，元素的存储没有顺序。
*   主要目的就是手机并且可以遍历元素。
*/
public class LinkedBag<Item> implements Iterable<Item>{
    private class Node {
        Item item;
        Node next;
    }
    private Node first;
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    // 实现遍历器：
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() { }
    }
}
