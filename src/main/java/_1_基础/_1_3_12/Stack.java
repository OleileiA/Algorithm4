package _1_基础._1_3_12;

/*
*   题目：编写一个stack用例，
*   增加一个copy方法，可以接受一个字符串的栈作为参数，
*   然后返回一个副本
*   PS： 利用迭代器实现，不需要修改其他API
*/

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{

    private class Node {
        Item item;
        Node next;
    }

    private int N;

    private Node first;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Item peek() {
        return first.item;
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

    static Stack<String> copy(Stack<String> strings) {
        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        for(String s : strings) {
            stack1.push(s);
        }
        for (String s : stack1) {
            stack2.push(s);
        }
        return stack2;
    }

    // 实现遍历器
    public Iterator<Item> iterator() {
        return new StackIterator();
    }
    private class StackIterator implements Iterator<Item> {

        private Node current = first;

        //  注意这里的思想，看起来是判断有没有下一个
        //  实际上是有当前的就行
        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {

        }
    }
}
