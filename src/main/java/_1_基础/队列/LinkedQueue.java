package _1_基础.队列;

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

    private Node first;

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
}
