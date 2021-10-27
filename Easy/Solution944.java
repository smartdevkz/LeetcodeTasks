package Easy;

//944. Delete Columns to Make Sorted
public class Solution944 {
    public int minDeletionSize(String[] strs) {
        if (strs.length == 1)
            return 0;
        int col = 0;
        int count = 0;
        while (col < strs[0].length()) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i - 1].charAt(col) > strs[i].charAt(col)) {
                    count++;
                    break;
                }
            }
            col++;
        }
        return count;
    }
}
