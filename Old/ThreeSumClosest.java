public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[] { -3, -2, -5, 3, -4 };
        int target = -1;
        int res = threeSumClosest(nums, target);
        System.out.println(res);
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        if (nums.length < 4) {
            int sum = 0;
            for (int item : nums) {
                sum += item;
            }
            return sum;
        }

        int minDiff = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int d = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    if (minDiff > d) {
                        minDiff = d;
                        sum = nums[i] + nums[j] + nums[k];
                    }
                }

            }
        }
        return sum;
    }

}