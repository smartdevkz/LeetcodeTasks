import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 0 };
        List<List<Integer>> res = threeSum(nums);
        displayList(res);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;

        insertSort(nums);

        int min = nums[0];
        int max = nums[nums.length - 1];

        if (min > 0 || max < 0)
            return res;

        if (min == 0 || max == 0) {
            int zeroCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroCount++;
                    if (zeroCount == 3) {
                        List<Integer> lst = new ArrayList<>();
                        lst.add(0);
                        lst.add(0);
                        lst.add(0);
                        res.add(lst);
                        return res;
                    }
                }
            }
            if (zeroCount < 3)
                return res;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            int curr = -1 * nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            Integer prevLeftVal = null;
            while (left < right) {
                if (prevLeftVal != null && prevLeftVal == nums[left]) {
                    left++;
                    continue;
                }
                int sum = nums[left] + nums[right];

                if (sum > curr) {
                    right--;
                } else if (sum < curr) {
                    left++;
                } else {
                    AddToList(res, nums[i], nums[left], nums[right]);
                    prevLeftVal = nums[left];
                    left++;
                    right--;
                }

            }
        }

        return res;
    }

    public static void AddToList(List<List<Integer>> res, int a, int b, int c) {
        List<Integer> lst = new ArrayList<>();
        lst.add(a);
        lst.add(b);
        lst.add(c);
        res.add(lst);
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

    public static void display(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
        System.out.println("");
    }

    public static void displayList(List<List<Integer>> lst) {
        for (List<Integer> list : lst) {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println("");
        }
    }
}