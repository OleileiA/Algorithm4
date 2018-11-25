package _1_基础.栈;
/*
*   专注于理解概念：基于后进先出策略（LIFO）的集合类型，就像是抽屉中的一打书。
*   是计算机世界中非常重要的模型，浏览器回退功能的实现就依赖于栈。
*/

/*
*   API的确定：
*
*           Stack()                                    创建一个新的栈。
*   void    push(Item item)                            添加一个元素。
*   Item    pop()                                      删除最近添加的元素。
*   boolean isEmpty()                                  栈是否为空
*   int     size()                                     栈中的元素数量
*/

// 存储String的定容栈的基本实现
public class FixedCapacityStackOfStrings {

    private String[] a;

    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }
}

