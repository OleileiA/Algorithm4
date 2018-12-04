package _1_基础.队列;

import _1_基础.栈.LinkedStack;

/*
*   直接使用链表来实现队列
*   和栈不同，我们需要保持两个引用
*   first指向队列的开头
*   last指向队列的结尾
*
*/
public class LinkedQueue<Item> {

    private class Node {
        Item item;
        Node next;
    }

    // 为了测试reverseLinked方法临时修改为public
    public Node first;

    private Node last;

    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size () {
        return N;
    }

    // 注意dequeue和enqueue的细节

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

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = first;
        }
        return item;
    }

    // 参数是一个链表首引用，返回一个倒序的链表的首引用
    public Node reverseLinked(Node originFirst) {
        //
        Node first = originFirst;
        Node reverse = null;
        // 这里要注意，不可以判断first.next是否为null，否则会缺少一个元素。
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        // 验证
//        while (reverse != null) {
//            System.out.println(reverse.item);
//            reverse = reverse.next;
//        }
        return reverse;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<Integer>();
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        linkedQueue.enqueue(4);
        linkedQueue.enqueue(5);
        linkedQueue.reverseLinked(linkedQueue.first);
    }
}
