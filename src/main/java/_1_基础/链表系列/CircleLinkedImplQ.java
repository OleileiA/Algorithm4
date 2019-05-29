package _1_基础.链表系列;

// 使用环形链表实现队列
public class CircleLinkedImplQ<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node last;

    private int N;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;

        if (isEmpty()) {
            last = node;
            last.next = last;
        } else {
            Node first = last.next;
            last.next = node;
            node.next = first;
        }
        N++;
    }

    public Item dequeue() {
        Node first = last.next;
        Item item = first.item;
        last.next = first.next;
        N--;
        return item;
    }

    public static void main(String[] args) {
        CircleLinkedImplQ<String> circleLinkedImplQ = new CircleLinkedImplQ<String>();
        circleLinkedImplQ.enqueue("1");
        circleLinkedImplQ.enqueue("2");
        circleLinkedImplQ.enqueue("3");
        circleLinkedImplQ.enqueue("4");
        circleLinkedImplQ.enqueue("5");
        while (!circleLinkedImplQ.isEmpty()) {
            System.out.println(circleLinkedImplQ.dequeue());
        }
    }
}
