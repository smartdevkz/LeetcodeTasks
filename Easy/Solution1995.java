package Easy;

import java.util.Arrays;

import utils.Utils;

//1995. Count Special Quadruplets
public class Solution1995 {
    public static void main(String[] args) {
        int[] arr = new int[] { 28, 8, 49, 85, 37, 90, 20, 8 };
        var app = new Solution1995();
        Utils.print(app.countQuadruplets(arr));
    }

    public int countQuadruplets(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] == nums[j])
                    continue;
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (nums[j] == nums[k])
                        continue;
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[k] == nums[l])
                            continue;
                        int sum = nums[i] + nums[j] + nums[k];
                        if (sum == nums[l]) {
                            count++;
                        } else if (sum < nums[l]) {
                            break;
                        }
                    }
                }
            }

        }
        return count;
    }
}
