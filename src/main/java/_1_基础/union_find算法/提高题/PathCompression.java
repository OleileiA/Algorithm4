package _1_基础.union_find算法.提高题;

// 实现路径压缩的加权quick-union算法

/*
* 实现思路：
* 更改find的实现方式，将分量直接连接到根节点上。
* 为find方法增加一个for循环，将寻找根节点的路径上的所有的分量都连接到根节点上。
* 这样我们可以得到一个接近于扁平的树。
* 这已经是目前已知的最优算法， 虽然在均摊后仍不是常数级别的。
* 而且不存在其他算法在(cell probe模型下)能保证常熟级别的操作。
* */


public class PathCompression {

    private int[] id; //触点作为索引的父链接数组

    private int[] sz; // 记录根节点对应的分量的大小(越大树越大，表示加权)

    private int count; // 分量计数器

    public PathCompression(int N) {
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
        int begin = a;
        while (a != id[a]) {
            a = id[a];
        }
        while (begin != a) { // 此时的a已经代表根的值
            int tmp = id[begin];
            id[begin] = a; // 指向根
            begin = tmp;
        }
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

    public static void main(String[] args) {
        PathCompression pathCompression = new PathCompression(10);
        pathCompression.union(0, 1);
        pathCompression.union(1, 2);
        pathCompression.union(2, 3);
        pathCompression.union(3, 4);
        pathCompression.union(0, 9);
        System.out.print(pathCompression.connected(9, 4));
    }
}
