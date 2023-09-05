package Medium;

//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
public class Solution698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        var total = 0;
        for (int n : nums) {
            total += n;
        }

        if (total % k != 0) {
            return false;
        }

        int target = total / k;

        boolean[] visited = new boolean[nums.length];

        return dfs(nums, 0, nums.length - 1, visited, target, k);
    }

    private boolean dfs(int[] nums, int sum, int start, boolean[] visited, int target, int round) {
        if (round == 0) return true;

        if (sum == target && dfs(nums, 0, nums.length - 1, visited, target, round - 1)) {
            return true;
        }

        for (int i = start; i >= 0; i--) {
            if (!visited[i] && sum + nums[i] <= target) {
                visited[i] = true;
                if (dfs(nums, sum + nums[i], i - 1, visited, target, round)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        var app = new Solution698();
        var nums = new int[]{3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269};
        System.out.println(app.canPartitionKSubsets(nums, 5));
    }
}
