package _1_基础._140;
import _1_基础.栈.ResizingArrayStack;

/*
*   要求把中序表达式转换为后序表达式。
*   波兰式是为了方便计算机直接进行表达式的运算而设计的，计算结果时不用考虑运算符优先级，而且没有括号。
*
中序表达式: 对人来说正常的表达式写法，但是对于电脑运算则比较复杂
2*3/(2-1)+3*(4-1)
2321-/*341-*+

波兰式：
前序表达式: 表达式的形式，从右至左扫描，一个线性表就可以实现计算值(每次计算符最近右侧两个数计算)
+ / * 2 3 - 2 1 * 3 - 4 1
二元运算符总是置于与之相关的两个运算对象之前，所以，这种表示法也称为前序表达式。


逆波兰式：
后序表达式：从左至右扫描
2 3 * 2 1 - / 3 4 1 - * +
二元运算符总是置于与之相关的两个运算对象之后，所以，这种表示法也称为后序表达式。

算法实现，循环中序表达式，操作数直接输出，左括号入栈，运算符根据优先级，如果栈顶的优先级大于读取的运算符就出栈，
否则读取的运算符直接入栈，遇见右括号栈内元素全部出栈，但是括号全部抛弃。

*/
public class InfixToPostfix {

    static boolean figureOperator(String a, String b) {
        return (a.equals("*") || a.equals("/")) && (b.equals("+") || b.equals("-"));
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> resizingArrayStack = new ResizingArrayStack<String>(10);
        String s = "2*3/(2-1)+3*(4-1)";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (c.equals("(") || c.equals("*") || c.equals("/")) {
                resizingArrayStack.push(c);
            } else if (c.equals("+") || c.equals("-")) {
                if (resizingArrayStack.peek() != null && (resizingArrayStack.peek().equals("*") || resizingArrayStack.peek().equals("/"))) {
                    result.append(resizingArrayStack.pop());
                }
                resizingArrayStack.push(c);
            } else if (c.equals(")")) {
                while (!resizingArrayStack.isEmpty()) {
                    String temp = resizingArrayStack.pop();
                    if (!temp.equals("(")) {
                        result.append(temp);
                    }
                }
            } else {
                result.append(c);
            }
        }
        System.out.println(result.toString());
        // 我的算法的结果：2321-/*341-*+
        // 与上面的注解例子中结果不同：23*21-/341-*+
        // 说明逆波兰式的不同算法的运算结果书写顺序不唯一，但是可以验证是否正确。
        //TODO: 可以理解为先计算表达式优先级高的部分对结果是没有影响的，所需顺序可以不同
        //TODO: 但是如果要求计算出所有正确的逆波兰式又是一个新的问题？
    }
}
