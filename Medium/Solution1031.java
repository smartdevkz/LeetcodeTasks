package Medium;

import java.util.HashMap;

//https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
public class Solution1031 {
    public static void main(String[] args) {
        var app = new Solution1031();
        int[] nums = new int[] { 1, 0, 1 };
        int res = app.maxSumTwoNoOverlap(nums, 1, 1);
        System.out.println(res);
    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max = 0;
        var r1 = getMaxRight(nums, firstLen);
        var l1 = getMaxLeft(nums, firstLen);
        var r2 = getMaxRight(nums, secondLen);
        var l2 = getMaxLeft(nums, secondLen);

        for (int i = 0; i < nums.length; i++) {
            if (l1.containsKey(i - 1) && r2.containsKey(i)) {
                max = Math.max(max, l1.get(i - 1) + r2.get(i));
            }
            if (l2.containsKey(i - 1) && r1.containsKey(i)) {
                max = Math.max(max, l2.get(i - 1) + r1.get(i));
            }
        }

        return max;
    }

    HashMap<Integer, Integer> getMaxRight(int[] nums, int len) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int s = 0;
        for (int i = 0; i < len; i++) {
            s += nums[nums.length - 1 - i];
        }
        int max = s;
        hm.put(nums.length - len, s);
        for (int i = nums.length - len - 1; i >= 0; i--) {
            s = s + nums[i] - nums[i + len];
            max = Math.max(max, s);
            hm.put(i, max);
        }
        return hm;
    }

    HashMap<Integer, Integer> getMaxLeft(int[] nums, int len) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int s = 0;
        for (int i = 0; i < len; i++) {
            s += nums[i];
        }
        int max = s;
        hm.put(len - 1, s);
        for (int i = len; i < nums.length; i++) {
            s = s + nums[i] - nums[i - len];
            max = Math.max(max, s);
            hm.put(i, max);
        }
        return hm;
    }

}
