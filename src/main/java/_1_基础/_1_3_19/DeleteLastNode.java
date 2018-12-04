package _1_基础._1_3_19;

import _1_基础.栈.LinkedStack;

public class DeleteLastNode<Item> {


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

    /*
     *  题目要求给出链表的first节点，写出一个方法删除掉最后一个节点
     */
    public void deleteTheLast() {
        if (first == null) return; // 一个都没有直接return

        Node a = first;
        if (a.next == null) { // 如果只有first一个元素就直接删除
            first = null;
            return;
        }

        // 永远活动两个引用，保证可以将前一个next指向为空
        Node b = a.next;
        while (b.next != null) {
            a = b;
            b = b.next;
        }
        a.next = null;
        N--;
    }



    /*
     * 编写一个delete方法，接受参数K， 删除第K个元素如果存在的话
     *
     * */

    public void delete(int K) {
        if (K > N) {
            System.out.println("不存在第" + K + "个元素");
            return;
        }
        if (K == 1) {
            first = first.next;
        } else {
            int i = 1;
            Node a = first;
            while (i < K - 1) {
                a = a.next;
                i++;
            }
            a.next = a.next.next;
        }
        N--;
    }


    /*
     * 编写一个find方法，接受一条链表和字符串key作为参数，如果链表中的item等于这个key就返回true，否则false
      * 都应该只使用链表，写着写着忘了
      *
      * */
    public boolean find(DeleteLastNode<String> deleteLastNode, String key) {
        while (!deleteLastNode.isEmpty()) {
            if (deleteLastNode.pop().equals(key)) {
                return true;
            }
        }
        return false;
    }


    /*
     *  编写一个removeAfter方法
      *
      * 参数传入一个节点，并且删除该节点的一个后续节点
      *
      *
      * */
    public void removeAfter(Node node) {
        Node a = first;
        while (a != node) {
            if (a.next != null) a = a.next;
            else return;
        }
        if (a.next != null) {
            a.next = a.next.next;
        }
    }


    public static void main(String[] args) {
        DeleteLastNode<String> deleteLastNode = new DeleteLastNode<String>();
        deleteLastNode.push("1");
        deleteLastNode.push("2");
        deleteLastNode.push("3");
        deleteLastNode.push("4");
        deleteLastNode.push("5");
        deleteLastNode.push("6");
        deleteLastNode.push("7");
        deleteLastNode.push("8");
        deleteLastNode.push("9");
        deleteLastNode.push("10");
//        deleteLastNode.deleteTheLast();
//        deleteLastNode.delete(3);
//        while (!deleteLastNode.isEmpty()) {
//            System.out.println(deleteLastNode.pop());
//        }
//       System.out.println( deleteLastNode.find(deleteLastNode, "3"));

    }

}
