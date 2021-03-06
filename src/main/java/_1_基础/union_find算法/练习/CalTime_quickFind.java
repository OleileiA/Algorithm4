package _1_基础.union_find算法.练习;


/*
*  在一台每秒处理10^9条指令的计算机上，估计quick-find算法解决10^9个触点和10^6条连接的动态链接性问题所需要的最短的时间
* （以天为单位）
* （假设内循环for每次迭代需要执行10条机器指令）
*
* 感觉题目阐述的不是很清楚，需要计算的是什么情况，暂时理解为一开始没有任何两个点是联通的，然后使用10^9个点一直连通到10^6条分量的用时。
* */



/*
* 这道题也不适合使用代码计算，阐述思想估算时间。
*
*   1. 首先10^9个触点，那么数组的长度也就是10^9
*   2. quick-find中find是常数算法，union是线性的N
*   3. 任意一次连接都需要for循环头到尾，所以不存在什么策略。
*   4. 每一次union都会让连接数减少1
*
*   所以可以有两个种思考方式：
*   1. 10^9个节点，初始就是10^9个分量，那么减少到10^6个分量需要连接 10^9 - 10^6 次
*   2. 9/6 = 3, 说明平均1000个节点组成一条分量。 那么需要999次链接成一条分量，一共10^6个分量。
*
*   然后每次循环最内层10条机器指令，那么循环长度10^9的数组需要， 10^10的指令数量。 完成的for循环一次需要10秒
*   总时间 = 999 * 10 * 10^6 = 999 * 10^7 = 9,990,000,000 (s) / 60 /60 / 24 = 115,625天 = 316.78年
*
*   不知道是不是对题目的理解有误差，到处都找不到答案。
*
* */

public class CalTime_quickFind {

}
