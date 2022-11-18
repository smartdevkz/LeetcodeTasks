package Hard;

import java.util.Arrays;

//https://leetcode.com/problems/booking-concert-tickets-in-groups/
public class Solution2286 {
    class BookMyShow {
        int[] arr;
        int m;

        int start = 0;

        public BookMyShow(int n, int m) {
            this.arr = new int[n];
            Arrays.fill(this.arr, m);
            this.m = m;
        }

        public int[] gather(int k, int maxRow) {
            if (k > m) return new int[]{};
            for (int i = start; i <= maxRow; i++) {
                if (arr[i] >= k) {
                    arr[i] = arr[i] - k;
                    int col = m - arr[i] - k;
                    return new int[]{i, col};
                }
            }
            return new int[]{};
        }

        public boolean scatter(int k, int maxRow) {
            int idx = start;
            while (idx <= maxRow && k > arr[idx]) k -= arr[idx++];
            if (idx > maxRow && k > 0) return false;
            arr[idx] -= k;
            start = idx;
            return true;
        }
    }

    public static void main(String[] args) {
        var app = new Solution2286();
        app.run();
        System.out.println("end!");
    }

    private void run() {
        var obj = new BookMyShow(3, 999999999);
        System.out.println(obj.scatter(1000000000, 2));
        System.out.println(obj.scatter(999999999, 2));
        System.out.println(obj.gather(999999999, 2));
        System.out.println(obj.gather(999999999, 2));
    }

    /*
["BookMyShow","scatter","gather","gather","gather"]
[[3,999999999],[1000000000,2],[999999999,2],[999999999,2],[999999999,2]]
    * */
}
