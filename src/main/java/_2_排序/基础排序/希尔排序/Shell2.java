package _2_排序.基础排序.希尔排序;

public class Shell2 {
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
		int N = a.length;
		int h = 1;

		int[] arr = new int[N / 3]; // 声明数组储存递增序列
		int counter = 0;

		while (h < N / 3) { // 1, 4, 13, 40, 121, 364, 1093 ...
			counter++;
			h = h * 3 + 1;
			arr[counter] = h;
		}

		for (; counter > 0; counter--) {
			int compareTimes = 0;
			for (int i = arr[counter]; i < N; i++) {
				for (int j = i; j>= arr[counter] && less(a[j], a[j - arr[counter]]); j -= arr[counter]) {
					compareTimes++;
					exch(a, j , j - arr[counter]);
				}
			}
			System.out.println("长度" + N + "系数:" + compareTimes / N);
		}
	}
}
