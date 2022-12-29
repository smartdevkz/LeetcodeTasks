package Medium;

//https://leetcode.com/problems/single-number-iii/
public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int n : nums) {
            bitmask ^= n;
        }
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int n : nums) {
            if ((diff & n) != 0)
                x ^= n;
        }
        return new int[]{x, (bitmask ^ x)};
    }
}
