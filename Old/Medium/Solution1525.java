package Medium;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
public class Solution1525 {
    public static void main(String[] args) {
        var app = new Solution1525();
        var res = app.numSplits3("aacaba");
        System.out.println(res);
    }

    public int numSplits3(String str) {
        int l[] = new int[26], r[] = new int[26], d_l = 0, d_r = 0, res = 0;
        var s = str.toCharArray();
        for (char ch : s)
            d_r += ++r[ch - 'a'] == 1 ? 1 : 0;
        for (int i = 0; i < s.length; ++i) {
            d_l += ++l[s[i] - 'a'] == 1 ? 1 : 0;
            d_r -= --r[s[i] - 'a'] == 0 ? 1 : 0;
            res += d_l == d_r ? 1 : 0;
        }
        return res;
    }

    public int numSplits(String s) {
        int res = 0;
        HashMap<Character, Integer> hmLeft = new HashMap<>();
        HashMap<Character, Integer> hmRight = new HashMap<>();
        for (Character c : s.toCharArray()) {
            int count = hmRight.getOrDefault(c, 0);
            hmRight.put(c, ++count);
        }

        for (Character c : s.toCharArray()) {
            int count1 = hmLeft.getOrDefault(c, 0);
            hmLeft.put(c, ++count1);

            int count2 = hmRight.get(c);
            if (count2 == 1) {
                hmRight.remove(c);
            } else {
                hmRight.put(c, --count2);
            }

            if (hmLeft.size() == hmRight.size()) {
                res++;
            }
        }

        

        return res;
    }

    public int numSplits2(String s) {
        if (s.length() < 2)
            return 0;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, s.length());
            System.out.println(s1 + " : " + s2);
            if (isGood(s1, s2))
                count++;
        }
        return count;
    }

    boolean isGood(String s1, String s2) {
        var hs1 = new HashSet<Character>();
        for (var c : s1.toCharArray()) {
            hs1.add(c);
        }
        var hs2 = new HashSet<Character>();
        for (var c : s2.toCharArray()) {
            hs2.add(c);
        }
        return hs1.size() == hs2.size();
    }
}
