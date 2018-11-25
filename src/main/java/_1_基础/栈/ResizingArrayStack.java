package _1_基础.栈;

import java.util.Iterator;

/*
* 根据前两版本栈的实现，我们还有两个大方向上面的优化：
* 1. 我们的数组是定容的，必须预先知道容器的大小，才能分配内容，生成数组。
* 2. 没有实现遍历
*/
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a;

    private int N;

    // 加上resize函数用于调整容器大小
    private void resize(int len) {
        Item[] temp = (Item[]) new Object[len];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public ResizingArrayStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) { resize(2 * a.length); }
        a[N++] = item;
    }

    // 因为每次都会判断isEmpty，所不需要在这里判断
    public Item pop() {
        Item item = a[--N];
        a[N] = null; // 只是N的计数器大小在变化, 并没有真正的删除item,需要指向null, 防止对象游离。
        if (N > 0 && N == (a.length / 4)) { resize(a.length / 2); }
        return item;
    }

    // 实现Iterable接口的方法，就是实现一个返回遍历器的方法
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // 实现一个遍历器提供给iterator返回，并且要确保可以后进先出。
    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {

        }
    }
}
