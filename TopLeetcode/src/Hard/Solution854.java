package Hard;

import java.util.HashMap;

//https://leetcode.com/problems/k-similar-strings/
public class Solution854 {
    HashMap<String, Integer> hm;

    public int kSimilarity(String s1, String s2) {
        hm = new HashMap<>();
        return solve(0, s1.toCharArray(), s2);
    }

    int solve(int idx, char[] arr, String s2) {
        String s1 = new String(arr);

        if (s1.equals(s2)) return 0;

        if (hm.containsKey(s1)) return hm.get(s1);

        if (hm.containsKey(idx)) return hm.get(idx);
        if (idx >= s2.length()) return 0;
        if (arr[idx] == s2.charAt(idx)) return solve(idx + 1, arr, s2);
        int count = Integer.MAX_VALUE;
        for (int i = idx + 1; i < s2.length(); i++) {
            if (arr[i] != s2.charAt(idx)) continue;
            swap(idx, i, arr);
            count = Math.min(count, 1 + solve(idx + 1, arr, s2));
            swap(idx, i, arr);
        }
        hm.put(s1, count);
        return count;
    }

    void swap(int i, int j, char[] arr) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        var app = new Solution854();
        var res = app.kSimilarity("aaaabbbbccccddddeeee", "bddceeceababeccddaab");
        System.out.println(res);
    }
}
