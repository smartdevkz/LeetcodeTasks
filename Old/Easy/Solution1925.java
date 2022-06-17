package Easy;

import java.util.HashMap;

//https://leetcode.com/problems/count-square-sum-triples/
public class Solution1925 {
    public static void main(String[] args) {
        var app = new Solution1925();
        System.out.println(app.countTriples(18));
    }

    public int countTriples(int n) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (hm.containsKey(i)) {
                count+=hm.get(i);
                System.out.println(i + " " + hm.get(i));
            }
            for (int j = i + 1; (i * i + j * j <= n * n); j++) {
                double sum = i * i + j * j;
                long d = (long) (Math.sqrt(sum) + 0.5);
                if (d * d == sum) {
                    count++;
                    hm.put(j, hm.getOrDefault(j, 0) + 1);
                    System.out.println(i + " " + j + " " + d);
                }
            }
        }
        return count;
    }
}
