package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1584 {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        List<List<Integer>> weights = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int destination = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                weights.add(List.of(destination, i, j));
            }
        }

        Collections.sort(weights, (lst1, lst2) -> Integer.compare(lst1.get(0), lst2.get(0)));

        UnionFind uf = new UnionFind(n);

        int cost = 0;
        for (int i = 0; i < weights.size(); i++) {
            var w = weights.get(i);

            if (uf.union(w.get(1), w.get(2))) {
                cost += w.get(0);
            }
        }

        return cost;
    }

    public class UnionFind {
        public int[] group;
        public int[] rank;

        public UnionFind(int size){
            group = new int[size];
            rank = new int[size];

            for(int i = 0; i < size; i++) {
                group[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (group[x] == x) return x;
            return find(group[x]);
        }

        public boolean union(int x, int y) {
            x = find(x);
            y = find(y);

            if (x == y) return false;

            if (rank[x] > rank[y]) {
                group[y] = x;
            } else if (rank[x] < rank[y]) {
                group[x] = y;
            } else {
                group[y] = x;
                rank[x]++;
            }

            return true;
        }
    }
}
