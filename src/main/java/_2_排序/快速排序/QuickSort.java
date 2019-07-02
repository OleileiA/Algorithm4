package _2_排序.快速排序;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

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

	// 快速排序实现
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int start, int end) {
		if (end <= start) return;
		int mid = partition(a, start, end); // 分区

		// 递归
		sort(a, start, mid - 1);
		sort(a, mid + 1, end);
	}

	// 切分函数
	private static int partition(Comparable[] a, int start, int end) {
		// 左右扫描指针
		int s = start;
		int e = end + 1;

		// 随便取一个分区点，其实就是第一个元素
		Comparable mid = a[start];

		while (true) { // 不断的寻找，知道左右扫描指针相遇
			while (less(a[++s], mid)) if (s == end) break; // 左边从左向右找比区分点大的值
			while (less(mid, a[--e])) if (s == start) break; // 右边从右向左找比区分点小的值
			if (s >= e) break;
			exch(a, s, e); // 交换
		}
		exch(a, start, e); // 把分区点，放在正确的位置
		return e; // e已经是分区点的下标
	}
}
