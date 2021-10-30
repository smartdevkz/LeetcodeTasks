package Easy;

//1304. Find N Unique Integers Sum up to Zero
public class Solution1304 {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            res[i] = i;
            sum += res[i];
        }
        res[0] = -1 * sum;
        return res;
    }
}
