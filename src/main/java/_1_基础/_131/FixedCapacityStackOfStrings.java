package _1_基础._131;


/*
*   题目：为这个类增加一个isFull()方法
*
*
*
*
*
*
*/

public class FixedCapacityStackOfStrings {

    private String[] a;

    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // 实现如下
    public boolean isFull() {
        return N == a.length;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

}
