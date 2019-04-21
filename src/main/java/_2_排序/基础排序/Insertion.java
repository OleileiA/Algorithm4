package _2_排序.基础排序;

/*
* 算法描述， 总是把当前的元素插入到已经有序的牌中的适当的位置。
* 当前索引的左边的元素都是有序的，但是位置不固定，我因为还需要为后续的元素腾出位置。
* 当索引一直遍历到最右时，排序完成。
*
*
*
* 推算比较次数和交换次数。假设为长度为N，而且没有重复元素完全打乱的情况下。
* 1.
*
* */

public class Insertion {

    // 排序算法的主要算法代码
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // 因为左边的索引是有序的，所以只需要交换到不小于昨天的元素即可
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
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
