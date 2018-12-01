package _1_基础._135;

import _1_基础.栈.ResizingArrayStack;
import edu.princeton.cs.algs4.StdOut;

public class PrintWhat {

    /*
     * 这个函数输出什么？
      * N 的二进制表示
      *
      * */

    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<Integer>(10);
        int N = 50;
        // 这个判断是没问题的。
        // 因为N是int类型，1 / 2 == 0
        // 不会产生小数
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int i : stack) {
            StdOut.print(i);
        }
        int a = 1;
        int b = 2;
        StdOut.println(a / b);
    }
}
