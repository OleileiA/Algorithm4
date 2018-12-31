package _1_基础.实验题;

import edu.princeton.cs.algs4.LinkedStack;
import edu.princeton.cs.algs4.StdIn;

/*
* 前移编码
* 要求：从标准输入读取字符串，去重使用链表存储
* 1. 读取一个从未见过的字符时，插入表头
* 2. 读取一个重复的字符时，把它从链表删除，然后再次插入表头
*
* 实现了迁移编码策略，假设最近访问的元素很有可能再次访问，常用于缓存和数据压缩应用场景。
* 感觉使用链表实现的栈比较合适
* */
public class MoveToFront<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node head;

    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = head;
        head = new Node();
        head.item = item;
        head.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = head.item;
        head = head.next;
        N--;
        return item;
    }

    public void remove(Item item) {
        Node tempHead = head;
        Node preOne = head;
        while (tempHead != null) {  // char类型直接比较就可以了
            if (tempHead.item == item) {
                preOne.next = tempHead.next;
                N--;
                break;
            }
            preOne = tempHead;
            tempHead = tempHead.next;
        }
    }


    public static void main(String[] args) {
        MoveToFront<Character> moveToFront = new MoveToFront<Character>();
        while (!StdIn.isEmpty()) {
            char a = StdIn.readChar();
            moveToFront.remove(a);
            moveToFront.push(a);
        }

        while (!moveToFront.isEmpty()) {
            System.out.println(moveToFront.pop());
        }
    }
}
