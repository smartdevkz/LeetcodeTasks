package Easy;

import utils.Utils;

//1047. Remove All Adjacent Duplicates In String
public class Solution1047 {
    public static void main(String[] args) {
        var app = new Solution1047();
        Utils.print(app.removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) {
        if (s.length() == 1)
            return s;
        var sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 1) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.deleteCharAt(i + 1);
                sb.deleteCharAt(i);
                i--;
                if (i < 0 && sb.length() > 0)
                    i = 0;
            } else {
                i++;
            }
        }
        return sb.toString();
    }

}
