package _1_基础.链表系列;

// 链表的练习题集合
public class ExerciseHub<Item> {
    private int N;
    private Node first;

    private class Node {
        Node next;
        Item item;
    }

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

    // 编写一段代码删除链表的尾节点
    public void deleteLastOne() {
        if (N == 1) {
            first = null;
            N--;
            return;
        }
        Node prev = first;
        Node node = first.next;
        while (node.next != null) {
            prev = node;
            node = node.next;
        }
        prev.next = null;
        N--;
    }

    // 编写一个find方法，寻找链表中的item相等，则返回true, 如果没有找到则则返回false
    public boolean find(Item val) {
        Node node = first;
        while (node != null) {
            if (node.item.equals(val)) return true;
            node = node.next;
        }
        return false;
    }

    // 编写一个removeAfter方法，方法接受某个节点作为参数，
    // 删除该节点的后续节点（如果参数节点或者参数的后续节点是空则什么都不做）
    public void removeAfter(Node node) {
        if (node != null && node.next != null) {
            node.next = node.next.next;
        }
    }

    // 接受两个节点作为参数
    // 将第二个节点插入链表并且成为第一个链表的参数的后续节点
    // (如果两个参数为空则什么都不做)
    public void insertAfter(Node front, Node back) {
        if (front != null && back != null) {
            back.next = front.next;
            front.next = back;
        }
    }

    // 编写一个remove方法, 删除链表中的所有的节点的值为key的节点
    public void remove(String key) {
        while (first.item.equals(key)) { // 第一个要特殊处理
            first = first.next;
            N--;
        }
        Node prev = first;
        Node node = prev.next;
        while (node != null) {
            if (node.item.equals(key)) {
                prev.next = node.next;
                N--;
            }
            prev = node;
            node = prev.next;
        }
    }

    // 编写一个函数，接受一个链表的首节点
    // 破坏性的把链表反转，并且返回结果链表的首节点
    public Node reverse(Node node) {
        Node first = node;
        Node bridge = null; // 把bridge理解为嫁接者,或者上一个
        while (first != null) {
            Node second = first.next;// 把第二个引用保存给second
            first.next = bridge; // 第1结点链接第2个结点的链接处断开了，指向嫁接者
            bridge = first; // 嫁接者指向前一个，下一个再循环的时候，上一步的next指向前一个结点，完成了next的倒转。
            first = second; // 转换下一个
        }
        return bridge;
    }


    public static void main(String[] args) {
        ExerciseHub<String> exerciseHub = new ExerciseHub<String>();
        exerciseHub.push("1");
        exerciseHub.push("2");
        exerciseHub.push("3");
        exerciseHub.push("4");
        exerciseHub.push("5");

        exerciseHub.remove("1");
        while (!exerciseHub.isEmpty()) {
            System.out.println(exerciseHub.pop());
        }
    }

}
