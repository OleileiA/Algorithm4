package _1_基础._139;

import edu.princeton.cs.algs4.ResizingArrayStack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class completeTheString {

    private ResizingArrayStack<String> stringStack = new ResizingArrayStack<String>();
    private ResizingArrayStack<String> operStack = new ResizingArrayStack<String>();

    private void fixString() {
        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            String s = String.valueOf(c);
            if (s.equals("+")) {
                operStack.push(s);
            } else if (s.equals("-")){
                operStack.push(s);
            } else if (s.equals("*")) {
                operStack.push(s);
            } else if (s.equals("/")) {
                operStack.push(s);
            } else if (s.equals(")")) {
                // 如果是右括号就把数字和操作数分别取出来，拼成一个完整的，再放回StringStack
                String right = "(";
                String a = stringStack.pop();
                String b = stringStack.pop();
                right += b + operStack.pop() + a;
                right += s;
                stringStack.push(right);
            } else {
                stringStack.push(s);
            }
        }
        StdOut.print(stringStack.pop());
    }

    public static void main(String[] args) {
        completeTheString completeTheString = new completeTheString();
        completeTheString.fixString();
    }
}
