package Easy;

//1470. Shuffle the Array
public class Solution1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = 0; i < 2 * n; i += 2) {
            int j = i / 2;
            res[i] = nums[j];
            res[i + 1] = nums[n + j];
        }
        return res;
    }

}
