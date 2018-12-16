package _1_基础.实验题;

import java.util.Iterator;


/*
 * 实现随即背包API
 * 提示：使用数组实现背包，在迭代器的构造函数中打乱他们的顺序
 *
 * */

public class RandomBag<Item> implements Iterable<Item> {

    private Item[] a;

    private int N;

    /*
    * 注意：resize的方式会导致数组的洗牌算法出现问题导致无法遍历
    * 直接扩大二倍的方式再洗牌会导致空指针也被打乱。
    */

//    private void resize(int size) {
//        Item[] temp = (Item[]) new Object[size];
//        for (int i = 0; i < a.length; i++) {
//            temp[i] = a[i];
//        }
//        a = temp;
//    }

    public RandomBag(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
//        if (N == a.length) resize(a.length * 2);
        a[N] = item;
        N++;
    }

    /*
    * 又复习一遍遍历器的实现思想
    * */

    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item> {

        // 遍历器的构造器
        RandomBagIterator() {
            a = Shuffle.shuffle(a); // 涉及一个洗牌算法
        }

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


    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<Integer>(10);
        randomBag.add(1);
        randomBag.add(2);
        randomBag.add(3);
        randomBag.add(4);
        randomBag.add(5);
        randomBag.add(6);
        randomBag.add(7);
        randomBag.add(8);
        randomBag.add(9);
        randomBag.add(10);
        for (int a: randomBag) {
            System.out.println(a);
        }
    }
}
