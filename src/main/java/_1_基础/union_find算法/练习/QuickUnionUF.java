package _1_基础.union_find算法.练习;

/* 使用quick-union实现，动态连通算法 */

public class QuickUnionUF {

    private int[] arr;

    private int count;

    public int count() {
        return count;
    }

    public QuickUnionUF(int N) {
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        count = N;
    }

    public int find(int p) {
        while (p != arr[p]) p = arr[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) return;
        arr[pRoot] = qRoot;
        count--;
    }
}
