package _1_基础.栈;
import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class TTest {

    @Test
    public void testFixedCapacityStackOfString() {
        FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(10);
        fixedCapacityStackOfStrings.push("one");
        fixedCapacityStackOfStrings.push("two");
        fixedCapacityStackOfStrings.push("three");
        fixedCapacityStackOfStrings.push("four");
        System.out.println(fixedCapacityStackOfStrings.size());
    }

    @Test
    public void testResizeTask() {
        ResizingArrayStack<String> resizingArrayStack = new ResizingArrayStack<String>(10);
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");
        resizingArrayStack.push("one");

        // 下面两种写法，等价
        Iterator<String> itemIterator = resizingArrayStack.iterator();
        while (itemIterator.hasNext()) {
            System.out.println(itemIterator.next());
        }

        for (String s : resizingArrayStack) {
            System.out.println(s);
        }
    }
}
