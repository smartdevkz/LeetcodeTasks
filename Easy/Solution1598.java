package Easy;

import utils.Utils;

//1598. Crawler Log Folder
public class Solution1598 {
    public static void main(String[] args) {
        var app = new Solution1598();
        var res = app.minOperations(new String[] { "d1/", "d2/", "../", "d21/", "./" });
        Utils.print(res);
    }

    public int minOperations(String[] logs) {
        int k = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].contains("..")) {
                if (k > 0)
                    k--;
            } else if (logs[i].contains(".")) {

            } else {
                k++;
            }
        }
        return k;
    }
}
