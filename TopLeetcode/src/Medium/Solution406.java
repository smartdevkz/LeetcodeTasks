package Medium;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/queue-reconstruction-by-height/
public class Solution406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] > b[0]) {
                    return 1;
                } else if (a[0] < b[0]) {
                    return -1;
                } else {
                    if (a[1] > b[1]) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        //display(people);

        System.out.println(" ");

        var result = new int[people.length][people[0].length];

        Arrays.fill(result, new int[]{-1, -1});

        SegmentTree st = new SegmentTree(people.length);
        st.display();


        for (int i = 0; i < people.length; i++) {

            int h = people[i][0];
            int count = people[i][1];

            int idx = st.find(1, 0, people.length - 1, count + 1);

            result[idx] = new int[]{h, count};

            st.update(1, 0, people.length - 1, idx, 0);

        }

        /*
        for (int i = 0; i < people.length; i++) {

            int h = people[i][0];
            int count = people[i][1];

            for (int j = 0; j < result.length; j++) {

                if (result[j][0] >= 0) {
                    if (result[j][0] >= h) {
                        count--;
                    }
                } else {
                    if (count == 0) {
                        result[j] = new int[]{people[i][0], people[i][1]};
                        break;
                    } else {
                        count--;
                    }
                }

            }

        }


         */

        display(result);

        return result;
    }

    private void display(int[][] people) {
        for (var r : people) {
            for (var c : r) {
                System.out.print(c + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        var people = new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        var app = new Solution406();

        app.reconstructQueue(people);

        System.out.println("");
        System.out.println((0 << 1));
        System.out.println((0 << 1) | 1);
        //app.run();
    }

    public class SegmentTree {

        int[] tree;

        public SegmentTree(int n) {

            tree = new int[4 * n];

            int[] v = new int[n];
            Arrays.fill(v, 1);
            build(v, 1, 0, n - 1);

        }

        void build(int[] nums, int x, int left, int right) {
            if (left == right) {
                tree[x] = nums[left];
                return;
            }
            int mid = (left + right) / 2;
            build(nums, 2 * x, left, mid);
            build(nums, 2 * x + 1, mid + 1, right);
            tree[x] = tree[2 * x] + tree[2 * x + 1];
            return;
        }

        public void display() {
            System.out.println();
            for (var item : tree) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        void update(int x, int left, int right, int index, int value) {
            if (left == right) {
                tree[x] = value;
                return;
            }
            int mid = (left + right) / 2;
            if (index > mid) {
                update(2 * x + 1, mid + 1, right, index, value);
            } else {
                update(2 * x, left, mid, index, value);
            }
            tree[x] = tree[2 * x] + tree[2 * x + 1];
            return;
        }

        //find the k-th available leaf node
        int find(int x, int left, int right, int k) {
            if (left == right) {
                return left;
            }

            int mid = (left + right) / 2;
            if (k <= tree[2 * x]) {
                return find(2 * x, left, mid, k);
            } else {
                return find(2 * x + 1, mid + 1, right, k - tree[2 * x]);
            }
        }
    }

}
