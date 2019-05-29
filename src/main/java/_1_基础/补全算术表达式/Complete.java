package _1_基础.补全算术表达式;

import _1_基础._1_3_12.Stack;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

public class Complete {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<String>();
        // 1+2)*3-4)*5-6)))
        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            if (c == ')') {
                String s = "(" + stringStack.pop() + stringStack.pop() + stringStack.pop() + ")";
                stringStack.push(s);
            } else {
                stringStack.push(String.valueOf(c));
            }
        }
        System.out.println(stringStack.pop());// (((6-5)*(4-3))*(2+1)) 要想顺序一致,reverse即可。
    }
}
