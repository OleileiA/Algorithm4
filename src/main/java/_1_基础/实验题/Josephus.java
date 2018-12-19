package _1_基础.实验题;

import edu.princeton.cs.algs4.LinkedQueue;
import edu.princeton.cs.algs4.StdIn;

/*
* Josephus问题
* N个人围坐成一圈（0- N-1）
* 从第一个人开始报数报到M的人会被杀死，至到最后一个人活下来
* 使用queue实现这个过程
*
* 从命令行接受参数并打印死亡顺序
* % java Josephus 7 2 (7个人报2死)
* 1 3 5 0 4 2 6
*
* */
public class Josephus {

    public static void main(String[] args) {
            int a = StdIn.readInt(); // 总人数
            int b = StdIn.readInt(); // 地雷数

        LinkedQueue<Integer> linkedQueue = new LinkedQueue<Integer>();

        // 先把王八都装进去
        int i = 0;
        while (i < a) {
            linkedQueue.enqueue(i++);
        }

        // 再把王八捞出来按个放血
        int count = 1;
        while (!linkedQueue.isEmpty()) {
            if (count % b == 0) {
                System.out.print(linkedQueue.dequeue());
            } else {
                linkedQueue.enqueue(linkedQueue.dequeue());
            }
            count++;
        }

    }
}
