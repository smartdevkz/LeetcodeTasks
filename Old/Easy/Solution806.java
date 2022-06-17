package Easy;

//806. Number of Lines To Write String
public class Solution806 {
    public int[] numberOfLines(int[] widths, String s) {
        int sum = 0;
        int k = 1;
        for (var ch : s.toCharArray()) {
            int w = widths[ch - 'a'];
            sum += w;
            if (sum > 100) {
                sum = w;
                k++;
            }
        }
        return new int[] { k, sum };
    }
}
