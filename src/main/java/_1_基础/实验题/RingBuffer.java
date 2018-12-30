package _1_基础.实验题;

/*
* 环形队列，又称为环形缓冲区
* 在进程间的异步数据传输或者记录日志文件时非常有用
*
* 设计API，并且使用环形数组来实现
*
* 1. new RingBuffer(int cap) // 新建一个环形缓存
* 2. clear 清空 ringBuffer 函数
* 3. 读数据函数
* 4. 写数据函数
* 5. 获取 ringBuffer 的长度
*
* 和ResizingArrayDeque感觉差不多
* */
public class RingBuffer<Item> {

    private Item[] a;

    private int N;

    private int head;

    private int tail;

    private void resize(int len) {
        Item[] temp = (Item[]) new Object[len];
        for (int i = 0; i < N; i++) {
            temp[i] = a[(head + i) % a.length];
        }
        a = temp;
        head = 0;
        tail = N;
    }

    public RingBuffer(int cap) {
        a = (Item[]) new Object[cap];
        N = cap;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 右入列
    public void pushRight(Item item) {
        if (N == a.length) resize(a.length * 2);
        // 这里维护的tail的大小总是在数组之内，我感觉没有必要，可以大于数组长度。
        // 在赋值的时候计算就可以了，但本质上没有区别
        a[tail] = item;
        tail = (tail + 1) % a.length;
        N++;
    }

    // 左出列
    public Item popLeft() {
        Item item = a[head];
        a[head] = null;
        head = (head + 1) % a.length;
        N--;
        if (N == a.length / 4) resize(a.length / 2); // 可以放在后面
        return item;
    }


}
