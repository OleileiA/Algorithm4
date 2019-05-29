package _1_基础.链表系列;

import java.security.PublicKey;

// 给双向链表
// 实现push, pop, dequeue, enqueue, insertBefore, insertAfter, delete
public class DoubleNode<Item> {
    private class Node {
        Item item;
        Node prev;
        Node next;
    }

    Node first;
    Node last;
    int N;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // 顶上加一个
    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            Node oldFirst = first;
            node.next = oldFirst;
            oldFirst.prev = node;
            first = node;
        }
        N++;
    }

    // 顶上删一个
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }
        return item;
    }

    // 队尾增加一个
    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            Node oldLast = last;
            oldLast.next = node;
            node.prev = oldLast;
            last = node;
        }
        N++;
    }

    // 队尾删除一个
    public Item dequeue() {
        Item item = last.item;
        last = last.prev;
        N--;
        if (isEmpty()) {
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }

    //insertBefore,  item1插入item2之前
    public void insertBefore(Item item1, Item item2) {
        Node node = first;
        while (node != null) {
            if (node.item.equals(item2)) {
                Node newOne = new Node();
                newOne.item = item1;
                Node prevNode = node.prev;

                newOne.next = node;
                node.prev = newOne;
                if (prevNode == null) { // 不是first
                    first = newOne;
                } else {
                    prevNode.next = newOne;
                    newOne.prev = prevNode;
                }
                N++;
                break;
            }
            node = node.next;
        }
    }
//    insertAfter
    public void insertAfter(Item item1, Item item2) {
        Node node = first;
        while (node != null) {
            if (node.item.equals(item2)) {
                Node newOne = new Node();
                newOne.item = item1;
                Node nextNode = node.next;

                node.next = newOne;
                newOne.prev = node;
                if (nextNode == null) {
                    last = newOne;
                } else {
                    nextNode.prev = newOne;
                    newOne.next =nextNode;
                }
            }
        }
    }

    // delete
    public void delete(Item item) {
        Node node = first;
        while (node != null) {
            if (node.item.equals(item)) {
                Node prev = node.prev;
                Node next = node.next;
                if (prev == null && next == null) {
                    first = null;
                    last = null;
                } else if (prev == null) {
                    first = next;
                    first.prev = null;
                } else if (next == null) {
                    last = prev;
                    last.next = null;
                } else {
                    prev.next = next;
                    next.prev = prev;
                }

                N--;
            }
            node = node.next;
        }
    }


    public static void main(String[] args) {
        DoubleNode<String> doubleNode = new DoubleNode<String>();

        doubleNode.enqueue("1");
        doubleNode.enqueue("2");
        doubleNode.enqueue("3");
        doubleNode.enqueue("4");
        doubleNode.enqueue("5");

        doubleNode.delete("5");
        while (!doubleNode.isEmpty()) {
            System.out.println(doubleNode.pop());
        }
    }
}
