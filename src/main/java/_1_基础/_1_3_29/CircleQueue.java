package _1_基础._1_3_29;

/*
* 利用环形链表实现队列
* （ 环形链表是没有任何节点的链接为空的链表，last.next = first ）
*  要求只能使用一个last node引用
*
*/


import javax.swing.plaf.PanelUI;
import java.util.Iterator;

public class CircleQueue<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private int N;

    private Node last;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /*
     * 注意就算只有一个也要自己指向自己
      *
      *
      * */
    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if(isEmpty()) {
            node.next = node;
            last = node;
        } else {
            Node oldOne = last.next;
            last.next = node;
            node.next = oldOne;
        }
        N++;
    }


    public Item dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue underflow");
        Item item = last.next.item;
        last.next = last.next.next;
        N--;
        return item;
    }

    public static void main(String[] args) {
        CircleQueue<String> circleQueue = new CircleQueue<String>();
        circleQueue.enqueue("1");
        circleQueue.enqueue("2");
        circleQueue.enqueue("3");
        circleQueue.enqueue("4");
        circleQueue.enqueue("5");

        while (!circleQueue.isEmpty()) {
            System.out.println(circleQueue.dequeue());
        }
    }
}
