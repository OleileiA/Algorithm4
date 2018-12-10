package _1_基础.实验题;

/*
*   使用双向链表实现这些API
*   1. Deque() 创建双向队列
*   2. isEmpty()
*   3. size()
*   4. pushLeft()
*   5. pushRight()
*   6. popLeft()
*   7. popRight()
*/

// TODO：我目前的实现每一个方法中都有有个判断，不知道是否还能更加简化？

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>{

    private class Node {
        Item item;
        Node next;
        Node pre;
    }

    private int N;

    private Node first;
    private Node last;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 左边推入
    public void pushLeft(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (isEmpty()) {
            last = first;
        }
        else {
            oldFirst.pre = first;
        }
        N++;
    }

    public void pushRight(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.pre = oldLast;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item popLeft() {
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = first;
        } else {
            first.pre = null;
        }
        return item;
    }


    public Item popRight() {
        Item item = last.item;
        last = last.pre;
        N--;
        if (isEmpty()) {
            first = last;
        } else {
            last.next = null;
        }
        return item;
    }


    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.pushRight(1);
        deque.pushRight(2);
        deque.pushRight(3);
        deque.pushRight(4);
        deque.pushRight(5);
        deque.pushRight(6);
        while (!deque.isEmpty()) {
            System.out.println(deque.popLeft());
        }
    }
}
