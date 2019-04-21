package _1_基础.Dijkstra的双栈算数表达式求值算法;

import _1_基础._1_3_12.Stack;
import edu.princeton.cs.algs4.StdIn;

public class Dijkstra {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> nums = new Stack<Double>();
        while (!StdIn.isEmpty()) {
            String s= StdIn.readString();
            System.out.println(s);
            if (s.equals("("))                  ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double num = nums.pop();
                if (op.equals("+")) num = nums.pop() + num;
                else if (op.equals("-")) num = nums.pop() - num;
                else if (op.equals("*")) num = nums.pop() * num;
                else if (op.equals("/")) num = nums.pop() / num;
                nums.push(num);
            } else {
                nums.push(Double.parseDouble(s));
            }
        }
        System.out.println(nums.pop());
    }
}
