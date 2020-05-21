public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 2, 1, -3 };
        int target = 1;
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
        insertSort(nums);

        int center = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - target;
            if (center == -1 && nums[i] >= 0) {
                center = i;
            }
        }

        int start = center >= 3 ? center - 3 : 0;
        int end = (center + 2) < nums.length ? (center + 2) : nums.length - 1;
        return findSum(nums, start, end) + 3 * target;
    }

    public static int findSum(int[] nums, int start, int end) {
        Integer min = null;
        for (int i = start; i <= end - 2; i++) {
            int sum = nums[i] + nums[i + 1] + nums[i + 2];
            if (min == null) {
                min = sum;
            } else {
                if (Math.abs(min) > Math.abs(sum))
                    min = sum;
            }
        }
        return min;
    }

    public static void insertSort(int[] nums) {
        int n = nums.length;
        for (int k = 1; k < n; k++) {
            int cur = nums[k];
            int j = k;
            while (j > 0 && nums[j - 1] > cur) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = cur;
        }
    }

    static void println(Object x) {
        System.out.println(x);
    }
}