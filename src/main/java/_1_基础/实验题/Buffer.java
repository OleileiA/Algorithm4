package _1_基础.实验题;

import _1_基础.栈.LinkedStack;

/*
* 文本编辑器的缓冲区
* 为文本编辑器的缓冲区设计一种数据类型并实现表中的API
* 1. Buffer: 创建一块缓冲区
* 2. void insert(char c) 在光标的位置插入c
* 3. char delete()       删除并且返回光标位置的字符
* 4. void left(int k)    将光标向左移动K个位置
* 5. void right
* 6. int size            缓冲区的字符数量
*
* 提示：使用两个栈实现
* 我的实现思路是永远是使用第一个栈的栈顶视为光标.
*
* */
public class Buffer<Item> {

    private LinkedStack<Item> leftLinkedStack;
    private LinkedStack<Item> rightLinkedStack;

    private int leftNumber;
    private int rightNumber;

    public Buffer() {
        leftLinkedStack = new LinkedStack<Item>();
        rightLinkedStack = new LinkedStack<Item>();
    }

    public void insert(Item item) {
        leftLinkedStack.push(item);
        leftNumber++;
    }

    public Item delete() {
        if (leftNumber != 0) {
            return leftLinkedStack.pop();
        }
        return null;
    }

    public void left(int k) {
        int i = 0;
        while (rightNumber != 0 && i < k) {
            rightLinkedStack.push(leftLinkedStack.pop());
            rightNumber++;
            leftNumber--;
            i++;
        }
    }

    public void right(int k) {
        int i = 0;
        while (leftNumber != 0 && i < k) {
            leftLinkedStack.push(rightLinkedStack.pop());
            leftNumber++;
            rightNumber--;
            i++;
        }
    }

    public int size() {
        return leftNumber + rightNumber;
    }


}
