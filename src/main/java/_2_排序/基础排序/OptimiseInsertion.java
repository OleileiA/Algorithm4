package _2_排序.基础排序;

/*
 * 使用缓存最小值的方式，优化插入排序
  *
  * */

public class OptimiseInsertion {

    // 交换
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 比较
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    // 原始的插入排序， 依靠交换
    public static void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    //优化后的选择排序
    public static void sort2(Comparable[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            Comparable val = a[i];
            int j = i;
            for (; j > 0 && less(a[j], a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = val;
        }
    }




    // 展示数组项函数show
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Comparable[] a = { 1, 2, 3, 5, 6, 9, 8, 7 };
        sort2(a);
        show(a);
    }

}
