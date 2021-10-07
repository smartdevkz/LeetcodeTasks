package Easy;

import utils.Utils;

//1876. Substrings of Size Three with Distinct Characters
public class Solution1876 {
    public static void main(String[] args) {
        new Solution1876().countGoodSubstrings("aababcabc");
    }

    public int countGoodSubstrings(String s) {
        int k = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (isGood(s.substring(i, i + 3))) {
                k++;
                Utils.print(s.substring(i, i + 3));
            }
        }
        return k;
    }

    boolean isGood(String s) {
        return s.charAt(0) != s.charAt(1) && s.charAt(0) != s.charAt(2) && s.charAt(1) != s.charAt(2);
    }
}
