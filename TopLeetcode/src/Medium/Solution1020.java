package Medium;

public class Solution1020 {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        UnionFind uf = new UnionFind(n * m + 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int val = grid[i][j];
                int root = i * m + j;

                if (val == 0) {
                    uf.union(root, n * m);
                } else {

                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        int prev = (i - 1) * m + j;
                        uf.union(prev, root);
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        int prev = i * m + j - 1;
                        uf.union(prev, root);
                    }

                }
            }
        }

        for (int i = 0; i < m; i++) {
            uf.union(0 * m + i, n * m);
            uf.union((n - 1) * m + i, n * m);
        }

        for (int i = 0; i < n; i++) {
            uf.union(i * m + 0, n * m);
            uf.union(i * m + m - 1, n * m);
        }

        int x = uf.find(n * m);
        int count = 0;
        for (int i = 0; i < n * m; i++) {
            if (uf.find(i) == x) {
                count++;
            }
        }

        return n * m - count;

    }

    public class UnionFind {

        int[] groups;
        int[] ranks;

        public UnionFind(int size) {

            groups = new int[size];
            ranks = new int[size];

            for (int i = 0; i < groups.length; i++) {
                groups[i] = i;
                ranks[i] = 0;
            }

            ranks[size - 1] = 1000;

        }

        public int find(int x) {
            if (groups[x] == x) return x;
            return find(groups[x]);
        }

        public boolean union(int x, int y) {
            x = find(x);
            y = find(y);

            if (x == y) return false;

            if (ranks[x] > ranks[y]) {
                groups[y] = x;
            } else if (ranks[y] > ranks[x]) {
                groups[x] = y;
            } else {
                groups[y] = x;
                ranks[x]++;
            }

            return true;
        }

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        var app = new Solution1020();
        int res = app.numEnclaves(grid);

        System.out.println(res);
    }
}
