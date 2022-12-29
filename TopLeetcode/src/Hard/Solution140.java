package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution140 {
    HashSet<String> hs = null;
    String s = null;

    public List<String> wordBreak(String s, List<String> wordDict) {
        hs = new HashSet<>(wordDict);
        this.s = s;
        var res = new ArrayList<String>();
        solve(0, "", res);
        return res;
    }

    void solve(int idx, String str, List<String> res) {
        if (idx == s.length()) {
            res.add(str);
            return;
        }

        for (int i = idx + 1; i <= s.length(); i++) {
            String key = s.substring(idx, i);
            if (hs.contains(key)) {
                solve(i, str + (str.isEmpty() ? "" : " ") + key, res);
            }
        }
    }

    public static void main(String[] args) {
        var app = new Solution140();
        var res = app.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        for (var r : res) {
            System.out.println(r);
        }
    }
}
