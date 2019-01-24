package _1_基础.union_find算法;

/*
* 加权的动态连接性算法
* */
public class WeightedQuickUnionUF {

    private int[] id; //触点作为索引的父链接数组

    private int[] sz; // 记录根节点对应的分量的大小(越大树越大，表示加权)

    private int count; // 分量计数器

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        for (int i = 0; i < N; i++) {
            sz[i] = 1; // 初始每一个根节点的分量大小都是自己1个
        }
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int a) {
        while (a != id[a]) a = id[a];
        return a;
    }

    // 联合两个分量，同时负责分量计数和加权的统计更新
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }
        count--; // 每次链接，都使得总分量数字减少一个
    }
}
