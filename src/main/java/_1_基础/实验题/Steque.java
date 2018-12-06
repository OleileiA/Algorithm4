package _1_基础.实验题;
/*
 * 题目：实现一个Steque，以栈为目标的队列，支持push，pop和enqueue
  * 使用链表实现
  * */
public class Steque<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private int N;

    // 之前没有注意到的点，栈的顶必须是拥有next的顶端
    // first = first.next 就是 pop

    // 栈的顶，队列的尾
    private Node first;

    // 栈的底，队列的头
    private Node last;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (!isEmpty()) {
            oldLast.next = last;
        } else {
            first = last;
        }
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = first;
        }
        return item;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (!isEmpty()) {
            first.next = oldFirst;
        } else {
            last = first;
        }
        N++;
    }

    public static void main(String[] args) {
        Steque<String> stringSteque = new Steque<String>();
        stringSteque.enqueue("3");
        stringSteque.enqueue("4");
        stringSteque.enqueue("5");
        stringSteque.push("2");
        stringSteque.push("1");

        while (!stringSteque.isEmpty()) {
            System.out.println(stringSteque.pop());
        }
    }
}
