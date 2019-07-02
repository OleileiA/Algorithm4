package _2_排序.归并排序;

public class MergeSort {

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

	// 辅助数组
	private static Comparable[] temp;

	// 在合并数组的时候，不希望开辟一个新的数组内存空间
	public static void merge(Comparable[] arr, int start, int mid, int end) {

		// 分别记住左边数组的开始位和右边数组的开始位(其实是一个数组只记位置)
		int i = start;
		int j = mid + 1;

		// 把参数数组中的元素，从头到尾移动到临时数组中去
		for (int k = start; k <= end; k++) {
			temp[k] = arr[k];
		}

		// 调整顺序
		// 左边的用尽了就取右边
		// 右边的用尽了就取左边
		// 右边小于左边就取右边
		// 左边小于右边就取左边
		for (int k = start; k <= end; k++) {
			if (i > mid)						arr[k] = temp[j++];
			else if (j > end)					arr[k] = temp[i++];
			else if (less(temp[j], temp[i])) 	arr[k] = temp[j++];
			else								arr[k] = temp[i++];
		}
	}
	public static void sort(Comparable[] a) {
		temp = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int start, int end) {
		if (end <= start) return;
		int mid = start + (start + end) / 2;
		sort(a, start, mid);// 左边排序
		sort(a, mid + 1, end); // 右边排序
		merge(a, start, mid, end); // 数组归并
	}
}
