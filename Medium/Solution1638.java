package Medium;

import java.util.HashMap;

//https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
public class Solution1638 {

    public static void main(String[] args) {
        var app = new Solution1638();
        var res = app.countSubstrings("aba", "baba");
        System.out.println(res);
    }

    public int countSubstrings(String s, String t) {
        HashMap<String, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String substr = s.substring(i, j);
                System.out.println(substr);
                int substrCount = hm.getOrDefault(substr, getSubstrCount(substr, t));
                hm.put(substr, substrCount);
                count += substrCount;
            }
        }
        return count;
    }

    private int getSubstrCount(String s, String p) {
        int k = 0;
        for (int i = 0; i < p.length() - s.length() + 1; i++) {
            boolean isSubstr = true;
            int d = 0;
            for (int j = 0; j < s.length(); j++) {
                if (p.charAt(i + j) != s.charAt(j)) {
                    d++;
                }
                if (d > 1) {
                    isSubstr = false;
                    break;
                }
            }
            if (isSubstr && d == 1)
                k++;
        }
        return k;
    }
}
