package _1_基础._1_3_14;

/*
*
*   利用数组实现可扩展的一个队列
*
*/
public class ResizingArrayQueueOfStrings<Item> {

    private Item[] arr;

    // N并不代表数组的长度，而代表实际的数量
    private int N;

    // 第一个元素的位置
    private int head;

    // 初始化数组的长度
    public ResizingArrayQueueOfStrings(int n) {
        arr = (Item[]) new Object[n];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int len) {
        Item[] temp = (Item[]) new Object[len];
        for (int i = 0; i < N; i++) {
            temp[i] = arr[i + head];
        }
        head = 0;
        arr = temp;
    }

    public void enqueue(Item item) {
        if (N == arr.length) resize(N * 2);
        arr[N++] = item;
    }

    public Item dequeue() {
        N--;
        Item item = arr[head++];
        if (N == arr.length / 4) resize(arr.length / 2);
        return item;
    }
}
