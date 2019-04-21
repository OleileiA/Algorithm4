package _1_基础._1_3_4;

import _1_基础.栈.LinkedStack;
import edu.princeton.cs.algs4.StdIn;

public class Parentheses {
    private LinkedStack<Character> linkedStack = new LinkedStack<Character>();
    public void pare() {
        while (!StdIn.isEmpty()) {
            char s = StdIn.readChar();
            try {
                if (s == ')') {
                    if (linkedStack.pop() != '(') {
                        System.out.println("错误");
                        return;
                    }
                } else if (s == ']') {
                    if (linkedStack.pop() != '[') {
                        System.out.println("错误1");
                        return;
                    }
                } else if (s == '}') {
                    if (linkedStack.pop() != '{') {
                        System.out.println("错误2");
                        return;
                    }
                } else {
                    linkedStack.push(s);
                }
            } catch (Exception e) {
                // 空栈再pop会出现异常
                System.out.println("错误4");
                return;
            }
        }
        if (!linkedStack.isEmpty()) {
            System.out.println("错误5");
            return;
        }
        System.out.println("配对");
    }

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        parentheses.pare();
    }
}
