package Easy;

//1929. Concatenation of Array
public class Solution1929 {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];
        System.arraycopy(nums, 0, ans, 0, nums.length);
        System.arraycopy(nums, 0, ans, nums.length, nums.length);
        return ans;
    }
}
