package _1_基础._1_3_31;

/*
* 题目：实现一个双向链表，每个元素都有一个
*
* 实现以下静态方法
*   1. 表头插入新元素
*   2. 表尾插入新元素
*   3. 表头删
*   4. 表尾删
*   5. 在指定节点之前插入新节点
*   6. 在指定节点之后插入新元素
*   7. 删除指定的节点
*
*
* */

//TODO：  先不写静态的，麻烦，回头查一下相关的语法。

public class DoubleNode<Item> {

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


    // 表头插入新元素
    public void unshift(Item item) {

        Node node = new Node();
        node.item = item;

        if (N == 0) {
            first = node;
            last = node;
            first.next = last;
            last.pre = first;
        } else {
            Node oldFirst = first;
            first = node;
            first.next = oldFirst;
            oldFirst.pre = first;
        }
        N++;
    }

    // 表尾增加
    public void push(Item item) {
        Node node = new Node();
        node.item = item;

        if (N == 0) {
            first = node;
            last = node;
            first.next = last;
            last.pre = first;
        } else {
            Node oldLast = last;
            last = node;
            last.pre = oldLast;
            oldLast.next = last;
        }
        N++;
    }

    //表头删除
    public Item shift() {
        Item item = first.item;
        first = first.next;
        first.pre = null;
        N--;
        if (N == 0) {
            last = first;
        }
        return item;
    }

    // 表尾删除
    public Item pop() {
        Item item = last.item;
        last = last.pre;
        // TODO: 好蠢
        if (N != 1) {
            last.next = null;
        }

        N--;
        System.out.println(N);
        if (N == 0) {
            first = last;
        }
        return item;
    }

    // 指定节点前插入
    public void insertBefore(Node node, Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (node == first) {
            unshift(item);
        } else {
            Node oldPre = node.pre;
            newNode.next = node;
            newNode.pre = oldPre;
            oldPre.next = newNode;
            node.pre = newNode;
            N++;
        }
    }

    // 指定节点后插入
    public void insertAfter (Node node, Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (node == last) {
            push(item);
        } else {
            Node oldNext = node.next;
            newNode.pre = node;
            newNode.next = oldNext;
            node.next = newNode;
            oldNext.pre = newNode;
            N++;
        }
    }

    // 删除指定的节点
    public Item deleteTheNode(Node node) {
        Item item = node.item;
        if (node == first) {
            shift();
        } else if (node == last) {
            pop();
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            N--;
        }
        return item;
    }

    public static void main(String[] args) {
        DoubleNode<Integer> doubleNode = new DoubleNode<Integer>();
        doubleNode.push(1);
        doubleNode.push(2);
        doubleNode.push(3);
        doubleNode.unshift(0);

        //  TODO: 太晚了，明天再调试
        while (!doubleNode.isEmpty()) {
            System.out.println(doubleNode.pop());
        }
    }
}
