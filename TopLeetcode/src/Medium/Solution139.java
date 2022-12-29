package Medium;

import java.util.*;

//https://leetcode.com/problems/word-break/
public class Solution139 {
    HashSet<String> hs = null;
    int minLen = 0, maxLen = 0;
    String s = "";
    Boolean[] memo = null;

    public boolean wordBreak(String s, List<String> wordDict) {
        hs = new HashSet<>(wordDict);
        minLen = wordDict.get(0).length();
        maxLen = wordDict.get(0).length();
        this.s = s;
        memo = new Boolean[s.length()];
        for (var w : wordDict) {
            if (minLen > w.length()) minLen = w.length();
            if (maxLen < w.length()) maxLen = w.length();
        }
        return solve(0);
    }

    boolean solve(int idx) {
        if (idx == s.length()) return true;
        if (memo[idx] != null) return memo[idx];
        boolean res = false;
        for (int i = idx + 1; i <= s.length(); i++) {
            var key = s.substring(idx, i);
            if (key.length() < minLen) continue;
            if (key.length() > maxLen) break;
            System.out.println("s=" + s + " key=" + key);
            if (hs.contains(key)) {
                res = res || solve(i);
                if (res == true) {
                    memo[idx] = true;
                    return true;
                }
            }
        }
        memo[idx] = res;
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        var dict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        //String s = "leetcode";
        //var dict = Arrays.asList("leet", "code");
        var app = new Solution139();
        var res = app.wordBreak(s, dict);
        System.out.println(res);
    }
}

/*
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
 */