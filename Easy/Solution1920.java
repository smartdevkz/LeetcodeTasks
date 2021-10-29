package Easy;

import java.util.stream.IntStream;

//1920. Build Array from Permutation
public class Solution1920 {
    public int[] buildArray(int[] nums) {
        return IntStream.of(nums).map(i -> nums[i]).toArray();
    }
}
