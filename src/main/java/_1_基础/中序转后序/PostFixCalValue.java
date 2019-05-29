package _1_基础.中序转后序;

import _1_基础._1_3_12.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class PostFixCalValue {

	// 计算逆波兰表达式的值
	// 1334+*+ = 22
	public static void main(String[] args) throws Exception {
		Stack<Integer> stack = new Stack<Integer>();
		while (!StdIn.isEmpty()) {
			char c = StdIn.readChar();
			if (c >= '0' && c <= '9') { // 数字
				stack.push(Integer.parseInt(String.valueOf(c)));
			} else if ( c == '+') {
				stack.push(stack.pop() + stack.pop());
			} else if (c == '-') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
			} else if (c == '*') {
				stack.push(stack.pop() * stack.pop());
			} else if ( c == '/') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			} else {
				throw new Exception("别乱输入字符");
			}
		}
		System.out.println(stack.pop());
	}
}
