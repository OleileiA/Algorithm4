package _1_基础.实验题;

/*
* 使用动态数组调整实现Deque中的所有API
* Deque() 构造方法
* isEmpty
* size
* pushLeft
* pushRight
* popLeft
* popRight
* */

public class ResizingArrayDeque<Item> {

    private Item[] a;

    private int N;

    private int head = 0;

    private int tail = 0;

    private void resize(int len) {
        Item[] temp = (Item[]) new Object[len];
        for (int i = 0; i < N; i++) {
            temp[i] = a[(head + i) % a.length];
        }
        head = 0;
        tail = N;
        a = temp;
    }

    public ResizingArrayDeque(int size) {
        a = (Item[]) new Object[size];
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

    public void pushLeft(Item item) {
        if (N == a.length) resize(a.length * 2);
        head = ((head - 1) + a.length) % a.length;
        a[head] = item;
        N++;
    }

    public Item popRight() {
        tail = ((tail - 1) + a.length) % a.length;
        Item item = a[tail];
        N--;
        if (N == a.length / 4) resize(a.length / 2); // 可以放在后面
        return item;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> resizingArrayDeque = new ResizingArrayDeque<Integer>(4);
        resizingArrayDeque.pushRight(1);
        resizingArrayDeque.pushRight(2);
        resizingArrayDeque.pushRight(3);
        resizingArrayDeque.pushRight(4);
        resizingArrayDeque.pushLeft(0);
        resizingArrayDeque.popLeft();
        resizingArrayDeque.pushLeft(-1);
        resizingArrayDeque.pushLeft(-2);
        resizingArrayDeque.pushLeft(-3);
        resizingArrayDeque.pushLeft(-4);
        while (!resizingArrayDeque.isEmpty()) {
            System.out.println(resizingArrayDeque.popRight());
        }
    }
}
