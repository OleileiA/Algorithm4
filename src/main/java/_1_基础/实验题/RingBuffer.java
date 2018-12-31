package _1_基础.实验题;

/*
* 环形队列，又称为环形缓冲区
* 在进程间的异步数据传输或者记录日志文件时非常有用
*
* 设计API，并且使用环形数组来实现
*
* 1. new RingBuffer(int cap) // 新建一个环形缓存
* 2. clear 清空 ringBuffer 函数
* 3. 读数据函数 get
* 4. 写数据函数 put
* 5. 获取 ringBuffer 的长度
* 6.
* 特点：
* 大小是固定的所以没有resize
*
*
* 有在循环队列中永远预留一个空位的方式是为了区别判断条件
* 去判断队列是空的： head == tail
* 还是满的       ： head == (tail + 1) % a.length
*
* 但是我们的实现中记录个元素的个数N，所以不需要这样判断
* */
public class RingBuffer<Item> {

    private Item[] a;

    private int N;

    private int head;

    private int tail;

    public RingBuffer(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void put(Item item) {
        assert size() != N : "满了";
        a[tail] = item;
        tail = (tail + 1) % a.length;
        N++;
    }

    public Item get() {
        assert N == 0 : "空了";
        Item item = a[head];
        head = (head + 1) % a.length;
        N--;
        return item;
    }

    public void clear() {
        for (int i = 0; i < a.length; i++) {
            a[i] = null;
        }
        N = 0;
        head = 0;
        tail = 0;
    }

    public Item[] getAll() {
        Item[] temp = (Item[]) new Object[N];
        int i = 0;
        while (!isEmpty()) {
            temp[i] = get();
            i++;
        }
        return temp;
    }

    public static void main(String[] args) {
        RingBuffer<Integer> ringBuffer = new RingBuffer<Integer>(10);
        ringBuffer.put(1);
        ringBuffer.put(2);
        ringBuffer.put(3);
        ringBuffer.put(4);
        ringBuffer.put(5);
        ringBuffer.put(6);
        ringBuffer.put(7);
        ringBuffer.put(8);
        ringBuffer.put(9);
        ringBuffer.put(10);

        while (!ringBuffer.isEmpty()) {
            System.out.println(ringBuffer.get());
        }
    }
}
