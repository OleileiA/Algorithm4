package _1_基础._1_3_14;

import org.junit.Test;

public class TryresizingArrayQueue {

    @Test
    public void t() {
        ResizingArrayQueueOfStrings<String> resizingArrayQueueOfStrings = new ResizingArrayQueueOfStrings<String>(1);
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        resizingArrayQueueOfStrings.enqueue("1");
        while (!resizingArrayQueueOfStrings.isEmpty()) {
            System.out.println(resizingArrayQueueOfStrings.dequeue());
        }
    }
}
