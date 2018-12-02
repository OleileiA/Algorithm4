package _1_基础._1_3_12;

import org.junit.Test;

public class Try {

    @Test
    public void tryStack() {

        Stack<String> stack = new Stack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");

        for (String s : Stack.copy(stack)) {
            System.out.print(s);
        }
    }
}
