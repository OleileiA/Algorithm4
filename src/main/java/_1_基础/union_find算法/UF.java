package _1_基础.union_find算法;

/*

* 使用数组来实现union-find
*
* */

public class UF {

    private int[] id; // 分量id，（使用触点作为索引）

    private int count; // 分量数量

    public UF(int N) {
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
        return id[p];
    }

    // union 是实现联通两个触点的方法
    // 这是最普通的实现，每一次的union都需要遍历一次数组
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
        }
        count--;
    }
}
