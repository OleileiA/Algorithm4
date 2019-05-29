package _1_基础.栈成对匹配;

// 题目：
// 从文本流中读取字符串类似于[]{}[{}]等形式，
// 判断其是否成对出现，成对则返回true，否则false

import _1_基础.栈.LinkedStack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parenthese {

    public static void main(String[] args) {
        LinkedStack<Character> linkedStack = new LinkedStack<Character>();
        LinkedStack<Character> linkedStack2 = new LinkedStack<Character>();
        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            switch (c) {
                case '[':
                    linkedStack.push(']');
                    break;
                case '{':
                    linkedStack.push('}');
                    break;
                case ']':
                    linkedStack2.push(']');
                    break;
                case '}':
                    linkedStack2.push('}');
                    break;
            }
        }
        if (linkedStack.size() != linkedStack2.size()) {
            StdOut.print("不配对");
        } else {
            for (int i = 0; i < linkedStack.size(); i++) {
                if (linkedStack.pop() != linkedStack2.pop()) {
                    StdOut.print("不配对");
                    return;
                } else {
                    StdOut.print("OK!");
                    return;
                }
            }
        }
    }
}
