package Easy;

import utils.Utils;

//1974. Minimum Time to Type Word Using Special Typewriter
public class Solution1974 {
    public static void main(String[] args) {
        var app = new Solution1974();
        var res = app.minTimeToType("zj");
        Utils.print(res);
    }

    public int minTimeToType(String word) {
        int count = 0;
        int pos = 0;
        for (Character ch : word.toCharArray()) {
            int i = ch - 'a';
            int diff = Math.abs(pos - i);
            count += Math.min(diff, 26 - diff) + 1;
            pos = i;
        }
        return count;
    }
}
