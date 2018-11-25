package _1_基础.栈;

/*
    字符串定容栈的缺点显而易见，就是只能装载String
    我们现在利用泛型来实现这个栈，可以装载其他的类型
 */
public class FixedCapacityStack<Item> {

    private Item[] a;

    private int N;

    // java 不支持声明泛型数组，所以需要强制类型转换方式来声明。

    // 数组不支持泛型的原因
    // 因为泛型在编译器的实现中实质就是强制类型转换
    // 泛型在编译器中的类型实质类型（类型擦除）就是父级类型（默认Object）
    // 如果在泛型数组中存入的利用向上转型的类型，而不能在编译器中强转成Item（声明的泛型）
    // 那么就会引发ClassCastException
    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }
}
