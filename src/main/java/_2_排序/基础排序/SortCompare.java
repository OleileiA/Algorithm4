package _2_排序.基础排序;

import _2_排序.基础排序.希尔排序.Shell2;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

	public static double time(String name, Comparable[] a) {
		Stopwatch timer = new Stopwatch();
		if (name.equals("Shell")) Shell.sort(a);
		if (name.equals("Shell2")) Shell2.sort(a);
		return timer.elapsedTime();
	}

	public static void main(String[] args) {
		double totalTime = 0.0;
		int N = 1000000; // 长度是10
		int T = 1;

		Double[] a = new Double[N]; // N长度数组
		for (int t = 0; t < T; t++) { //T次测试
			for (int i = 0; i < N; i++) {
				a[i] = StdRandom.uniform();
			}
			totalTime += time("Shell2", a);
		}
		System.out.println(totalTime);
	}
}
