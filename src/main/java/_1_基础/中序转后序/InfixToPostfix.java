package _1_基础.中序转后序;

import _1_基础._1_3_12.Stack;
import edu.princeton.cs.algs4.StdIn;

public class InfixToPostfix {
	// 判断运算符的优先级,a 不低于 b 则返回true
	private static boolean opFirst(char a, char b) {
		if (b == '*' || b == '/') {
			if (a == '*' || b == '/') return true;
			else return false;
		} else {
			return true;
		}
	}
	// 判断是运算符
	private static boolean isop(char a) {
		return a == '+' || a == '-' || a == '*' || a == '/';
	}
	// 将普通的中序表达式转化为逆序表达式
	public static void main(String[] args) throws Exception {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder postfix = new StringBuilder();
		while (!StdIn.isEmpty()) {
			char c_in = StdIn.readChar();
			if (c_in >= '0' && c_in <= '9') { // 数字代表的字符直接就入栈
				stack.push(c_in);
			} else if (c_in == '(') { // 左括号直接入栈
				stack.push(c_in);
			} else if (c_in == ')') { // 右括号策略，出栈直到遇见左括号，否则一直拼接到postfix
				while (!stack.isEmpty()) {
					char c_out = stack.pop();
					if (c_out == '(') break;
					postfix.append(c_out);
				}
			} else { // 加减乘除进入这个判断，除非遇见左括号，和优先级低于c_in的操作符，否则出栈拼接到postfix
				while (true) {
					if (stack.isEmpty()) {
						stack.push(c_in);
						break;
					}
					char c_out = stack.peek();
					if (c_out == '(' || (isop(c_out) && !opFirst(c_out, c_in))) {
						stack.push(c_in);
						break;
					}
					postfix.append(stack.pop());
				}
			}
		}
		while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
		System.out.println(postfix.toString());
	}
}
