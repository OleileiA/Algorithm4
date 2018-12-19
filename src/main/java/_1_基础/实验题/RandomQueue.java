package _1_基础.实验题;

/*
* RandomQueue
*           RandomQueue   创建一条空的随机队列
* boolean   isEmpty()
* void      enqueue()
* Item      dequeue()  //
* Item      sample()
* 提示：
*       1. 使用动态可以调整的数组实现
*       2. 删除元素的时候随机一个元素和最后一个元素交换然后像stack一样删除并且返回末尾元素
* */

import org.omg.CORBA.PUBLIC_MEMBER;

public class RandomQueue<Item> {

    private Item[] a;

    private int N;

    private int head;

    private int tail;

    private void resize(int size) {
        Item[] tempArr = (Item[]) new Object[size];
        for (int i = 0; i < N; i++) {
            tempArr[i] = a[i];
        }
        a = tempArr;
    }

    public RandomQueue(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (N == a.length) resize(2 * N);
        a[tail++] = item;
        N++;
    }

    // 其实还是shuffle算法的思想
    public Item dequeue() {
        Item temp;
        if (N == (a.length / 4)) resize(a.length / 2);
        int random = (int) (Math.random() * N--);
        temp = a[random];
        a[random] = a[tail - 1];
        a[tail - 1] = temp;
        return a[tail-- -1];
    }

    public static void main(String[] args) {
        RandomQueue<Integer> randomQueue = new RandomQueue<Integer>(10);
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);
        randomQueue.enqueue(5);
        randomQueue.enqueue(6);
        randomQueue.enqueue(7);
        randomQueue.enqueue(8);
        randomQueue.enqueue(9);
        randomQueue.enqueue(10);
        randomQueue.enqueue(11);
        randomQueue.enqueue(12);
        randomQueue.enqueue(13);
        randomQueue.enqueue(14);
        randomQueue.enqueue(15);
        randomQueue.enqueue(16);
        randomQueue.enqueue(17);
        randomQueue.enqueue(18);
        while (!randomQueue.isEmpty()) {
            System.out.println(randomQueue.dequeue());
        }
    }
}
