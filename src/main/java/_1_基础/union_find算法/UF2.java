package _1_基础.union_find算法;

/*

 * 使用数组来实现union-find
 *
 * */

public class UF2 {

    private int[] id; // 分量id，（使用触点作为索引）

    private int count; // 分量数量

    public UF2(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    // 判断两个触点是否相连
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // find方法可以返回触点所在的分量的标识符
    public int find(int p) {
        while (p != id[p]) p = id[p]; // 寻找根节点的索引
        return p;
    }

    // union 是实现联通两个触点的方法
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot; // 把根节点的索引对应的值，修改为另一根节点，联通了两个分量。
        count--;
    }
}
