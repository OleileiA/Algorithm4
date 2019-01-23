package _1_基础.union_find算法.练习;

/* 使用quick-find算法实现，动态连通性问题 */

public class QuickFindUF {

    private int[] id;

    private int count;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = N;
    }

    public int count() {
        return count;
    }

    public int find(int q) {
        return id[q];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int a = find(p);
        int b = find(q);
        if (a == b) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == a) id[i] = b;
        }
        count--;
    }

}
