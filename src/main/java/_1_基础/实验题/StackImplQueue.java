package _1_基础.实验题;


/*
* 题目要求是使用若干个栈实现一个队列
* 要求是出入都是常数级别的复杂度操作
* 备注是题目非常难，搜索网上的答案是使用6个栈来实现
* */

// 六个栈分别为：H T H' T' HR h

/*
* 1. T中元素数量大于H元素数量的时候开始复制
*
* 2. 复制开始后，T' 负责 enqueue
*
* 3. 复制开始时，enqueue和dequeue都要转移T-> H'
*
* 4. H,T为空的时候交换 H' T'
*
* 5. HT交换的时候H不一定为空，直接交换H可能造成数据丢失
* 所以需要一个HR负责转移H中的数据。全部转移到HR之后在转移到H'。之后在交换H和H'
*
*   增加HR栈复制H
* （操作次数增加到了 2k 次，k 代表栈 T 中的元素数量。（如果当 T 中元素数量大于 H 中元素数量时开始复制））
* （我们可以在每一次出/入队操作执行时进行两次的复制步骤（对 T 和 H 进行两次的 Pop 操作），时间复杂度仍为 O(1)
*
*   // 增加HR栈， 操作次数增加到2K我是明白的，但是每次复制的次数增加到2次，
*   // 就保持时间复杂度仍未O(1)么？ 一次复制一次或者两次在本质上没有区别把？
*
*
* 6. H->HR的复制过程中，不能支持dequeue, 所以我们需要一个h栈
* （H的浅复制）然后负责dequeue。
*
* 7. h中如果有dequeue，那么需要几个变量needCopy记录HR中需要复制的元素数量
*    HR中进入元素 needCopy + 1
*    h栈的 元素dequeue 则 needCopy - 1
*
*    最后HR -> H 的复制，只复制needCopy个数就可以了
*
* */


/*
* 程序设计
根据之前的内容，我们可以开始设计程序了。主要实现三个功能，Enqueue(), Dequeue() 和 Peek()。

根据算法要求我们添加一个进行复制时操作的函数 OneStep()，用于执行元素的复制，栈交换等操作。

Peek() 只需要根据是否在进行复制选择栈 h 或栈 H 进行 Peek()。

Enqueue()

如果不处于复制状态
如果 H.Length – T.Length > 0，直接将元素压入栈 T。
否则令 IsCopying = true，h 进行浅拷贝，进行两次的 OneStep。
如果处于复制状态，将元素压入 T'，进行两次的 OneStep。
Dequeue()

如果不处于复制状态
如果 H.Length – T.Length > 0，直接从 H 弹出元素。
否则从 H 弹出元素，IsCopying = true，h 进行浅拷贝，进行两次的 OneStep。
如果处于复制状态，从 h 弹出元素，needcopy - 1，进行两次的 OneStep。
OneStep()

如果不处于复制状态，什么也不做。
如果处于复制状态。
如果 H 和 T 都不为空，从 H 搬运一个元素至 HR ，从 T 搬运一个元素至 H' ，needcopy + 1。
如果 H 为空但 T 不为空，从 T 搬运一个元素至 H' 。
如果 H 和 T 都为空，但 needcopy > 1，从 HR 搬运一个元素至 H' ，needcopy – 1。
如果 H 和 T 都为空，但 needcopy = 1，从 HR 搬运一个元素至 H' ，needcopy – 1，交换 H 和 H' 以及 T 和 T'，其他栈置空，退出复制状态。
如果 H 和 T 都为空，但 needcopy = 0，交换 H 和 H' 以及 T 和 T'，其他栈置空，退出复制状态。
*
*/


import _1_基础._1_3_12.Stack;

public class StackImplQueue<Item> {

}
