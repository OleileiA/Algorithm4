package _1_基础.栈;

/*
*   使用链表实现栈，相对于数组的实现。
*   链表实现了我们的最优目标：
*   1. 可以装载任意的类型
*   2. 所需要的空间和集合的大小成正比
*   3. 操作所需要的事件和集合的大小无关
*/
public class LinkedStack<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node first; // 链表实现的栈中，first代表栈顶, 而不是最先入栈的元素

    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
}
