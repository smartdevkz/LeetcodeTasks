package Easy;

import java.util.HashMap;

//1748. Sum of Unique Elements
public class Solution1748 {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hs.put(nums[i], hs.getOrDefault(nums[i], 0) + 1);
        }

        int sum = 0;
        for (var number : hs.keySet()) {
            if (hs.get(number) == 1)
                sum += number;
        }
        return sum;
    }
}
