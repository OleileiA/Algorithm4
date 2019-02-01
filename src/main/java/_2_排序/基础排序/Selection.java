package _2_排序.基础排序;

/*
* 选择排序的算法思路：
* 遍历第一遍，找到最小的元素和第一个交换
* 遍历第二遍，找到第二小的元素和第二个交换，以此类推。
*
* 所以总的交换次数就是数组的长度N，
* 总的比较的次数为 N-1 + N-2 ... ... + 2 + 1 = N(N-1)/2 = N^2/2
*
* 特点：
* 1. 运行时间和输入数组已存在的顺序毫无关系。一个有序的数组和无序数组的排序时间一致。
* 2. 数据的移动是最少的，外圈的循环每次都会交换一次数组，一共是N次，线性关系。
*    其他的排序不具备这个特点，大多数是线性对数或者平方级别
* */
public class Selection {

    // 排序算法的主要算法代码
    public static void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i; // 注意细节
            for (int j = i + 1; j < len; j++) { //细节
                if (less(a[j], a[min])) min = j;
            }
            exch(a, min, i);
        }
    }

    // 辅助函数less
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // 辅助函数exch
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // 展示数组项函数show
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }

    // 测试数组是否有序的函数isSorted
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }
}
