package _2_排序.基础排序.希尔排序;

public class Shell {

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

    public static void sort(Comparable[] a) {
        int N = a.length; // 获取到数组的长度
        int h = 1;

        while (h < N / 3) { // 1, 4, 13, 40, 121, 364, 1093 ...
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j>= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j , j - h);
                }
            }
            h = h / 3;
        }

    }
}
